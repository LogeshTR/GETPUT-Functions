package com.getput.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // @GetMapping
    // public ResponseEntity<List<User>> getAllUsers() {
    //     List<User> userList = userService.getAllUsers();
    //     return ResponseEntity.ok(userList);
    // }

    @GetMapping("GetUser")
    public ResponseEntity<UserDTO> getUserById(@RequestParam Long id)
    {
    Optional<UserDTO> userOptional = userService.getUserById(id);

    return userOptional.map(user -> ResponseEntity.ok(user))
        .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("AddUser")
    public ResponseEntity<Object> createUser(@RequestBody UserDTO userDTO) {
        UserDTO Logesh = userService.createUser(userDTO);
        if (Logesh != null)
        {
            return new ResponseEntity<>(Logesh, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Wallet not configured", HttpStatus.OK);
        }
    }
    

    // @PutMapping("/{userId}")
    // public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
    //     User updatedUser = userService.updateUser(userId, user);
    //     if (updatedUser != null) {
    //         return ResponseEntity.ok(updatedUser);
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    // @DeleteMapping("/{userId}")
    // public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
    //     boolean isDeleted = userService.deleteUser(userId);
    //     if (isDeleted) {
    //         return ResponseEntity.noContent().build();
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }
}
