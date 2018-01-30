package com.krivitskiy.service;

import com.krivitskiy.dao.interfaces.TaskRepository;
import com.krivitskiy.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void add(Task task){
        taskRepository.add(task);
    }

    public void delete(int id){
        taskRepository.delete(id);
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task find(int id){
        return taskRepository.find(id);
    }
}
