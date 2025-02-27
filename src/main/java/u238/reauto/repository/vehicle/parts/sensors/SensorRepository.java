package u238.reauto.repository.vehicle.parts.sensors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import u238.reauto.datamodel.vehicle.parts.sensors.Sensor;
import u238.reauto.datamodel.vehicle.parts.sensors.enums.SensorType;
import u238.reauto.repository.DefaultRepository;

import java.util.Optional;

@Repository
public interface SensorRepository extends DefaultRepository<Long, Sensor>, JpaRepository<Sensor, Long> {

    Optional<Sensor> findBySensorType(SensorType sensorType);

}
