package com.krivitskiy.dao.impl;

import com.krivitskiy.dao.interfaces.RoleRepository;
import com.krivitskiy.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class RoleRepositoryImpl implements RoleRepository {

    private final HibernateTemplate hibernateTemplate;

    //Queries
    private final String FINDBYID = "FROM Role r WHERE r.id = ?";
    @Autowired
    public RoleRepositoryImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public Role getById(int roleId) {
        return (Role) hibernateTemplate.find(FINDBYID, roleId).get(0);
    }
}
