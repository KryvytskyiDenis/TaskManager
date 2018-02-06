package com.krivitskiy.dao.interfaces;

import com.krivitskiy.model.Task;

import java.util.List;

public interface TaskDao {

    void add(Task task);

    void update(Task task);

    void delete(int id);

    List<Task> findAllByUserId(int userId);

    Task find(int id);

}