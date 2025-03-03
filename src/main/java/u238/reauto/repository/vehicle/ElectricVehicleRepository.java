package u238.reauto.repository.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import u238.reauto.datamodel.vehicle.ElectricVehicle;

import java.util.List;

@Repository
public interface ElectricVehicleRepository extends DefaultVehicleRepository<ElectricVehicle>, JpaRepository<ElectricVehicle, Long> {

    //todo add more methods for more precise search

    List<ElectricVehicle> findAllByDrivingRange(int drivingRange);

}
