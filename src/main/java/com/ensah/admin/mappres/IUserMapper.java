package com.ensah.admin.mappres;


import com.ensah.admin.dtos.UserDto;
import com.ensah.admin.entities.User;

public interface IUserMapper {
    UserDto fromUser(User user);

    User fromUserDto(UserDto userDto);
}
