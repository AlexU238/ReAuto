package u238.reauto.service.vehicle.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.parts.engine.ElectricEngine;
import u238.reauto.repository.vehicle.parts.engine.ElectricEngineRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElectricEngineService implements EngineService<ElectricEngine> {

    private final ElectricEngineRepository electricEngineRepository;

    @Override
    public List<ElectricEngine> getAllByManufacturer(String manufacturer) {
        return electricEngineRepository.findAllByManufacturer(manufacturer);
    }

    @Override
    public List<ElectricEngine> getAllByLocation(String location) {
        return electricEngineRepository.findAllByLocation(location);
    }

    @Override
    public ElectricEngine save(ElectricEngine electricEngine) {
        return electricEngineRepository.save(electricEngine);
    }

    @Override
    public ElectricEngine update(ElectricEngine electricEngine) {
        Optional<ElectricEngine> existing = electricEngineRepository.findById(electricEngine.getId());
        if (existing.isPresent()) {
            electricEngine.setId(existing.get().getId());
        }else throw new RuntimeException("Electric engine not found for update");
        return electricEngineRepository.save(electricEngine);
    }

    @Override
    public void delete(ElectricEngine electricEngine) {
        Optional<ElectricEngine> existing = electricEngineRepository.findById(electricEngine.getId());
        if (existing.isPresent()) {
            electricEngineRepository.delete(existing.get());
        }else throw new RuntimeException("Electric engine not found for delete");
    }

    @Override
    public void deleteById(Long id) {
        Optional<ElectricEngine> existing = electricEngineRepository.findById(id);
        if (existing.isPresent()) {
            electricEngineRepository.delete(existing.get());
        }else throw new RuntimeException("Electric engine with id: " + id +" not found for delete");
    }

    @Override
    public List<ElectricEngine> findAll() {
        return electricEngineRepository.findAll();
    }

    @Override
    public Optional<ElectricEngine> findById(Long id) {
        return electricEngineRepository.findById(id);
    }
}
