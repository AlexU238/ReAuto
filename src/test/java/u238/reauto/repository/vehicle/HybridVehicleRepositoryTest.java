package u238.reauto.repository.vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
    public void testFindALlByManufacturerSuccess(){}

    @Test
    public void testFindALlByManufacturerFail(){}

    @Test
    public void testFindAllByModelSuccess(){}

    @Test
    public void testFindAllByModelFail(){}

    @Test
    public void testFindAllByYearSuccess(){}

    @Test
    public void testFindAllByYearFail(){}

    @Test
    public void testFindAllByBodyTypeSuccess(){}

    @Test
    public void testFindAllByBodyTypeFail(){}

}
