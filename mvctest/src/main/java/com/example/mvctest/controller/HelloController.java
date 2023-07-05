package com.example.mvctest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mycgv")
public class HelloController {

    @GetMapping("/hello")
    public String mapping(Model model) {
        model.addAttribute("name", "value");
        return "hello";
    }
}
