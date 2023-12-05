package com.todo.taska.controllers;

import com.todo.taska.models.TaskEntity;
import com.todo.taska.models.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public String taskList(Model model) {
        List<TaskEntity> tasks = taskService.getAll();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/tasks/new")
    public String newTaskPage(Model model) {
        TaskEntity task = new TaskEntity();
        model.addAttribute("task", task);
        return "new";
    }

    @PostMapping("/tasks")
    public String addNewTask(@RequestParam String text) {
        TaskEntity task = new TaskEntity(text);
        taskService.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("tasks/{id}")
    public String taskInfo(@PathVariable(value = "id") Long id, Model model) {
        TaskEntity task = taskService.find(id);
        if (task == null) {
            return "redirect:/tasks";
        }
        model.addAttribute("task", task);
        return "info";
    }

    @GetMapping("/tasks/{id}/edit")
    public String editTaskPage(@PathVariable(value = "id") Long id, Model model) {
        TaskEntity task = taskService.find(id);
        model.addAttribute("task", task);
        return "edit";
    }

    @PostMapping("/tasks/{id}")
    public String editTask(@PathVariable Long id, @RequestParam String text) {
        TaskEntity task = taskService.find(id);
        if (task == null) {
            return "redirect:/tasks";
        }
        task.setText(text);
        taskService.save(task);
        return "redirect:/tasks";
    }

    @PostMapping("/tasks/{id}/delete")
    public String deleteTask(@PathVariable(value = "id") Long id) {
        taskService.delete(id);
        return "redirect:/tasks";
    }
}