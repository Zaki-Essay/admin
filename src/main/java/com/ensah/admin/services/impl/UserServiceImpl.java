package com.ensah.admin.services.impl;

import com.ensah.admin.dao.UserDao;
import com.ensah.admin.dtos.UserSignupDTO;
import com.ensah.admin.entities.Role;
import com.ensah.admin.entities.User;
import com.ensah.admin.mappres.IUserMapper;
import com.ensah.admin.services.IRoleService;
import com.ensah.admin.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private UserDao userDao;
    private IUserMapper userMapper;

    private IRoleService roleService;

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

    @Override
    public ResponseEntity<String> addUser(UserSignupDTO userSignup) {
        if(!userDao.existsByEmail(userSignup.getEmail()) &&
                !userDao.existsByUsername(userSignup.getUsername())){
            User user = userMapper.fromUserSignupDTO(userSignup);
            Role role = roleService.findByAuthority("ROLE_USER");
            if(role == null)
                role = roleService.save(new Role("ROLE_USER"));
            user.setAuthorities(List.of(role));
            userDao.save(user);
            return new ResponseEntity<>("User added", HttpStatus.valueOf(200));
        }
        return new ResponseEntity<>("User already exist", HttpStatus.valueOf(400));

    }

    //by krach achraf
    @Override
    public void setLocking(String username, boolean locking) {
        User user = userDao.findUserByUsername(username);
        user.setLocked(locking);
        userDao.save(user);
    }

    //by krach achraf
    @Override
    public void updatePassword(String username, String password) {
        User user = userDao.findUserByUsername(username);
        user.setPassword(password);
        userDao.save(user);
    }

    //by krach achraf
    @Override
    public User getUserByUsernameOrEmail(String usernameOrEmail) {
        return userDao.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
    }
}
