package ppyrczak.carrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ppyrczak.carrental.entities.Car;
import ppyrczak.carrental.entities.User;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findById(Car car);

    Car findOnlyById(Long carId);
}
