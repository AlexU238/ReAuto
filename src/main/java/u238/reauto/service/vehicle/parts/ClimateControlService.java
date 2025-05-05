package u238.reauto.service.vehicle.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.parts.climateControl.ClimateControl;
import u238.reauto.repository.vehicle.parts.climateControl.ClimateControlRepository;
import u238.reauto.util.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClimateControlService implements u238.reauto.service.Service<ClimateControl, Long> {

    private final ClimateControlRepository climateControlRepository;

    @Override
    public ClimateControl save(ClimateControl climateControl) {
        return climateControlRepository.save(climateControl);
    }

    @Override
    public ClimateControl update(ClimateControl climateControl) {
        Optional<ClimateControl> existing = climateControlRepository.findById(climateControl.getId());
        if (existing.isPresent()) {
            climateControl.setId(existing.get().getId());
        }else throw new ResourceNotFoundException("Climate control not found for update");

        return climateControlRepository.save(climateControl);
    }

    @Override
    public void delete(ClimateControl climateControl) {
        Optional<ClimateControl> existing = climateControlRepository.findById(climateControl.getId());
        if (existing.isPresent()) {
            climateControlRepository.delete(existing.get());
        }else throw new ResourceNotFoundException("Climate control not found for delete");
    }

    @Override
    public void deleteById(Long id) {
        Optional<ClimateControl> existing = climateControlRepository.findById(id);
        if (existing.isPresent()) {
            climateControlRepository.delete(existing.get());
        }else throw new ResourceNotFoundException("Climate control with id: " + id + " not found for delete");
    }

    @Override
    public List<ClimateControl> findAll() {
        return climateControlRepository.findAll();
    }

    @Override
    public Optional<ClimateControl> findById(Long id) {
       return climateControlRepository.findById(id);
    }
}
