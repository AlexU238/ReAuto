package u238.reauto.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.user.User;
import u238.reauto.repository.user.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public User findById(Long aLong) {
        return null;
    }
}
