package com.ensah.admin.entities;


import com.ensah.admin.utils.Gender;
import lombok.*;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;

    private String username;

    private String email;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String website;

    private String profession;

    private Date dateBirth;

    private String password;

    private boolean isLocked = true;

    private boolean isExpired;

    private String photo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> authorities = new ArrayList<>();




}
