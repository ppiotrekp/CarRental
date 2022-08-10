package ppyrczak.carrental.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }
}
