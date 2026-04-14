package org.tamyass.outilformation.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tamyass.outilformation.dto.UserDTO;
import org.tamyass.outilformation.entities.User;
import org.tamyass.outilformation.service.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private UserService userService;
    public UserRestController(UserService userService) {
        this.userService = userService;
    }
    // GET /api/users
    @GetMapping("/{id}")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO userCreated = userService.createUser(userDTO);
        URI location =URI.create("/api/users/"+ userCreated.getId());
        return ResponseEntity.created(location).body(userCreated);
    }
}
