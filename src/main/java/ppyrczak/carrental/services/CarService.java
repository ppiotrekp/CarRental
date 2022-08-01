package ppyrczak.carrental.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ppyrczak.carrental.entities.Car;
import ppyrczak.carrental.repositories.CarRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class CarService {
    private final CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }



}
