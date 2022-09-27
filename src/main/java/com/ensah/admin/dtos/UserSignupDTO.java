package com.ensah.admin.dtos;

import com.ensah.admin.utils.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class UserSignupDTO {

    @NotNull
    private String fullname;

    @NotNull
    private String email;

    @NotNull
    private String username;

    @NotNull
    private String profession;

    @NotNull
    private Gender gender;

    @NotNull
    private String password;
}
