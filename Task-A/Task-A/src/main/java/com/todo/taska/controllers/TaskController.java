package com.todo.taska.controllers;

import ch.qos.logback.core.model.Model;
import com.todo.taska.models.TaskEntity;
import com.todo.taska.models.TaskService;
import com.todo.taska.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasklist")
    public String tasklist(org.springframework.ui.Model model) {
        Iterable<TaskEntity> task = taskService.taskRepository.findAll();
        model.addAttribute("task", task);
        return "tasklist";
    }

    @GetMapping("/newtask")
    public String newtask(org.springframework.ui.Model model) {
        return "newtask";
    }

    @PostMapping("/tasklist/newtask")
    public String AddNewTask(@RequestParam String text, Model model) {
        TaskEntity postText = new TaskEntity(text);
        taskService.taskRepository.save(postText);
        return"redirect:/tasklist";
    }
}