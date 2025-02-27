package u238.reauto.repository.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import u238.reauto.datamodel.vehicle.FuelVehicle;
import u238.reauto.datamodel.vehicle.parts.fuel.Fuel;

import java.util.List;

@Repository
public interface FuelVehicleRepository extends DefaultVehicleRepository<FuelVehicle>, JpaRepository<FuelVehicle, Long> {

//todo add more methods for more precise search

    List<FuelVehicle> findAllByFuel(Fuel fuel);

}
