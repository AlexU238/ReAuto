package u238.reauto.service.vehicle;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.FuelVehicle;
import u238.reauto.datamodel.vehicle.parts.fuel.Fuel;
import u238.reauto.repository.vehicle.FuelVehicleRepository;
import u238.reauto.util.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuelVehicleServiceImpl implements FuelVehicleService {

    private final FuelVehicleRepository fuelVehicleRepository;

    @Override
    public List<FuelVehicle> findByFuel(Fuel fuel) {
        return fuelVehicleRepository.findAllByFuel(fuel);
    }

    @Override
    public FuelVehicle save(FuelVehicle fuelVehicle) {
        return fuelVehicleRepository.save(fuelVehicle);
    }

    @Override
    public FuelVehicle update(FuelVehicle fuelVehicle) {
        Optional<FuelVehicle> existing = fuelVehicleRepository.findById(fuelVehicle.getId());
        if (existing.isPresent()) {
            fuelVehicle.setId(existing.get().getId());
        } else throw new ResourceNotFoundException("Fuel vehicle not found for update");

        return fuelVehicleRepository.save(fuelVehicle);
    }

    @Override
    public void delete(FuelVehicle fuelVehicle) {
        Optional<FuelVehicle> existing = fuelVehicleRepository.findById(fuelVehicle.getId());
        if (existing.isPresent()) {
            fuelVehicleRepository.delete(fuelVehicle);
        }else throw new ResourceNotFoundException("Fuel vehicle not found for delete");
    }

    @Override
    public void deleteById(Long id) {
        Optional<FuelVehicle> existing = fuelVehicleRepository.findById(id);
        if (existing.isPresent()) {
            fuelVehicleRepository.delete(existing.get());
        }else throw new ResourceNotFoundException("Fuel vehicle with id: " + id +" not found for delete");
    }

    @Override
    public List<FuelVehicle> findAll() {
        return fuelVehicleRepository.findAll();
    }

    @Override
    public Optional<FuelVehicle> findById(Long id) {
        return fuelVehicleRepository.findById(id);
    }
}
