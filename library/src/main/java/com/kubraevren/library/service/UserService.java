package com.kubraevren.library.service;

import com.kubraevren.library.dto.UserRequestDto;
import com.kubraevren.library.dto.UserResponseDto;
import com.kubraevren.library.exception.ApplicationException;
import com.kubraevren.library.mapper.UserMapper;
import com.kubraevren.library.model.UserEntity;
import com.kubraevren.library.repository.UserRepository;
import com.kubraevren.library.security.CustomUserDetails;
import com.kubraevren.library.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    // Eksik olanlar eklendi
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserResponseDto addUser(UserRequestDto dto) {
        UserEntity user = mapper.toEntity(dto);
        // Şifreyi hashleyerek kaydet
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        UserEntity savedUser = userRepository.save(user);
        return mapper.toDto(savedUser);
    }

    public UserResponseDto login(UserRequestDto dto) {
        // 1. Spring Security ile şifre doğrulaması
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
            );
        } catch (Exception e) {
            throw new ApplicationException("Email veya şifre hatalı!");
        }

        // 2. Kullanıcıyı veritabanından çek
        UserEntity user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ApplicationException("Kullanıcı bulunamadı!"));

        // 3. Token üret
        String token = jwtService.generateToken(new CustomUserDetails(user));

        // 4. DTO'ya çevir ve token'ı ekle
        UserResponseDto response = mapper.toDto(user);

        // DİKKAT: UserResponseDto içinde token alanı yoksa eklemelisin,
        // yoksa bu satırı response.setToken(token) şeklinde kullanamazsın.
        // Şimdilik yorum satırı değil, Budget app'teki gibi token dönmek için
        // UserResponseDto sınıfına 'private String token;' alanını eklediğini varsayıyorum.
        response.setToken(token);

        return response;
    }
}