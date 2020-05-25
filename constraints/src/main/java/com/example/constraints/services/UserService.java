package com.example.constraints.services;

import com.example.constraints.controllers.dto.UserDTO;
import com.example.constraints.entities.User;
import com.example.constraints.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public Page<UserDTO> getAllUsers(Pageable pageable) {
        return mapToDTO(userRepository.findAll(pageable));
    }

    public boolean existsUserByUserName(String userName){
        return userRepository.existsUserByUserName(userName);
    }

    public UserDTO create(UserDTO userDTO) {
        return convertEntityToDTO(userRepository.save(convertDTOToEntity(userDTO)));
    }

    private Page<UserDTO> mapToDTO(Page<User> users) {
        return users.map(UserDTO::fromEntity);
    }

    private User convertDTOToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    private UserDTO convertEntityToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}
