package u238.reauto.repository.vehicle.parts.fuel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import u238.reauto.datamodel.vehicle.parts.fuel.Fuel;
import u238.reauto.repository.DefaultRepository;

import java.util.List;

@Repository
public interface FuelRepository extends DefaultRepository<Long, Fuel>, JpaRepository<Fuel, Long> {

    List<Fuel> findAllByCapacity(double capacity);

    List<Fuel> findAllByTypeOfFuel(String type);
}
