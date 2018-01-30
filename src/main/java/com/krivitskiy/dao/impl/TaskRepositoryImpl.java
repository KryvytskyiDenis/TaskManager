package com.krivitskiy.dao.impl;

import com.krivitskiy.dao.interfaces.TaskRepository;
import com.krivitskiy.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final HibernateTemplate hibernateTemplate;

    //Queries
    private final String findById = "FROM Task t WHERE t.id=?";
    private final String findAll = "FROM Task";

    @Autowired
    public TaskRepositoryImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void add(Task task) {
        hibernateTemplate.saveOrUpdate(task);
    }

    @Override
    public void delete(int id) {
        hibernateTemplate.delete(hibernateTemplate.get(Task.class,id));
    }

    @Override
    public List<Task> findAll() {
        return (List<Task>) hibernateTemplate.find(findAll);
    }

    @Override
    public Task find(int id) {
        return (Task) hibernateTemplate.find(findById, id).get(0);
    }
}
