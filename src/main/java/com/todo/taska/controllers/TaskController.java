package com.todo.taska.controllers;

import com.todo.taska.models.TaskEntity;
import com.todo.taska.models.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks") // Общий путь для всех методов в этом контроллере
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public String taskList(Model model) {
        List<TaskEntity> tasks = taskService.getAll();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/new")
    public String newTaskPage(Model model) {
        TaskEntity task = new TaskEntity();
        model.addAttribute("task", task);
        return "new";
    }

    @PostMapping
    public String addNewTask(@RequestParam String text) {
        TaskEntity task = new TaskEntity(text);
        taskService.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}")
    public String taskInfo(@PathVariable(value = "id") Long id, Model model) {
        TaskEntity task = taskService.find(id);
        if (task != null) {
            model.addAttribute("task", task);
            return "info";
        }
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/edit")
    public String editTaskPage(@PathVariable(value = "id") Long id, Model model) {
        TaskEntity task = taskService.find(id);
        model.addAttribute("task", task);
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String editTask(@PathVariable(value = "id") Long id, @RequestParam String text) {
        TaskEntity task = taskService.find(id);
        if (task != null) {
            task.setText(text);
            taskService.save(task);
        }
        return "redirect:/tasks";
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable(value = "id") Long id) {
        taskService.delete(id);
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/complete")
    public String completeTask(@PathVariable(value = "id") Long id) {
        TaskEntity task = taskService.find(id);
        if (task != null) {
            task.setCompleted(true);
            taskService.save(task);
        }
        return "redirect:/tasks";
    }
}
