package u238.reauto.repository.vehicle.parts.transmission;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import u238.reauto.datamodel.vehicle.parts.transmission.Transmission;
import u238.reauto.datamodel.vehicle.parts.transmission.enums.Drive;
import u238.reauto.datamodel.vehicle.parts.transmission.enums.TransmissionLocation;
import u238.reauto.datamodel.vehicle.parts.transmission.enums.TransmissionType;

import java.util.List;

@DataJpaTest
public class TransmissionRepositoryTest {

    @Autowired
    private TransmissionRepository transmissionRepository;

    @BeforeEach
    public void setUp(){
        Transmission transmission = Transmission.builder()
                .drive(Drive.ALL_WHEEL)
                .type(TransmissionType.MANUAL)
                .location(TransmissionLocation.FLOOR)
                .build();
        Transmission transmission1 = Transmission.builder()
                .drive(Drive.REAR_WHEEL)
                .type(TransmissionType.CVT)
                .location(TransmissionLocation.STEERING_COLUMN)
                .build();
        transmissionRepository.save(transmission);
        transmissionRepository.save(transmission1);
    }

    @Test
    public void testFindAllByTypeSuccess(){
        List<Transmission> transmissions = transmissionRepository.findAllByType(TransmissionType.MANUAL);

        Assertions.assertEquals(1, transmissions.size());
        Assertions.assertEquals(TransmissionType.MANUAL, transmissions.get(0).getType());
        Assertions.assertEquals(Drive.ALL_WHEEL, transmissions.get(0).getDrive());
        Assertions.assertEquals(TransmissionLocation.FLOOR, transmissions.get(0).getLocation());
    }

    @Test
    public void testFindAllByTypeFail(){
        List<Transmission> transmissions = transmissionRepository.findAllByType(TransmissionType.DCT);

        Assertions.assertEquals(0, transmissions.size());

    }

    @Test
    public void testFindAllByLocationSuccess(){
        List<Transmission> transmissions = transmissionRepository.findAllByLocation(TransmissionLocation.STEERING_COLUMN);

        Assertions.assertEquals(1, transmissions.size());
        Assertions.assertEquals(TransmissionLocation.STEERING_COLUMN, transmissions.get(0).getLocation());
        Assertions.assertEquals(TransmissionType.CVT, transmissions.get(0).getType());
        Assertions.assertEquals(Drive.REAR_WHEEL, transmissions.get(0).getDrive());
    }

    @Test
    public void testFindAllByLocationFail(){
        List<Transmission> transmissions = transmissionRepository.findAllByLocation(TransmissionLocation.DASHBOARD);

        Assertions.assertEquals(0, transmissions.size());
    }

    @Test
    public void testFindAllByDriveSuccess(){
        List<Transmission> transmissions = transmissionRepository.findAllByDrive(Drive.REAR_WHEEL);

        Assertions.assertEquals(1, transmissions.size());
        Assertions.assertEquals(Drive.REAR_WHEEL, transmissions.get(0).getDrive());
        Assertions.assertEquals(TransmissionType.CVT, transmissions.get(0).getType());
        Assertions.assertEquals(TransmissionLocation.STEERING_COLUMN, transmissions.get(0).getLocation());
    }

    @Test
    public void testFindAllByDriveFail(){
        List<Transmission> transmissions = transmissionRepository.findAllByDrive(Drive.FRONT_WHEEL);

        Assertions.assertEquals(0, transmissions.size());
    }
}
