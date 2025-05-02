package u238.reauto.service.vehicle;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.ElectricVehicle;
import u238.reauto.repository.vehicle.ElectricVehicleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectricVehicleServiceImpl implements ElectricVehicleService {

    private final ElectricVehicleRepository electricVehicleRepository;

    @Override
    public List<ElectricVehicle> findByDrivingRange(int drivingRange) {
        return List.of();
    }

    @Override
    public ElectricVehicle save(ElectricVehicle electricVehicle) {
        return null;
    }

    @Override
    public ElectricVehicle update(ElectricVehicle electricVehicle) {
        return null;
    }

    @Override
    public void delete(ElectricVehicle electricVehicle) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<ElectricVehicle> findAll() {
        return List.of();
    }

    @Override
    public ElectricVehicle findById(Long aLong) {
        return null;
    }
}
