package com.kubraevren.library.service;
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

    public UserResponseDto login(UserRequestDto dto) { // LoginRequestDto yerine UserRequestDto yazdık

        // 1. Email kontrolü
        UserEntity user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı!"));

        // 2. Şifre kontrolü
        if (!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("Şifre hatalı!");
        }

        // 3. Cevap hazırlama
        UserResponseDto response = new UserResponseDto();
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());

        return response;
    }


    //userRepository bize id içeren (entity sınıfı yani) yeni bir entity fırlatır.

//DTO alıyoruz → çünkü dışarıdan gelen veri onun yapısında.
//Entity'ye çeviriyoruz → çünkü veritabanı onunla konuşur.
//Tekrar DTO döndürüyoruz → çünkü dışarıya Entity vermek yasak/güvensiz.
}
/*
dışardan gelen veri DTO'dur
dışarıya verilen veri de DTO'dur


Kullanıcıdan DTO gelir.
Service bunu Entity’ye çevirir.
Veritabanına kaydeder.



Veritabanından Entity döner.
Service tekrar DTO’ya çevirir.
Controller bunu kullanıcıya gönderir.


 */