package ppyrczak.carrental.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ppyrczak.carrental.entities.Car;
import ppyrczak.carrental.repositories.CarRepository;
import ppyrczak.carrental.services.CarService;
import ppyrczak.carrental.utils.Fuel;
import ppyrczak.carrental.utils.Transmission;

//@Data
@Controller
@AllArgsConstructor
@Slf4j
public class CarController {
    private final CarService carService;
    private final CarRepository carRepository;


    @GetMapping("/cars")
    public String showAvailableCars(Model model) {
        log.info("cars: " + carService.getAllCars());
        model.addAttribute("cars", carService.getAllCars());

        //model.addAttribute("fuel", Fuel.values());
        //model.addAttribute("transmission", Transmission.values());
        return "cars";
    }


}
