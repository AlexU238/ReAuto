package u238.reauto.service.vehicle.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.parts.transmission.Transmission;
import u238.reauto.repository.vehicle.parts.transmission.TransmissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransmissionService implements u238.reauto.service.Service<Transmission,Long> {

    private final TransmissionRepository transmissionRepository;

    @Override
    public Transmission save(Transmission transmission) {
        return null;
    }

    @Override
    public Transmission update(Transmission transmission) {
        return null;
    }

    @Override
    public void delete(Transmission transmission) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<Transmission> findAll() {
        return List.of();
    }

    @Override
    public Transmission findById(Long aLong) {
        return null;
    }
}
