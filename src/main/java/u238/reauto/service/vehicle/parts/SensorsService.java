package u238.reauto.service.vehicle.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.parts.sensors.Sensor;
import u238.reauto.repository.vehicle.parts.sensors.SensorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorsService implements u238.reauto.service.Service<Sensor,Long>{

    private final SensorRepository sensorRepository;

    @Override
    public Sensor save(Sensor sensor) {
        return null;
    }

    @Override
    public Sensor update(Sensor sensor) {
        return null;
    }

    @Override
    public void delete(Sensor sensor) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<Sensor> findAll() {
        return List.of();
    }

    @Override
    public Sensor findById(Long aLong) {
        return null;
    }
}
