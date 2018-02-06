package com.krivitskiy.dao.interfaces;

import com.krivitskiy.model.User;


public interface UserDao{

    void save(User user);

    User findByName(String username);
}
