package ppyrczak.carrental.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class AboutController {
    @GetMapping("/about")
    public String showAboutPage() {
        return "about";
    }
}
