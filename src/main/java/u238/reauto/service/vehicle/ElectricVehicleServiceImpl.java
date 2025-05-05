package u238.reauto.service.vehicle;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.ElectricVehicle;
import u238.reauto.repository.vehicle.ElectricVehicleRepository;
import u238.reauto.util.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElectricVehicleServiceImpl implements ElectricVehicleService {

    private final ElectricVehicleRepository electricVehicleRepository;

    @Override
    public List<ElectricVehicle> findByDrivingRange(int drivingRange) {
        return electricVehicleRepository.findAllByDrivingRange(drivingRange);
    }

    @Override
    public ElectricVehicle save(ElectricVehicle electricVehicle) {
        return electricVehicleRepository.save(electricVehicle);
    }

    @Override
    public ElectricVehicle update(ElectricVehicle electricVehicle) {
        Optional<ElectricVehicle> existing = electricVehicleRepository.findById(electricVehicle.getId());
        if (existing.isPresent()) {
            electricVehicle.setId(existing.get().getId());
        }else throw new ResourceNotFoundException("Electric vehicle not found for update");

        return electricVehicleRepository.save(electricVehicle);
    }

    @Override
    public void delete(ElectricVehicle electricVehicle) {
        Optional<ElectricVehicle> existing = electricVehicleRepository.findById(electricVehicle.getId());
        if (existing.isPresent()) {
            electricVehicleRepository.delete(existing.get());
        }else throw new ResourceNotFoundException("Electric vehicle not found for delete");
    }

    @Override
    public void deleteById(Long id) {
        Optional<ElectricVehicle> existing = electricVehicleRepository.findById(id);
        if (existing.isPresent()) {
            electricVehicleRepository.delete(existing.get());
        }else throw new ResourceNotFoundException("Electric vehicle with id: " + id + " not found for delete");
    }

    @Override
    public List<ElectricVehicle> findAll() {
        return electricVehicleRepository.findAll();
    }

    @Override
    public Optional<ElectricVehicle> findById(Long id) {
        return electricVehicleRepository.findById(id);
    }
}
