package u238.reauto.repository.vehicle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import u238.reauto.datamodel.vehicle.ElectricVehicle;
import u238.reauto.datamodel.vehicle.enums.VehicleBodyType;
import u238.reauto.datamodel.vehicle.parts.engine.CombustionEngine;
import u238.reauto.datamodel.vehicle.parts.engine.ElectricEngine;
import u238.reauto.datamodel.vehicle.parts.engine.enums.EngineType;
import u238.reauto.datamodel.vehicle.parts.transmission.Transmission;
import u238.reauto.datamodel.vehicle.parts.transmission.enums.Drive;
import u238.reauto.datamodel.vehicle.parts.transmission.enums.TransmissionLocation;
import u238.reauto.datamodel.vehicle.parts.transmission.enums.TransmissionType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@DataJpaTest
public class ElectricVehicleRepositoryTest {

    @Autowired
    private ElectricVehicleRepository electricVehicleRepository;

    @BeforeEach
    public void setUp(){
        Transmission transmission = Transmission.builder().type(TransmissionType.CVT).location(TransmissionLocation.STEERING_COLUMN).drive(Drive.ALL_WHEEL).build();

        ElectricVehicle electricVehicle = ElectricVehicle.builder()
                .manufacturer("Test")
                .bodyType(VehicleBodyType.COUPE)
                .yearOfProduction(2011)
                .model("T45")
                .drivingRange(2000)
                .airbags(2)
                .transmission(transmission)
                .engines(new ArrayList<>(Collections.singletonList(ElectricEngine.builder()
                        .type(EngineType.ELECTRIC)
                        .location("Back")
                        .manufacturer("Test2")
                        .powerKW(180.0)
                        .motorBatteryType("Magnet")
                        .wallBoxChargingVoltage(50)
                        .wallOutletChargingTime(12)
                        .chargeTimeDC(14)
                        .ampHours(13000)
                        .capacity(500)
                        .build())))
                .build();

        ElectricVehicle electricVehicle1 = ElectricVehicle.builder()
                .manufacturer("Test2")
                .bodyType(VehicleBodyType.CABRIOLET)
                .yearOfProduction(2020)
                .model("T60")
                .drivingRange(4000)
                .airbags(2)
                .transmission(transmission)
                .engines(new ArrayList<>(Collections.singletonList(ElectricEngine.builder()
                        .type(EngineType.ELECTRIC)
                        .location("Back")
                        .manufacturer("Test2")
                        .powerKW(180.0)
                        .motorBatteryType("Magnet")
                        .wallBoxChargingVoltage(50)
                        .wallOutletChargingTime(12)
                        .chargeTimeDC(14)
                        .ampHours(13000)
                        .capacity(500)
                        .build())))
                .build();

        electricVehicleRepository.save(electricVehicle);
        electricVehicleRepository.save(electricVehicle1);
    }

    @Test
    public void testFindALlByManufacturerSuccess(){
        List<ElectricVehicle> vehicles = electricVehicleRepository.findAllByManufacturer("Test2");

        Assertions.assertEquals(1, vehicles.size());
        Assertions.assertEquals("Test2", vehicles.get(0).getManufacturer());
        Assertions.assertEquals("T60", vehicles.get(0).getModel());
    }

    @Test
    public void testFindALlByManufacturerFail(){
        List<ElectricVehicle> vehicles = electricVehicleRepository.findAllByManufacturer("Test3");

        Assertions.assertEquals(0, vehicles.size());
    }

    @Test
    public void testFindAllByModelSuccess(){
        List<ElectricVehicle> vehicles = electricVehicleRepository.findAllByModel("T45");

        Assertions.assertEquals(1, vehicles.size());
        Assertions.assertEquals("T45", vehicles.get(0).getModel());
        Assertions.assertEquals("Test", vehicles.get(0).getManufacturer());

    }

    @Test
    public void testFindAllByModelFail(){
        List<ElectricVehicle> vehicles = electricVehicleRepository.findAllByModel("T20");

        Assertions.assertEquals(0, vehicles.size());
    }

    @Test
    public void testFindAllByYearSuccess(){
        List<ElectricVehicle> vehicles = electricVehicleRepository.findAllByYearOfProduction(2020);

        Assertions.assertEquals(1, vehicles.size());
        Assertions.assertEquals("Test2", vehicles.get(0).getManufacturer());
        Assertions.assertEquals("T60", vehicles.get(0).getModel());

    }

    @Test
    public void testFindAllByYearFail(){
        List<ElectricVehicle> vehicles = electricVehicleRepository.findAllByYearOfProduction(2025);

        Assertions.assertEquals(0, vehicles.size());
    }

    @Test
    public void testFindAllByBodyTypeSuccess(){
        List<ElectricVehicle> vehicles = electricVehicleRepository.findAllByBodyType(VehicleBodyType.CABRIOLET);

        Assertions.assertEquals(1, vehicles.size());
        Assertions.assertEquals("Test2", vehicles.get(0).getManufacturer());
        Assertions.assertEquals("T60", vehicles.get(0).getModel());
    }

    @Test
    public void testFindAllByBodyTypeFail(){
        List<ElectricVehicle> vehicles = electricVehicleRepository.findAllByBodyType(VehicleBodyType.HATCHBACK);

        Assertions.assertEquals(0, vehicles.size());
    }

    @Test
    public void testFindAllByDrivingRangeSuccess(){
        List<ElectricVehicle> vehicles = electricVehicleRepository.findAllByDrivingRange(4000);

        Assertions.assertEquals(1, vehicles.size());
        Assertions.assertEquals("Test2", vehicles.get(0).getManufacturer());
        Assertions.assertEquals("T60", vehicles.get(0).getModel());
    }

    @Test
    public void testFindAllByDrivingRangeFail(){
        List<ElectricVehicle> vehicles = electricVehicleRepository.findAllByDrivingRange(1000);

        Assertions.assertEquals(0, vehicles.size());
    }
}
