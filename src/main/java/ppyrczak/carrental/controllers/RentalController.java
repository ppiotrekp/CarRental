package ppyrczak.carrental.controllers;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import ppyrczak.carrental.entities.Car;
import ppyrczak.carrental.entities.Rental;
import ppyrczak.carrental.entities.User;
import ppyrczak.carrental.repositories.CarRepository;
import ppyrczak.carrental.repositories.RentalRepository;
import ppyrczak.carrental.repositories.UserRepository;

@Data
@Slf4j
@Controller
public class RentalController {

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final RentalRepository rentalRepository;
    @PostMapping("/rentcar")
    public String rentCar(Rental rental, Long userId, Long carId) {
        carId = CarController.carId;
        userId = UserController.userId;
        User user = userRepository.findOnlyById(userId);
        Car car = carRepository.findOnlyById(carId);
        rental.setCar(car);
        rental.setUser(user);
        rental.setPrice();
        rental.setRentalEnd();
        rentalRepository.save(rental);
        return "redirect:/panel-user";
    }
}
