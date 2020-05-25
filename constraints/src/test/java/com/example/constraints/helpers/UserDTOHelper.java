package com.example.constraints.helpers;

import com.example.constraints.controllers.dto.UserDTO;

public class UserDTOHelper {
    private static int currentGeneratedUser = 0;
    public static UserDTO getNextUserDto() {
        return generatePlainUser(currentGeneratedUser++);
    }

    public static UserDTO generatePlainUser(int i) {
        return createNewUser("Name", "Surname", "Username");
    }

    private static UserDTO createNewUser(String name, String surname, String username) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(name);
        userDTO.setSurname(surname);
        userDTO.setUserName(username);
        return userDTO;
    }
}
