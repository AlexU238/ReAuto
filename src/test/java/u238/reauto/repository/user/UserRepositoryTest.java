package u238.reauto.repository.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import u238.reauto.datamodel.user.User;

import java.util.ArrayList;
import java.util.Optional;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp(){
        User user = User.builder()
                .username("test")
                .password("test")
                .email("test@mail.com")
                .firstName("test")
                .lastName("test")
                .advertisements(new ArrayList<>())
                .build();
        userRepository.save(user);
    }

    @Test
    public void testFindByUsernameSuccess(){
        Optional<User> user = userRepository.findByUsername("test");

        Assertions.assertTrue(user.isPresent());
        Assertions.assertEquals("test", user.get().getUsername());
    }

    @Test
    public void testFindByUsernameFailure(){
        Optional<User> user = userRepository.findByUsername("test2");

        Assertions.assertTrue(user.isEmpty());
    }

    @Test
    public void testFindByEmailSuccess(){
        Optional<User> user = userRepository.findByEmail("test@mail.com");

        Assertions.assertTrue(user.isPresent());
        Assertions.assertEquals("test@mail.com", user.get().getEmail());
    }

    @Test
    public void testFindByEmailFailure(){
        Optional<User> user = userRepository.findByEmail("tester@mail.com");

        Assertions.assertTrue(user.isEmpty());
    }

}
