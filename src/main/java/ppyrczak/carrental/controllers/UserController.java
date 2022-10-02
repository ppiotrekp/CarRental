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
import java.security.NoSuchAlgorithmException;

import static ppyrczak.carrental.utils.SHA256.getSHA;
import static ppyrczak.carrental.utils.SHA256.toHexString;

@Controller
@Data
@Slf4j
public class UserController {

    private final UserRepository userRepository;
    private final CarRepository carRepository;
    public static Long userId;
    private boolean logged = false;

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) throws NoSuchAlgorithmException {
        if (result.hasErrors()) {
            return "add-user";
        }

        user.setPassword(toHexString(getSHA(user.getPassword())));
        userRepository.save(user);
        return "redirect:/home";
    }

    @GetMapping("/signin")
    public String showSignInForm() {
        userId = null;
        return "signin";
    }

    @GetMapping("/panel-user")
    public String identifyUser(String email, User user, String password, Model model) throws NoSuchAlgorithmException {
        String hashPassword = toHexString(getSHA(password));
        if (userRepository.existsByEmailAndPassword(email, hashPassword)) {
            user = userRepository.findByEmailAndPassword(email, hashPassword);
            model.addAttribute("user", user);
            userId = user.getId();
        }

        if (userId != null) {
            return "panel-user";
        }

        else {
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