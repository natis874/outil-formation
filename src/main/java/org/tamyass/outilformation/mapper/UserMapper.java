package org.tamyass.outilformation.mapper;

import org.mapstruct.Mapper;
import org.tamyass.outilformation.dto.UserDTO;
import org.tamyass.outilformation.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);

}
