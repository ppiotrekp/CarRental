package ppyrczak.carrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ppyrczak.carrental.entities.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findById(Car car);

    Car findOnlyById(Long carId);

    @Query(value = "select c.id, c.brand, c.model, c.fuel, c.transmission, c.power from car c" , nativeQuery = true)
    List<Car> getAllCars();


}
