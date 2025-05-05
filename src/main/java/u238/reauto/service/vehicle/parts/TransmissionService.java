package u238.reauto.service.vehicle.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.parts.transmission.Transmission;
import u238.reauto.repository.vehicle.parts.transmission.TransmissionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransmissionService implements u238.reauto.service.Service<Transmission,Long> {

    private final TransmissionRepository transmissionRepository;

    @Override
    public Transmission save(Transmission transmission) {
        return transmissionRepository.save(transmission);
    }

    @Override
    public Transmission update(Transmission transmission) {
        Optional<Transmission> existing = transmissionRepository.findById(transmission.getId());
        if (existing.isPresent()) {
            transmission.setId(existing.get().getId());
        }else throw new RuntimeException("Transmission not found for update");

        return transmissionRepository.save(transmission);
    }

    @Override
    public void delete(Transmission transmission) {
        Optional<Transmission> existing = transmissionRepository.findById(transmission.getId());
        if (existing.isPresent()) {
            transmissionRepository.delete(existing.get());
        }else throw new RuntimeException("Transmission not found for delete");
    }

    @Override
    public void deleteById(Long id) {
        Optional<Transmission> existing = transmissionRepository.findById(id);
        if (existing.isPresent()) {
            transmissionRepository.delete(existing.get());
        }else throw new RuntimeException("Transmission with id: " + id + "not found for delete");
    }

    @Override
    public List<Transmission> findAll() {
        return transmissionRepository.findAll();
    }

    @Override
    public Optional<Transmission> findById(Long id) {
        return transmissionRepository.findById(id);
    }
}
