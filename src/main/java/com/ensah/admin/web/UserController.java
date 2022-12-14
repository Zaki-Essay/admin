package com.ensah.admin.web;

import com.ensah.admin.dtos.UserSignupDTO;
import com.ensah.admin.entities.User;
import com.ensah.admin.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private IUserService userService;

    //find user by ID:
    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable Long id) {
        return userService.getUserByID(id);
    }

    //find user by username:
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    //update info user:
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User u,@PathVariable Long id) {
        return userService.updateUser(u, id);
    }

    //remove user:
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    //by krach achraf
    @PostMapping("/save")
    public ResponseEntity<String> addUser(@RequestBody UserSignupDTO userSignup) {
        return userService.addUser(userSignup);
    }

    //by krach achraf
    @PutMapping("/locking/{username}/{locking}")
    public void setLocking(@PathVariable String username, @PathVariable boolean locking) {
        userService.setLocking(username, locking);
    }

    //by krach achraf
    @PutMapping("/password/{username}/{password}")
    public void updatePassword(@PathVariable String username,@PathVariable String password) {
        userService.updatePassword(username, password);
    }

    //by krach achraf
    @GetMapping("/get/{usernameOrEmail}")
    public User getUserByUsernameOrEmail(@PathVariable String usernameOrEmail) {
        return userService.getUserByUsernameOrEmail(usernameOrEmail);
    }
}
