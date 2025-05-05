package u238.reauto.service.vehicle.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.parts.sensors.Sensor;
import u238.reauto.repository.vehicle.parts.sensors.SensorRepository;
import u238.reauto.util.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SensorsService implements u238.reauto.service.Service<Sensor,Long>{

    private final SensorRepository sensorRepository;

    @Override
    public Sensor save(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    public Sensor update(Sensor sensor) {
        Optional<Sensor> existing = sensorRepository.findById(sensor.getId());
        if (existing.isPresent()) {
            sensor.setId(existing.get().getId());
        }else throw new ResourceNotFoundException("Sensor not found for update");

        return sensorRepository.save(sensor);
    }

    @Override
    public void delete(Sensor sensor) {
        Optional<Sensor> existing = sensorRepository.findById(sensor.getId());
        if (existing.isPresent()) {
            sensorRepository.delete(existing.get());
        }else throw new ResourceNotFoundException("Sensor not found for delete");
    }

    @Override
    public void deleteById(Long id) {
        Optional<Sensor> existing = sensorRepository.findById(id);
        if (existing.isPresent()) {
            sensorRepository.delete(existing.get());
        }else throw new ResourceNotFoundException("Sensor with id: " + id + " not found for delete");
    }

    @Override
    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    @Override
    public Optional<Sensor> findById(Long aLong) {
        return sensorRepository.findById(aLong);
    }
}
