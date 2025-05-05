package u238.reauto.service.vehicle.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.parts.acustics.Acoustics;
import u238.reauto.repository.vehicle.parts.acoustics.AcousticsRepository;
import u238.reauto.util.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AcousticsService implements u238.reauto.service.Service<Acoustics, Long> {

    private final AcousticsRepository acousticsRepository;

    @Override
    public Acoustics save(Acoustics acoustics) {
        return acousticsRepository.save(acoustics);
    }

    @Override
    public Acoustics update(Acoustics acoustics) {
        Optional<Acoustics> present = acousticsRepository.findById(acoustics.getId());
        if (present.isPresent()) {
            acoustics.setId(present.get().getId());
        } else throw new ResourceNotFoundException("Acoustics with id " + acoustics.getId() + " not found for update");

        return acousticsRepository.save(acoustics);
    }

    @Override
    public void delete(Acoustics acoustics) {
        Optional<Acoustics> present = acousticsRepository.findById(acoustics.getId());
        if (present.isPresent()) {
            acousticsRepository.delete(present.get());
        } else throw new ResourceNotFoundException("Acoustics with id " + acoustics.getId() + " not found for delete");
    }

    @Override
    public void deleteById(Long id) {
        Optional<Acoustics> acoustics = acousticsRepository.findById(id);
        if (acoustics.isPresent()) {
            acousticsRepository.delete(acoustics.get());
        } else throw new ResourceNotFoundException("Acoustics with id " + id + " not found for delete");
    }

    @Override
    public List<Acoustics> findAll() {
        return acousticsRepository.findAll();
    }

    @Override
    public Optional<Acoustics> findById(Long id) {
        return acousticsRepository.findById(id);
    }
}
