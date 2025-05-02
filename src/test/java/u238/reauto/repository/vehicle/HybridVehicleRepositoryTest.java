package u238.reauto.repository.vehicle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import u238.reauto.datamodel.vehicle.ElectricVehicle;
import u238.reauto.datamodel.vehicle.FuelVehicle;
import u238.reauto.datamodel.vehicle.HybridVehicle;
import u238.reauto.datamodel.vehicle.enums.VehicleBodyType;
import u238.reauto.datamodel.vehicle.parts.engine.CombustionEngine;
import u238.reauto.datamodel.vehicle.parts.engine.ElectricEngine;
import u238.reauto.datamodel.vehicle.parts.engine.enums.EngineType;
import u238.reauto.datamodel.vehicle.parts.engine.enums.Induction;
import u238.reauto.datamodel.vehicle.parts.fuel.Fuel;
import u238.reauto.datamodel.vehicle.parts.transmission.Transmission;
import u238.reauto.datamodel.vehicle.parts.transmission.enums.Drive;
import u238.reauto.datamodel.vehicle.parts.transmission.enums.TransmissionLocation;
import u238.reauto.datamodel.vehicle.parts.transmission.enums.TransmissionType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@DataJpaTest
public class HybridVehicleRepositoryTest {

    @Autowired
    private HybridVehicleRepository hybridVehicleRepository;

    private Fuel fuel;

    @BeforeEach
    public void setUp(){

        fuel = Fuel.builder().typeOfFuel("Petrol").capacity(60.0).build();
        Transmission transmission = Transmission.builder().type(TransmissionType.CVT).location(TransmissionLocation.STEERING_COLUMN).drive(Drive.ALL_WHEEL).build();

        HybridVehicle hybridVehicle = HybridVehicle.builder()
                .manufacturer("test")
                .bodyType(VehicleBodyType.COUPE)
                .yearOfProduction(2000)
                .model("T60x")
                .fuel(fuel)
                .drivingRange(4000)
                .airbags(2)
                .transmission(transmission)
                .engines(Arrays.asList(CombustionEngine.builder()
                        .type(EngineType.PISTON)
                        .location("Front")
                        .manufacturer("Test")
                        .powerKW(180.0)
                        .sizeLiters(3.6)
                        .induction(Induction.ASPIRATED)
                        .cylinders(6)
                        .build(),
                        ElectricEngine.builder()
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
                                .build()))
                .build();

        HybridVehicle hybridVehicle1 = HybridVehicle.builder()
                .manufacturer("test")
                .bodyType(VehicleBodyType.HATCHBACK)
                .yearOfProduction(2010)
                .model("T80")
                .fuel(fuel)
                .drivingRange(2000)
                .airbags(2)
                .transmission(transmission)
                .engines(Arrays.asList(CombustionEngine.builder()
                        .type(EngineType.PISTON)
                        .location("Front")
                        .manufacturer("Test")
                        .powerKW(180.0)
                        .sizeLiters(3.6)
                        .induction(Induction.ASPIRATED)
                        .cylinders(6)
                        .build(),
                        ElectricEngine.builder()
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
                                .build()))
                .build();
        
        hybridVehicleRepository.save(hybridVehicle);
        hybridVehicleRepository.save(hybridVehicle1);
    }

    @Test
    public void testFindALlByManufacturerSuccess(){
        List<HybridVehicle> vehicles = hybridVehicleRepository.findAllByManufacturer("test");

        Assertions.assertEquals(2, vehicles.size());
        Assertions.assertEquals("test", vehicles.get(0).getManufacturer());
        Assertions.assertEquals("test", vehicles.get(1).getManufacturer());
    }

    @Test
    public void testFindALlByManufacturerFail(){
        List<HybridVehicle> vehicles = hybridVehicleRepository.findAllByManufacturer("test2");

        Assertions.assertEquals(0, vehicles.size());
    }

    @Test
    public void testFindAllByModelSuccess(){
        List<HybridVehicle> vehicles = hybridVehicleRepository.findAllByModel("T80");

        Assertions.assertEquals(1, vehicles.size());
        Assertions.assertEquals("test", vehicles.get(0).getManufacturer());
        Assertions.assertEquals("T80", vehicles.get(0).getModel());
        Assertions.assertEquals(VehicleBodyType.HATCHBACK, vehicles.get(0).getBodyType());
    }

    @Test
    public void testFindAllByModelFail(){
        List<HybridVehicle> vehicles = hybridVehicleRepository.findAllByModel("T90");

        Assertions.assertEquals(0, vehicles.size());
    }

    @Test
    public void testFindAllByYearSuccess(){
        List<HybridVehicle> vehicles = hybridVehicleRepository.findAllByYearOfProduction(2000);

        Assertions.assertEquals(1, vehicles.size());
        Assertions.assertEquals("test", vehicles.get(0).getManufacturer());
        Assertions.assertEquals("T60x", vehicles.get(0).getModel());
    }

    @Test
    public void testFindAllByYearFail(){
        List<HybridVehicle> vehicles = hybridVehicleRepository.findAllByYearOfProduction(2019);

        Assertions.assertEquals(0, vehicles.size());
    }

    @Test
    public void testFindAllByBodyTypeSuccess(){
        List<HybridVehicle> vehicles = hybridVehicleRepository.findAllByBodyType(VehicleBodyType.HATCHBACK);

        Assertions.assertEquals(1, vehicles.size());
        Assertions.assertEquals("test", vehicles.get(0).getManufacturer());
        Assertions.assertEquals("T80", vehicles.get(0).getModel());
        Assertions.assertEquals(VehicleBodyType.HATCHBACK, vehicles.get(0).getBodyType());
    }

    @Test
    public void testFindAllByBodyTypeFail(){
        List<HybridVehicle> vehicles = hybridVehicleRepository.findAllByBodyType(VehicleBodyType.MICRO);

        Assertions.assertEquals(0, vehicles.size());
    }

    @Test
    public void testFindAllByFuelSuccess(){
        List<HybridVehicle> vehicles = hybridVehicleRepository.findAllByFuel(fuel);

        Assertions.assertEquals(2, vehicles.size());
    }

    @Test
    public void testFindAllByFuelFail(){
        List<HybridVehicle> vehicles = hybridVehicleRepository.findAllByFuel(Fuel.builder().id(30L).typeOfFuel("Gas").capacity(20.0).build());

        Assertions.assertEquals(0, vehicles.size());
    }

    @Test
    public void testFindAllByDrivingRangeSuccess(){
        List<HybridVehicle> vehicles = hybridVehicleRepository.findAllByDrivingRange(4000);

        Assertions.assertEquals(1, vehicles.size());
        Assertions.assertEquals("test", vehicles.get(0).getManufacturer());
        Assertions.assertEquals("T60x", vehicles.get(0).getModel());
    }

    @Test
    public void testFindAllByDrivingRangeFail(){
        List<HybridVehicle> vehicles = hybridVehicleRepository.findAllByDrivingRange(1000);

        Assertions.assertEquals(0, vehicles.size());
    }

}
