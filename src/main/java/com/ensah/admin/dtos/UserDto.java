package com.ensah.admin.dtos;



import com.ensah.admin.entities.Role;
import com.ensah.admin.utils.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Collection;
import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    private String fullname;

    private String username;

    private String email;

    private String phoneNumber;

    private Gender gender;

    private String photo;

    private String website;

    private Date dateBirth;

    private String password;

    private boolean isLocked = true;

    private boolean isExpired;

    private Collection<Role> authorities;


}
