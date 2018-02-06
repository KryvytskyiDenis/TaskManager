package com.krivitskiy.dao.impl;

import com.krivitskiy.dao.interfaces.TaskDao;
import com.krivitskiy.model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class TaskDaoImpl implements TaskDao {

    private final SessionFactory sessionFactory;

    //Queries
    private final String findAllByUserId = "FROM Task t WHERE t.user.id=:userId";

    @Autowired
    public TaskDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Task task) {
        Session session = this.sessionFactory.getCurrentSession();
        session.merge(task);
    }

    @Override
    public void update(Task task) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(task);
    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Task task = session.load(Task.class, id);

        if(task!=null){
            session.delete(task);
        }
    }

    @Override
    public List<Task> findAllByUserId(int userId) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery(findAllByUserId);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public Task find(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        return session.get(Task.class, id);
    }
}
