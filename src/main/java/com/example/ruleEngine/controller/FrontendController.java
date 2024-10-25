package com.example.ruleEngine.controller;


import com.example.ruleEngine.entity.Rule;
import com.example.ruleEngine.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FrontendController {

    @Autowired
    private RuleRepository ruleRepository;

    @GetMapping("/")
    public String index(Model model) {
        return "index"; // Return the Thymeleaf template name
    }
}

