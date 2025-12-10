package com.kubraevren.library.service;
import com.kubraevren.library.exception.ApplicationException;
import com.kubraevren.library.mapper.UserMapper;
import com.kubraevren.library.dto.UserRequestDto;
import com.kubraevren.library.dto.UserResponseDto;
import com.kubraevren.library.model.UserEntity;
import com.kubraevren.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserResponseDto addUser(UserRequestDto dto) {
       UserEntity  user=mapper.toEntity(dto);
        UserEntity kaydedilenVeri= userRepository.save(user);
       return mapper.toDto(kaydedilenVeri);
    }

    public UserResponseDto login(UserRequestDto dto) {
        UserEntity user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ApplicationException("Kullanıcı bulunamadı!"));
        if (!user.getPassword().equals(dto.getPassword())) {
            throw new ApplicationException("Şifre hatalı!");
        }
        UserResponseDto response = new UserResponseDto();
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());

        return response;
    }
}
