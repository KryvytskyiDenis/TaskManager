package com.krivitskiy.service;

import com.krivitskiy.model.Task;

import java.util.List;

public interface TaskService {

    void add(Task task);

    void delete(int id);

    List<Task> findAllByUserId(int userId);

    Task find(int id);
}
