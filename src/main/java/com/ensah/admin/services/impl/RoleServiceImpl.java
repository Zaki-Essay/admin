package com.ensah.admin.services.impl;

import com.ensah.admin.dao.RoleDao;
import com.ensah.admin.entities.Role;
import com.ensah.admin.services.IRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements IRoleService {

    private RoleDao roleDao;

    @Override
    public Role findByAuthority(String authority) {
        return roleDao.findByAuthority(authority);
    }

    @Override
    public Role save(Role role) {
        return roleDao.save(role);
    }
}
