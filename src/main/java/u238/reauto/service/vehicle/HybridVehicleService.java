package u238.reauto.service.vehicle;

import u238.reauto.datamodel.vehicle.HybridVehicle;
import u238.reauto.datamodel.vehicle.parts.fuel.Fuel;
import u238.reauto.service.Service;

import java.util.List;

public interface HybridVehicleService extends Service<HybridVehicle, Long> {

    List<HybridVehicle> findByFuel(Fuel fuel);

    List<HybridVehicle> findByDrivingRange(int drivingRange);

}
