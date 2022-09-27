package com.ensah.admin.services.impl;



import com.ensah.admin.dao.UserDao;
import com.ensah.admin.dtos.UserDto;
import com.ensah.admin.entities.User;
import com.ensah.admin.exceptions.UserNotFoundException;
import com.ensah.admin.mappres.IUserMapper;
import com.ensah.admin.services.IAdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor

public class AdminServiceImpl implements IAdminService {
    //@Autowired
    private UserDao userDao;
   // @Autowired
    private IUserMapper userMapper;


    @Override
    public UserDto saveUser(UserDto userDto) {

        User user=userMapper.fromUserDto(userDto);
        User savedUser = userDao.save(user);
        return userMapper.fromUser(savedUser);
    }




    @Override
    public List<UserDto> listUsers() {
        List<User> users = userDao.findAll();
        List<UserDto> userDtos = users.stream()
                .map(user -> userMapper.fromUser(user))
                .collect(Collectors.toList());

        return userDtos;
    }



    @Override
    public UserDto getUser(Long userId) throws UserNotFoundException {
        User user = userDao.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("user Not found"));
        return userMapper.fromUser(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {

        User user=userMapper.fromUserDto(userDto);
        User savedUser = userDao.save(user);
        return userMapper.fromUser(savedUser);
    }

    @Override
    public void deleteUser(Long userId){
        userDao.deleteById(userId);
    }


    @Override
    public List<UserDto> searchUsers(String keyword) {
        List<User> users=userDao.searchUser(keyword);
        List<UserDto> userDtos = users.stream().map(user -> userMapper.fromUser(user)).collect(Collectors.toList());
        return userDtos;
    }

   @Override
    public byte[] getPhoto(Long id) throws Exception{
        User u=userDao.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/spring-project/images/"+u.getPhoto()));
    }
    @Override
    public void uploadPhoto(MultipartFile file, Long id) throws Exception{
        User u=userDao.findById(id).get();
        u.setPhoto(file.getOriginalFilename());
        Files.write(Paths.get(System.getProperty("user.home")+"/spring-project/images/"+u.getPhoto()),file.getBytes());
        userDao.save(u);
    }

    @Override
    public UserDto findUserByUserName(String userName) throws UserNotFoundException {
        User user = userDao.findUserByUsername(userName);
        if(user==null){
            throw new UserNotFoundException("user not found whit username : "+userName);
        }
        UserDto userDto = userMapper.fromUser(user);

        return userDto;
    }


}
