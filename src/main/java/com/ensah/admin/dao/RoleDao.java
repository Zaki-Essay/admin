package com.ensah.admin.dao;


import com.ensah.admin.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Long> {

}
