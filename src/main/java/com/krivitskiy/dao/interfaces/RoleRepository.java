package com.krivitskiy.dao.interfaces;

import com.krivitskiy.model.Role;

public interface RoleRepository {

    Role getById(int roleId);
}
