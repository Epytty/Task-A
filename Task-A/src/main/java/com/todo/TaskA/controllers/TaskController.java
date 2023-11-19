package com.todo.TaskA.controllers;

import ch.qos.logback.core.model.Model;
import com.todo.TaskA.models.BDlist;
import com.todo.TaskA.repositories.BDlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {

    @Autowired
    private BDlistRepository bdlist;

    @GetMapping("/tasklist")
    public String tasklist(org.springframework.ui.Model model) {
        Iterable<BDlist> task = bdlist.findAll();
        model.addAttribute("task", task);
        return "tasklist";
    }
    @GetMapping("/newtask")
    public String newtask(org.springframework.ui.Model model) {
        return "newtask";
    }

    @PostMapping("/tasklist/newtask")
    public String AddNewTask(@RequestParam String tasktext, Model model) {
        BDlist PostText = new BDlist(tasktext);
        bdlist.save(PostText);
        return"redirect:/tasklist";
    }

}