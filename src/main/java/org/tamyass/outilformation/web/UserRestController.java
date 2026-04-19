package org.tamyass.outilformation.web;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.tamyass.outilformation.dto.UserDTO;
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
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }
    // GET /api/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO userCreated = userService.createUser(userDTO);
        URI location =URI.create("/api/users/"+ userCreated.getId());
        return ResponseEntity.created(location).body(userCreated);
    }
    @GetMapping("/auth")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Authentication authentication(Authentication authentication) {
        return authentication;
        }

    @GetMapping("/test")
    public Object test(Authentication auth) {
        return auth.getAuthorities();
    }
}
