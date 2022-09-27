package com.ensah.admin.web;

import com.ensah.admin.entities.User;
import com.ensah.admin.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private IUserService userService;

    //find user by ID:
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable Long id) {
        return userService.getUserByID(id);
    }

    //find user by username:
    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    //update info user:
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User u,@PathVariable Long id) {
        return userService.updateUser(u, id);
    }

    //remove user:
    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
