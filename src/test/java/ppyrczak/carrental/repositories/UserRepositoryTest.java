package ppyrczak.carrental.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ppyrczak.carrental.entities.User;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByName() {
    }

    @Test
    void existsByEmailAndPassword() {
    }

    @Test
    void existsById() {
    }

    @Test
    void findByEmailAndPassword() {
    }

    @Test
    void findOnlyById() {
    }

    @Test
    void saveUserTest() {
        User user = User.builder()
                .name("Piotr")
                .surname("Pyrczak")
                .email("ppyrczak5@gmail.com")
                .password("piotr")
                .phoneNumber("886371389")
                .city("Krakow")
                .street("Kawowa")
                .homeNumber("8")
                .build();

        //userRepository.save(user);

       // Assertions.assertThat(user.getId()).isGreaterThan(0);
    }
}