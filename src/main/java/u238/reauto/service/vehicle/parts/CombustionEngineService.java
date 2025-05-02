package u238.reauto.service.vehicle.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.parts.engine.CombustionEngine;
import u238.reauto.repository.vehicle.parts.engine.CombustionEngineRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CombustionEngineService implements EngineService<CombustionEngine>{

    private final CombustionEngineRepository combustionEngineRepository;

    @Override
    public List<CombustionEngine> getAllByManufacturer() {
        return List.of();
    }

    @Override
    public List<CombustionEngine> getAllByLocation(String location) {
        return List.of();
    }

    @Override
    public CombustionEngine save(CombustionEngine combustionEngine) {
        return null;
    }

    @Override
    public CombustionEngine update(CombustionEngine combustionEngine) {
        return null;
    }

    @Override
    public void delete(CombustionEngine combustionEngine) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<CombustionEngine> findAll() {
        return List.of();
    }

    @Override
    public CombustionEngine findById(Long aLong) {
        return null;
    }
}
