package com.krivitskiy.service;

import com.krivitskiy.dao.interfaces.RoleDao;
import com.krivitskiy.dao.interfaces.UserDao;
import com.krivitskiy.model.Role;
import com.krivitskiy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final RoleDao roleDao;


    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public void save(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getById(1));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByName(String username) {
        return userDao.findByName(username);
    }
}
