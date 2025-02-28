package u238.reauto.repository.vehicle.parts.engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import u238.reauto.datamodel.vehicle.parts.engine.ElectricEngine;
import u238.reauto.datamodel.vehicle.parts.engine.enums.EngineType;

import java.util.List;

@DataJpaTest
public class ElectricEngineRepositoryTest {

    @Autowired
    private ElectricEngineRepository electricEngineRepository;

    @BeforeEach
    public void setUp(){
        ElectricEngine electricEngine = ElectricEngine.builder()
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
                .build();
        ElectricEngine electricEngine2 = ElectricEngine.builder()
                .type(EngineType.ELECTRIC)
                .location("Front")
                .manufacturer("Test")
                .powerKW(180.0)
                .motorBatteryType("Lithium")
                .wallBoxChargingVoltage(60)
                .wallOutletChargingTime(10)
                .chargeTimeDC(17)
                .ampHours(15000)
                .capacity(600)
                .build();
        ElectricEngine electricEngine3 = ElectricEngine.builder()
                .type(EngineType.ELECTRIC)
                .location("Front")
                .manufacturer("Test")
                .powerKW(180.0)
                .motorBatteryType("Magnet")
                .wallBoxChargingVoltage(60)
                .wallOutletChargingTime(10)
                .chargeTimeDC(17)
                .ampHours(13000)
                .capacity(500)
                .build();
        electricEngineRepository.save(electricEngine);
        electricEngineRepository.save(electricEngine2);
        electricEngineRepository.save(electricEngine3);
    }

    @Test
    public void testFindAllByManufacturerSuccess(){
        List<ElectricEngine> electricEngines = electricEngineRepository.findAllByManufacturer("Test");

        Assertions.assertEquals(2, electricEngines.size());
        Assertions.assertEquals("Test", electricEngines.get(0).getManufacturer());
        Assertions.assertEquals("Test", electricEngines.get(1).getManufacturer());
    }

    @Test
    public void testFindAllByManufacturerFailure(){
        List<ElectricEngine> electricEngines = electricEngineRepository.findAllByManufacturer("Fail");

        Assertions.assertEquals(0, electricEngines.size());
    }

    @Test
    public void testFindAllByLocationSuccess(){
        List<ElectricEngine> electricEngines = electricEngineRepository.findAllByLocation("Front");

        Assertions.assertEquals(2, electricEngines.size());
        Assertions.assertEquals("Front", electricEngines.get(0).getLocation());
        Assertions.assertEquals("Front", electricEngines.get(1).getLocation());
    }

    @Test
    public void testFindAllByLocationFailure(){
        List<ElectricEngine> electricEngines = electricEngineRepository.findAllByLocation("Side");

        Assertions.assertEquals(0, electricEngines.size());
    }

    @Test
    public void testFindAllByMotorBatteryTypeSuccess(){
        List<ElectricEngine> engines = electricEngineRepository.findAllByMotorBatteryType("Magnet");

        Assertions.assertEquals(2, engines.size());
        Assertions.assertEquals("Magnet", engines.get(0).getMotorBatteryType());
        Assertions.assertEquals("Magnet", engines.get(1).getMotorBatteryType());
    }

    @Test
    public void testFindAllByMotorBatteryTypeFail(){
        List<ElectricEngine> engines = electricEngineRepository.findAllByMotorBatteryType("Tesla coil");

        Assertions.assertEquals(0, engines.size());
    }

    @Test
    public void testFindAllByAmpHoursSuccess(){
        List<ElectricEngine> engines = electricEngineRepository.findAllByAmpHours(13000);

        Assertions.assertEquals(2, engines.size());
        Assertions.assertEquals(13000, engines.get(0).getAmpHours());
        Assertions.assertEquals(13000, engines.get(1).getAmpHours());
    }

    @Test
    public void testFindAllByAmpHoursFail(){
        List<ElectricEngine> engines = electricEngineRepository.findAllByAmpHours(1);

        Assertions.assertEquals(0, engines.size());
    }

    @Test
    public void testFindAllByWallBoxChargingVoltageSuccess(){
        List<ElectricEngine> engines = electricEngineRepository.findAllByWallBoxChargingVoltage(50);

        Assertions.assertEquals(1, engines.size());
        Assertions.assertEquals(50, engines.get(0).getWallBoxChargingVoltage());

    }

    @Test
    public void testFindAllByWallBoxChargingVoltageFail(){
        List<ElectricEngine> engines = electricEngineRepository.findAllByWallBoxChargingVoltage(1);

        Assertions.assertEquals(0, engines.size());
    }

    @Test
    public void testFindAllByWallOutletChargingTimeSuccess(){
        List<ElectricEngine> engines = electricEngineRepository.findAllByWallOutletChargingTime(12);

        Assertions.assertEquals(1, engines.size());
        Assertions.assertEquals(12, engines.get(0).getWallOutletChargingTime());
    }

    @Test
    public void testFindAllByWallOutletChargingTimeFail(){
        List<ElectricEngine> engines = electricEngineRepository.findAllByWallOutletChargingTime(1);

        Assertions.assertEquals(0, engines.size());
    }

    @Test
    public void testFindAllByChargeTimeDCSuccess(){
        List<ElectricEngine> engines = electricEngineRepository.findAllByChargeTimeDC(17);

        Assertions.assertEquals(2, engines.size());
        Assertions.assertEquals(17, engines.get(0).getChargeTimeDC());
        Assertions.assertEquals(17, engines.get(1).getChargeTimeDC());
    }

    @Test
    public void testFindAllByChargeTimeDCFail(){
        List<ElectricEngine> engines = electricEngineRepository.findAllByChargeTimeDC(1);

        Assertions.assertEquals(0, engines.size());
    }



}
