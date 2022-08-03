package ppyrczak.carrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ppyrczak.carrental.entities.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
