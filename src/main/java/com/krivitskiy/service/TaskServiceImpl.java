package com.krivitskiy.service;

import com.krivitskiy.dao.interfaces.TaskDao;
import com.krivitskiy.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDao;

    @Autowired
    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public void add(Task task) {
        taskDao.add(task);
    }

    @Override
    public void delete(int id) {
        taskDao.delete(id);
    }

    @Override
    public List<Task> findAllByUserId(int userId) {
        return taskDao.findAllByUserId(userId);
    }

    @Override
    public Task find(int id) {
        return taskDao.find(id);
    }
}