package u238.reauto.repository.vehicle;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import u238.reauto.datamodel.vehicle.HybridVehicle;
import u238.reauto.datamodel.vehicle.parts.fuel.Fuel;

import java.util.List;

@Repository
public interface HybridVehicleRepository extends DefaultVehicleRepository<HybridVehicle>, JpaRepository<HybridVehicle, Long> {

    //todo add more methods for more precise search

    List<HybridVehicle> findAllByFuel( Fuel fuel);

    List<HybridVehicle> findAllByDrivingRange(int drivingRange);

}
