package com.ensah.admin.services.impl;

import com.ensah.admin.dao.UserDao;
import com.ensah.admin.entities.User;
import com.ensah.admin.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private UserDao userDao;

    @Override
    public ResponseEntity<User> getUserByID(Long id) {
        User user = userDao.findById(id).get();
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> getUserByUsername(String username) {
        User user = userDao.findUserByUsername(username);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> updateUser(User u, Long id) {
        User user = userDao.findById(id).get();
        if(user!=null) {
            user.setFullname(u.getFullname());
            user.setUsername(u.getUsername());
            user.setPhoneNumber(u.getPhoneNumber());
            user.setGender(u.getGender());
            user.setDateBirth(u.getDateBirth());
        }else {
            return ResponseEntity.status(400).build();
        }
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> deleteUser(Long id) {
        User user = userDao.findById(id).get();
        if(user!=null) {
            userDao.delete(user);
        }else {
            return ResponseEntity.status(400).build();
        }
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
}
