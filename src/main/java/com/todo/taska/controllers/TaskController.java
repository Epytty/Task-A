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
        List<TaskEntity> completedTasks = taskService.getCompletedTasks();
        model.addAttribute("completedTasks", completedTasks);
        List<TaskEntity> incompletedTasks = taskService.getIncompletedTasks();
        model.addAttribute("incompletedTasks", incompletedTasks);
        return "tasks";
    }

    @GetMapping("/new")
    public String newTaskPage(Model model) {
        TaskEntity task = new TaskEntity();
        model.addAttribute("task", task);
        return "new";
    }

    @PostMapping
    public String addNewTask(@RequestParam String text, @RequestParam String title) {
        TaskEntity task = new TaskEntity(title, text);
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
    public String editTask(@PathVariable(value = "id") Long id, @RequestParam String title, @RequestParam String text) {
        TaskEntity task = taskService.find(id);
        if (task != null) {
            task.setTitle(title);
            task.setText(text);
            taskService.save(task);
        }
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable(value = "id") Long id) {
        taskService.delete(id);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/complete")
    public String completeTask(@PathVariable(value = "id") Long id) {
        TaskEntity task = taskService.find(id);
        if (task != null) {
            task.setCompleted(true);
            taskService.save(task);
        }
        return "redirect:/tasks";
    }
}
