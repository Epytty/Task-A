package com.todo.taska.models;


import com.todo.taska.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
