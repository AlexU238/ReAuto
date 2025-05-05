package u238.reauto.service.vehicle;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.HybridVehicle;
import u238.reauto.datamodel.vehicle.parts.fuel.Fuel;
import u238.reauto.repository.vehicle.HybridVehicleRepository;
import u238.reauto.util.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HybridVehicleServiceImpl implements HybridVehicleService {

    private final HybridVehicleRepository hybridVehicleRepository;

    @Override
    public List<HybridVehicle> findByFuel(Fuel fuel) {
        return hybridVehicleRepository.findAllByFuel(fuel);
    }

    @Override
    public List<HybridVehicle> findByDrivingRange(int drivingRange) {
        return hybridVehicleRepository.findAllByDrivingRange(drivingRange);
    }

    @Override
    public HybridVehicle save(HybridVehicle hybridVehicle) {
        return hybridVehicleRepository.save(hybridVehicle);
    }

    @Override
    public HybridVehicle update(HybridVehicle hybridVehicle) {
        Optional<HybridVehicle> existing = hybridVehicleRepository.findById(hybridVehicle.getId());
        if (existing.isPresent()) {
            hybridVehicle.setId(existing.get().getId());
        }else throw new ResourceNotFoundException("HybridVehicle not found for update");

        return hybridVehicleRepository.save(hybridVehicle);
    }

    @Override
    public void delete(HybridVehicle hybridVehicle) {
        Optional<HybridVehicle> existing = hybridVehicleRepository.findById(hybridVehicle.getId());
        if (existing.isPresent()) {
            hybridVehicleRepository.delete(hybridVehicle);
        }else throw new ResourceNotFoundException("HybridVehicle not found for delete");
    }

    @Override
    public void deleteById(Long id) {
        Optional<HybridVehicle> existing = hybridVehicleRepository.findById(id);
        if (existing.isPresent()) {
            hybridVehicleRepository.delete(existing.get());
        }else throw new ResourceNotFoundException("HybridVehicle with id: "+ id + " not found for delete");
    }

    @Override
    public List<HybridVehicle> findAll() {
        return hybridVehicleRepository.findAll();
    }

    @Override
    public Optional<HybridVehicle> findById(Long id) {
        return hybridVehicleRepository.findById(id);
    }
}
