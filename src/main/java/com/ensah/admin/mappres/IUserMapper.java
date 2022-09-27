package com.ensah.admin.mappres;


import com.ensah.admin.dtos.UserDto;
import com.ensah.admin.dtos.UserSignupDTO;
import com.ensah.admin.entities.User;

public interface IUserMapper {
    UserDto fromUser(User user);

    User fromUserDto(UserDto userDto);

    //by krach achraf
    User fromUserSignupDTO(UserSignupDTO userSignupDTO);
}
