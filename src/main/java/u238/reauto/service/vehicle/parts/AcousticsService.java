package u238.reauto.service.vehicle.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.parts.acustics.Acoustics;
import u238.reauto.repository.vehicle.parts.acoustics.AcousticsRepository;

import java.util.List;

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
        Acoustics present = acousticsRepository.findById(acoustics.getId()).orElse(null);
        if (present != null) {
            acoustics.setId(present.getId());
        } else throw new NullPointerException("Acoustics with id " + acoustics.getId() + " not found for update");

        return acousticsRepository.save(acoustics);
    }

    @Override
    public void delete(Acoustics acoustics) {
        Acoustics present = acousticsRepository.findById(acoustics.getId()).orElse(null);
        if (present != null) {
            acousticsRepository.delete(present);
        } else throw new NullPointerException("Acoustics with id " + acoustics.getId() + " not found for delete");
    }

    @Override
    public void deleteById(Long id) {
        Acoustics acoustics = acousticsRepository.findById(id).orElse(null);
        if (acoustics != null) {
            acousticsRepository.delete(acoustics);
        } else throw new NullPointerException("Acoustics with id " + id + " not found for delete");
    }

    @Override
    public List<Acoustics> findAll() {
        return acousticsRepository.findAll();
    }

    @Override
    public Acoustics findById(Long id) {
        Acoustics acoustics = acousticsRepository.findById(id).orElse(null);
        if (acoustics != null) {return acoustics;}
        else throw new NullPointerException("Acoustics with id " + id + " not found for findById");
    }
}
