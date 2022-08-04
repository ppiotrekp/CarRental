package ppyrczak.carrental.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ppyrczak.carrental.entities.Car;
import ppyrczak.carrental.entities.Rental;
import ppyrczak.carrental.entities.User;
import ppyrczak.carrental.repositories.CarRepository;
import ppyrczak.carrental.repositories.RentalRepository;
import ppyrczak.carrental.repositories.UserRepository;
import ppyrczak.carrental.services.CarService;

import java.util.Optional;

//@Data
@Controller
@AllArgsConstructor
@Slf4j

public class CarController {
    private final CarService carService;

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    public static Long carId;

    @GetMapping("/cars")
    public String showAvailableCars(Model model) {
        log.info("userid" + UserController.userId);
        model.addAttribute("cars", carService.getAllCars());
        return "cars";
    }

    @GetMapping("/rent-panel/{id}")
    public String showRentPanel(@PathVariable Long id, Model model) {
        Car car = carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid car Id:" + id));
        Optional<User> user = userRepository.findById(UserController.userId);
        Rental rental = new Rental();
        carId = car.getId();
        log.info("userid " + UserController.userId);
        log.info("carid " + id);
        model.addAttribute("car", car);
        model.addAttribute("user", user);
        model.addAttribute("rental", rental);
        return "rent-car";
    }
}
