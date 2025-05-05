package u238.reauto.service.vehicle.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.parts.engine.CombustionEngine;
import u238.reauto.repository.vehicle.parts.engine.CombustionEngineRepository;
import u238.reauto.util.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CombustionEngineService implements EngineService<CombustionEngine>{

    private final CombustionEngineRepository combustionEngineRepository;

    @Override
    public List<CombustionEngine> getAllByManufacturer(String manufacturer) {
        return combustionEngineRepository.findAllByManufacturer(manufacturer);
    }

    @Override
    public List<CombustionEngine> getAllByLocation(String location) {
        return combustionEngineRepository.findAllByLocation(location);
    }

    @Override
    public CombustionEngine save(CombustionEngine combustionEngine) {
        return combustionEngineRepository.save(combustionEngine);
    }

    @Override
    public CombustionEngine update(CombustionEngine combustionEngine) {
        Optional<CombustionEngine> existing = combustionEngineRepository.findById(combustionEngine.getId());
        if (existing.isPresent()) {
            combustionEngine.setId(existing.get().getId());
        }else throw new ResourceNotFoundException("Combustion engine not found for update");

        return combustionEngineRepository.save(combustionEngine);
    }

    @Override
    public void delete(CombustionEngine combustionEngine) {
        Optional<CombustionEngine> existing = combustionEngineRepository.findById(combustionEngine.getId());
        if (existing.isPresent()) {
            combustionEngineRepository.delete(existing.get());
        }else throw new ResourceNotFoundException("Combustion engine not found for delete");
    }

    @Override
    public void deleteById(Long id) {
        Optional<CombustionEngine> existing = combustionEngineRepository.findById(id);
        if (existing.isPresent()) {
            combustionEngineRepository.delete(existing.get());
        }else throw new ResourceNotFoundException("Combustion engine with id: " + id + "not found for delete");
    }

    @Override
    public List<CombustionEngine> findAll() {
        return combustionEngineRepository.findAll();
    }

    @Override
    public Optional<CombustionEngine>findById(Long id) {
        return combustionEngineRepository.findById(id);
    }
}
