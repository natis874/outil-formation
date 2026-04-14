package org.tamyass.outilformation.service.impl;

import org.springframework.stereotype.Service;
import org.tamyass.outilformation.dto.UserDTO;
import org.tamyass.outilformation.entities.User;
import org.tamyass.outilformation.exception.ClientNotFoundException;
import org.tamyass.outilformation.mapper.UserMapper;
import org.tamyass.outilformation.repository.UserRepository;
import org.tamyass.outilformation.service.UserService;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .toList();
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElseThrow(()-> new ClientNotFoundException(id));
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }
}
