package com.krivitskiy.dao.interfaces;


import com.krivitskiy.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TaskRepository {

    void add(Task task);

    void delete(int id);

    List<Task> findAll();

    Task find(int id);

}