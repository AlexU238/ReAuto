package u238.reauto.repository.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import u238.reauto.datamodel.vehicle.Vehicle;
import u238.reauto.datamodel.vehicle.enums.VehicleBodyType;
import u238.reauto.repository.DefaultRepository;

import java.util.List;

public interface DefaultVehicleRepository<T> extends DefaultRepository<Long, T> {

    List<T> findAllByManufacturer(String manufacturer);

    List<T> findAllByModel(String model);

    List<T> findAllByYear(int year);

    List<T> findAllByBodyType(VehicleBodyType type);

}
