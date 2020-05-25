package com.example.constraints.controllers.dto;

import com.example.constraints.entities.User;
import com.example.constraints.validators.annotations.UsernameUnique;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    String name;
    String surname;
    @UsernameUnique
    String userName;

    public static UserDTO fromEntity(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(user.getUserName());
        userDTO.setSurname(user.getSurname());
        userDTO.setName(user.getName());

        return userDTO;
    }
}
