package com.ensah.admin.dao;

import com.ensah.admin.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {

    @Query("select u from User u where u.fullname like :kw")
    List<User> searchUser(@Param("kw") String keyword);


    User findUserByUsername(String username);









}
