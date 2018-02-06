package com.krivitskiy.service;

import com.krivitskiy.model.User;

public interface UserService {

    void save(User user);

    User findByName(String username);
}
