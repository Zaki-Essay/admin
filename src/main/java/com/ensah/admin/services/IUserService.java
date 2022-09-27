package com.ensah.admin.services;

import com.ensah.admin.entities.User;
import org.springframework.http.ResponseEntity;

public interface IUserService {

    ResponseEntity<User> getUserByID(Long id);

    ResponseEntity<User> getUserByUsername(String username);

    ResponseEntity<User> updateUser(User u, Long id);

    ResponseEntity<User> deleteUser(Long id);
}
