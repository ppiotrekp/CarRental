package ppyrczak.carrental.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ppyrczak.carrental.entities.Car;
import ppyrczak.carrental.utils.Fuel;
import ppyrczak.carrental.utils.Transmission;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    void ifCarExists() {
       // Car car = new Car("BMW", "M5", Fuel.PETROL, Transmission.AUTOMATIC, 630, 2000, 4000, 7000, 10000);
       // carRepository.save(car);

        //boolean expected = carRepository.

    }

}