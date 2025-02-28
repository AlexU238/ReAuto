package u238.reauto.repository.vehicle.parts.sensors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import u238.reauto.datamodel.vehicle.parts.sensors.Sensor;
import u238.reauto.datamodel.vehicle.parts.sensors.enums.SensorType;

import java.util.Optional;

@DataJpaTest
public class SensorRepositoryTest {

    @Autowired
    private SensorRepository sensorRepository;

    @BeforeEach
    public void setUp(){
        Sensor sensor = Sensor.builder().sensorType(SensorType.OIL_PRESSURE).build();
        Sensor sensor2 = Sensor.builder().sensorType(SensorType.RAIN).build();
        sensorRepository.save(sensor);
        sensorRepository.save(sensor2);
    }

    @Test
    public void findBySensorTypeSuccess(){
        Optional<Sensor> sensor = sensorRepository.findBySensorType(SensorType.OIL_PRESSURE);

        Assertions.assertTrue(sensor.isPresent());
        Assertions.assertEquals(SensorType.OIL_PRESSURE, sensor.get().getSensorType());
    }

    @Test
    public void findBySensorTypeFail(){
        Optional<Sensor> sensor = sensorRepository.findBySensorType(SensorType.COOLANT);

        Assertions.assertFalse(sensor.isPresent());
    }

}
