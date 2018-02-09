package com.krivitskiy.dao.impl;

import com.krivitskiy.dao.interfaces.UserDao;
import com.krivitskiy.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    //Queries
    private final String FIND_BY_NAME = "FROM User u WHERE u.username=:username";

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(user);
    }

    @Override
    public User findByName(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(FIND_BY_NAME);
        query.setParameter("username",username);
        User user = (User) query.uniqueResult();

        return user;
    }
}
