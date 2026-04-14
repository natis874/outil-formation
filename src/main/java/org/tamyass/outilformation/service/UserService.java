package org.tamyass.outilformation.service;

import org.tamyass.outilformation.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUser();

    UserDTO getUserById(Long id);

    UserDTO createUser(UserDTO userDTO);


}
