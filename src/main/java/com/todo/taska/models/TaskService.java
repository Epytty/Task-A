package com.todo.taska.models;


import com.todo.taska.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequestMapping("/tasks")
public class TaskService {
    @Autowired
    public TaskRepository taskRepository;

    public List<TaskEntity> getAll() {
        return (List<TaskEntity>) taskRepository.findAll();
    }

    public void save(TaskEntity task) {
        taskRepository.save(task);
    }
}