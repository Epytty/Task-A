package com.todo.TaskA.controllers;

import com.todo.TaskA.models.BDlist;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("title", "Main Page");
        return "main";
    }
}