package u238.reauto.service.vehicle.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.parts.engine.ElectricEngine;
import u238.reauto.repository.vehicle.parts.engine.ElectricEngineRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectricEngineService implements EngineService<ElectricEngine> {

    private final ElectricEngineRepository electricEngineRepository;

    @Override
    public List<ElectricEngine> getAllByManufacturer() {
        return List.of();
    }

    @Override
    public List<ElectricEngine> getAllByLocation(String location) {
        return List.of();
    }

    @Override
    public ElectricEngine save(ElectricEngine electricEngine) {
        return null;
    }

    @Override
    public ElectricEngine update(ElectricEngine electricEngine) {
        return null;
    }

    @Override
    public void delete(ElectricEngine electricEngine) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<ElectricEngine> findAll() {
        return List.of();
    }

    @Override
    public ElectricEngine findById(Long aLong) {
        return null;
    }
}
