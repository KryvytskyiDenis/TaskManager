package com.krivitskiy.dao.impl;

import com.krivitskiy.dao.interfaces.RoleDao;
import com.krivitskiy.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class RoleDaoImpl implements RoleDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role getById(int roleId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Role.class, roleId);
    }
}
