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

    public List<TaskEntity> getCompletedTasks() {
        return taskRepository.findByCompleted(true);
    }

    public List<TaskEntity> getIncompletedTasks() {
        return taskRepository.findByCompleted(false);
    }

    public TaskEntity find(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public TaskEntity save(TaskEntity task) {
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}