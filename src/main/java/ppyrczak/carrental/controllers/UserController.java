package ppyrczak.carrental.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ppyrczak.carrental.entities.User;
import ppyrczak.carrental.repositories.UserRepository;

import javax.validation.Valid;

@Controller
@Slf4j
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        userRepository.save(user);
        return "redirect:/index";
    }

    @GetMapping("/signin")
    public String showSignInForm() {
        return "/signin";
    }

   /* @PostMapping("/signin")
    public String identifyUser(User user) {
        if (user == userRepository.findByPassword(user.getPassword()) && user == userRepository.findByEmail(user.getEmail())) {
            log.info("Work");
            return "/check";
        }

        else {
            log.info("not Work");
            return "/sign-in";
        }

    }*/

    @PostMapping("/check")
    public String identifyUser(User user) {
        if (userRepository.existsByEmailAndPassword(user.getEmail(), user.getPassword())) {
            log.info("Work");
            return "/check";
        }

        else {
            log.info("not Work");
            return "redirect:/signin";
        }

    }

    @GetMapping("/check")
    public String checkPage() {
        return "/check";
    }




    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);

        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        userRepository.save(user);

        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);

        return "redirect:/index";
    }


}