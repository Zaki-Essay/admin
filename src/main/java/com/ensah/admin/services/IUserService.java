package com.ensah.admin.services;

import com.ensah.admin.dtos.UserSignupDTO;
import com.ensah.admin.entities.User;
import org.springframework.http.ResponseEntity;

public interface IUserService {

    ResponseEntity<User> getUserByID(Long id);

    ResponseEntity<User> getUserByUsername(String username);

    ResponseEntity<User> updateUser(User u, Long id);

    ResponseEntity<User> deleteUser(Long id);

    //by krach achraf
    ResponseEntity<String> addUser(UserSignupDTO userSignup);

    //by krach achraf
    void setLocking(String username, boolean locking);

    //by krach achraf
    void updatePassword(String username, String password);

    User getUserByUsernameOrEmail(String usernameOrEmail);
}
