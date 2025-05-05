package u238.reauto.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.user.User;
import u238.reauto.repository.user.UserRepository;
import u238.reauto.util.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        Optional<User> existing = userRepository.findById(user.getId());
        if (existing.isPresent()) {
            user.setId(existing.get().getId());
        }else throw new ResourceNotFoundException("User for update not found");

        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        Optional<User> existing = userRepository.findById(user.getId());
        if (existing.isPresent()) {
            userRepository.delete(existing.get());
        }else throw new ResourceNotFoundException("User for delete not found");
    }

    @Override
    public void deleteById(Long id) {
        Optional<User> existing = userRepository.findById(id);
        if (existing.isPresent()) {
            userRepository.delete(existing.get());
        }else throw new ResourceNotFoundException("User with id: " + id + " for delete not found");
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
