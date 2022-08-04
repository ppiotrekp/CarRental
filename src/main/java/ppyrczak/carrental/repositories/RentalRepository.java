package ppyrczak.carrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ppyrczak.carrental.entities.Rental;

public interface RentalRepository extends CrudRepository<Rental, Long> {
}
