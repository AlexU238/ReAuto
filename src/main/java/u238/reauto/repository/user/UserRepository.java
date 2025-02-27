package u238.reauto.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import u238.reauto.datamodel.user.User;
import u238.reauto.repository.DefaultRepository;

import java.util.Optional;

@Repository
public interface UserRepository extends DefaultRepository<Long, User>, JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

}
