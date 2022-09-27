package com.ensah.admin.mappres.impl;


import com.ensah.admin.dtos.UserDto;
import com.ensah.admin.dtos.UserSignupDTO;
import com.ensah.admin.entities.User;
import com.ensah.admin.mappres.IUserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements IUserMapper {

    @Override
    public UserDto fromUser(User user){
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(user,userDto);
        return  userDto;
    }

    @Override
    public User fromUserDto(UserDto userDto){
        User user=new User();
        BeanUtils.copyProperties(userDto,user);
        return  user;
    }

    //by krach achraf
    @Override
    public User fromUserSignupDTO(UserSignupDTO userSignupDTO) {
        User user = new User();
        user.setFullname(userSignupDTO.getFullname());
        user.setUsername(userSignupDTO.getUsername());
        user.setEmail(userSignupDTO.getEmail());
        user.setProfession(userSignupDTO.getProfession());
        user.setGender(userSignupDTO.getGender());
        user.setPassword(userSignupDTO.getPassword());
        return user;
    }
}
