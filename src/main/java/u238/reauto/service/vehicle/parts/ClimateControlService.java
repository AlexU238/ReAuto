package u238.reauto.service.vehicle.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.parts.climateControl.ClimateControl;
import u238.reauto.repository.vehicle.parts.climateControl.ClimateControlRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClimateControlService implements u238.reauto.service.Service<ClimateControl, Long> {

    private final ClimateControlRepository climateControlRepository;

    @Override
    public ClimateControl save(ClimateControl climateControl) {
        return null;
    }

    @Override
    public ClimateControl update(ClimateControl climateControl) {
        return null;
    }

    @Override
    public void delete(ClimateControl climateControl) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<ClimateControl> findAll() {
        return List.of();
    }

    @Override
    public ClimateControl findById(Long aLong) {
        return null;
    }
}
