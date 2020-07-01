package com.example.contracts.services;

import com.example.contracts.controllers.dto.UserDto;
import com.example.contracts.entities.User;
import com.example.contracts.repositories.UserDataRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDataRepository userDataRepository;

    public List<UserDto> getUserByName(String name) {
        return toDto(userDataRepository.findByName(name));
    }

    public void createUser(UserDto userDto) {
        userDataRepository.createUser(toEntity(userDto));
    }

    private User toEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getLastName().hashCode()+userDto.getName().hashCode()+"")
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .build();
    }

    private UserDto toDto(User user) {
        return UserDto.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .build();
    }

    private List<UserDto> toDto(List<User> users){
        List<UserDto> userDtoList = new ArrayList<>();
        users.forEach(user -> {
            userDtoList.add(UserDto.builder()
                    .name(user.getName())
                    .lastName(user.getLastName())
                    .build());

        });
        return userDtoList;
    }
}
