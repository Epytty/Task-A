package com.todo.taska.controllers;

import com.todo.taska.models.TaskEntity;
import com.todo.taska.models.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping()
    public String tasklist(Model model) {
        List<TaskEntity> tasks = taskService.getAll();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/new")
    public String newTask() {
        return "new";
    }

    @PostMapping("/new")
    public String addNewTask(@RequestParam String text) {
        TaskEntity task = new TaskEntity(text);
        taskService.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}")
    public String taskInfo(@PathVariable(value = "id") Long id, Model model) {
        TaskEntity task = taskService.find(id);
        if (task == null) {
            return "redirect:/tasks";
        }
        model.addAttribute("task", task);
        return "info";
    }

    @PostMapping("/{id}")
        public String deleteTask(@PathVariable(value = "id") Long id) {
        taskService.delete(id);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/edit")
    public String editTask(@PathVariable(value = "id") long id, Model model) {
        TaskEntity task = taskService.find(id);
        if (task == null) {
            return "redirect:/tasks";
        }
        model.addAttribute("task", task);
        return "edit";
    }
    @PutMapping("/tasks/{id}/edit")
    public String updateTask(@PathVariable(value = "id") long id, @RequestParam String text) {
        TaskEntity task = taskService.find(id);
        if (task == null) {
            return "redirect:/tasks";
        }
        task.setText(text);
        taskService.save(task);
        return "redirect:/tasks";
    }
}