package ppyrczak.carrental.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ppyrczak.carrental.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);
    Boolean existsByEmailAndPassword (String email, String password);


}