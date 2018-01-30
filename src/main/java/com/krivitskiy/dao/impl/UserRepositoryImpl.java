package com.krivitskiy.dao.impl;

import com.krivitskiy.dao.interfaces.UserRepository;
import com.krivitskiy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserRepositoryImpl implements UserRepository {

    private final HibernateTemplate hibernateTemplate;

    //Queries
    private final String findByName = "FROM User u WHERE u.id=?";

    @Autowired
    public UserRepositoryImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void save(User user) {
        hibernateTemplate.saveOrUpdate(user);
    }

    @Override
    public User findByName(String username) {
        return (User) hibernateTemplate.find(findByName, username).get(0);
    }
}
