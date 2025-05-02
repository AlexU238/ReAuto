package u238.reauto.service.vehicle;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.HybridVehicle;
import u238.reauto.datamodel.vehicle.parts.fuel.Fuel;
import u238.reauto.repository.vehicle.HybridVehicleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HybridVehicleServiceImpl implements HybridVehicleService {

    private final HybridVehicleRepository hybridVehicleRepository;

    @Override
    public List<HybridVehicle> findByFuel(Fuel fuel) {
        return List.of();
    }

    @Override
    public List<HybridVehicle> findByDrivingRange(int drivingRange) {
        return List.of();
    }

    @Override
    public HybridVehicle save(HybridVehicle hybridVehicle) {
        return null;
    }

    @Override
    public HybridVehicle update(HybridVehicle hybridVehicle) {
        return null;
    }

    @Override
    public void delete(HybridVehicle hybridVehicle) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<HybridVehicle> findAll() {
        return List.of();
    }

    @Override
    public HybridVehicle findById(Long aLong) {
        return null;
    }
}
