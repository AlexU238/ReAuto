package u238.reauto.service.vehicle;

import u238.reauto.datamodel.vehicle.FuelVehicle;
import u238.reauto.datamodel.vehicle.parts.fuel.Fuel;
import u238.reauto.service.Service;

import java.util.List;

public interface FuelVehicleService extends Service<FuelVehicle, Long> {

    List<FuelVehicle> findByFuel(Fuel fuel);
}
