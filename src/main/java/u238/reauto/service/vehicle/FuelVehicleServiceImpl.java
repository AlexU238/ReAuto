package u238.reauto.service.vehicle;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.FuelVehicle;
import u238.reauto.datamodel.vehicle.parts.fuel.Fuel;
import u238.reauto.repository.vehicle.FuelVehicleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelVehicleServiceImpl implements FuelVehicleService {

    private final FuelVehicleRepository fuelVehicleRepository;

    @Override
    public List<FuelVehicle> findByFuel(Fuel fuel) {
        return List.of();
    }

    @Override
    public FuelVehicle save(FuelVehicle fuelVehicle) {
        return null;
    }

    @Override
    public FuelVehicle update(FuelVehicle fuelVehicle) {
        return null;
    }

    @Override
    public void delete(FuelVehicle fuelVehicle) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<FuelVehicle> findAll() {
        return List.of();
    }

    @Override
    public FuelVehicle findById(Long aLong) {
        return null;
    }
}
