package com.ensah.admin.services;


import com.ensah.admin.dtos.UserDto;
import com.ensah.admin.exceptions.UserNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IAdminService {

    UserDto saveUser(UserDto userDto);

    List<UserDto> listUsers();

    UserDto getUser(Long userId) throws UserNotFoundException;

    UserDto updateUser(UserDto userDto);

    void deleteUser(Long userId);

    List<UserDto> searchUsers(String keyword);

    byte[] getPhoto(Long id) throws Exception;

    void uploadPhoto(MultipartFile file, Long id) throws Exception;

    UserDto findUserByUserName(String userName) throws UserNotFoundException;
}
