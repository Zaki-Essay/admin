package com.ensah.admin.services;

import com.ensah.admin.entities.Role;

public interface IRoleService {
    Role findByAuthority(String authority);
    Role save(Role role);
}
