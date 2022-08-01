package ppyrczak.carrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ppyrczak.carrental.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
