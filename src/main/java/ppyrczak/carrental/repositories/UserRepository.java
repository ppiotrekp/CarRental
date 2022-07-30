package ppyrczak.carrental.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ppyrczak.carrental.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);
    Boolean existsByEmailAndPassword (String email, String password);
    boolean existsById (Long id);

    Optional<User> findByEmail(String email);
}