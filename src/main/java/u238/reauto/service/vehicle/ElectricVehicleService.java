package u238.reauto.service.vehicle;

import u238.reauto.datamodel.vehicle.ElectricVehicle;
import u238.reauto.service.Service;

import java.util.List;

public interface ElectricVehicleService extends Service<ElectricVehicle, Long> {

    List<ElectricVehicle> findByDrivingRange(int drivingRange);
}
