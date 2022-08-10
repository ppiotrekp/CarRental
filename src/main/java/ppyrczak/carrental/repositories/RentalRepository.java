package ppyrczak.carrental.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ppyrczak.carrental.entities.Rental;

import java.util.List;

public interface RentalRepository extends CrudRepository<Rental, Long> {
    @Query(value = "select r.car_id, c.brand, c.model, c.fuel, c.power," +
            "r.id, r.rental_start, r.rental_span, r.rental_end, r.price, r.user_id " +
            "from car c join rental r on c.id = r.car_id " +
            "where r.user_id = :id" , nativeQuery = true)
    List<Rental> findAll(Long id);
}
