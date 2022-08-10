package ppyrczak.carrental.controllers;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ppyrczak.carrental.entities.User;
import ppyrczak.carrental.repositories.CarRepository;
import ppyrczak.carrental.repositories.UserRepository;

import javax.validation.Valid;

@Controller
@Data
@Slf4j
public class UserController {

    private final UserRepository userRepository;
    private final CarRepository carRepository;
    public static Long userId;
    private boolean logged = false;

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
      //  model.addAttribute("user", user);
        userRepository.save(user);
        return "redirect:/home";
    }

    @GetMapping("/signin")
    public String showSignInForm() {
        userId = null;
        return "/signin";
    }

    @GetMapping("/panel-user")
    public String identifyUser(String email, User user, String password, Model model) {
        if (userRepository.existsByEmailAndPassword(email, password)) {
            user = userRepository.findByEmailAndPassword(email, password);
            model.addAttribute("user", user);
            userId = user.getId();
        }

        if (userId != null) {
            return "panel-user";
        }

        else {
            System.out.println(userId);
            return "redirect:/signin";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        return "redirect:/index";
    }
}