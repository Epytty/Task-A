package com.todo.taska.models;

import ch.qos.logback.core.model.Model;
import com.todo.taska.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/tasks")
public class TaskService {
    @Autowired
    public TaskRepository taskRepository;

    @GetMapping("/tasklist")
    public String tasklist(org.springframework.ui.Model model) {
        Iterable<TaskEntity> task = taskRepository.findAll();
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
        taskRepository.save(postText);
        return"redirect:/tasklist";
    }
}
