package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WelcomeController {
    @GetMapping("/welcome")
    public String sayWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Welcome!");
        messages.add("Practical challenge 2.3.1 Java pre-project.");
        messages.add("Task 2.3.1. Spring MVC + Hibernate.");
        model.addAttribute("messages", messages);

        return "welcome";
    }
}
