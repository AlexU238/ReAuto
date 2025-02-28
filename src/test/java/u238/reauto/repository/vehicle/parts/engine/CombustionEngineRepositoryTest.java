package u238.reauto.repository.vehicle.parts.engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import u238.reauto.datamodel.vehicle.parts.engine.CombustionEngine;
import u238.reauto.datamodel.vehicle.parts.engine.ElectricEngine;
import u238.reauto.datamodel.vehicle.parts.engine.enums.EngineType;
import u238.reauto.datamodel.vehicle.parts.engine.enums.Induction;

import java.util.List;

@DataJpaTest
public class CombustionEngineRepositoryTest {

    @Autowired
    private CombustionEngineRepository combustionEngineRepository;

    @BeforeEach
    public void setUp(){

        CombustionEngine combustionEngine = CombustionEngine.builder()
                .type(EngineType.PISTON)
                .location("Back")
                .manufacturer("Test2")
                .powerKW(180.0)
                .sizeLiters(3.6)
                .induction(Induction.ASPIRATED)
                .cylinders(6)
                .build();

        CombustionEngine combustionEngine2 = CombustionEngine.builder()
                .type(EngineType.PISTON)
                .location("Front")
                .manufacturer("Test")
                .powerKW(180.0)
                .sizeLiters(1.6)
                .induction(Induction.ASPIRATED)
                .cylinders(8)
                .build();

        CombustionEngine combustionEngine3 = CombustionEngine.builder()
                .type(EngineType.PISTON)
                .location("Front")
                .manufacturer("Test")
                .powerKW(180.0)
                .sizeLiters(3.6)
                .induction(Induction.ASPIRATED)
                .cylinders(6)
                .build();
        combustionEngineRepository.save(combustionEngine);
        combustionEngineRepository.save(combustionEngine2);
        combustionEngineRepository.save(combustionEngine3);
    }

    @Test
    public void testFindAllByManufacturerSuccess(){
        List<CombustionEngine> combustionEngines = combustionEngineRepository.findAllByManufacturer("Test");

        Assertions.assertEquals(2, combustionEngines.size());
        Assertions.assertEquals("Test", combustionEngines.get(0).getManufacturer());
        Assertions.assertEquals("Test", combustionEngines.get(1).getManufacturer());
    }

    @Test
    public void testFindAllByManufacturerFailure(){
        List<CombustionEngine> combustionEngines = combustionEngineRepository.findAllByManufacturer("Fail");

        Assertions.assertEquals(0, combustionEngines.size());
    }

    @Test
    public void testFindAllByLocationSuccess(){
        List<CombustionEngine> combustionEngines = combustionEngineRepository.findAllByLocation("Front");
        Assertions.assertEquals(2, combustionEngines.size());

        Assertions.assertEquals("Front", combustionEngines.get(0).getLocation());
        Assertions.assertEquals("Front", combustionEngines.get(1).getLocation());
    }

    @Test
    public void testFindAllByLocationFailure(){
        List<CombustionEngine> combustionEngines = combustionEngineRepository.findAllByLocation("Side");

        Assertions.assertEquals(0, combustionEngines.size());

    }

    @Test
    public void testFindAllByCylindersSuccess(){
        List<CombustionEngine> engines=combustionEngineRepository.findAllByCylinders(6);

        Assertions.assertEquals(2, engines.size());
        Assertions.assertEquals(6, engines.get(0).getCylinders());
        Assertions.assertEquals(6, engines.get(1).getCylinders());
    }

    @Test
    public void testFindAllByCylindersFailure(){
        List<CombustionEngine> engines=combustionEngineRepository.findAllByCylinders(3);

        Assertions.assertEquals(0, engines.size());
    }

    @Test
    public void testFindAllBySizeLitersSuccess(){
        List<CombustionEngine> engines=combustionEngineRepository.findAllBySizeLiters(1.6);

        Assertions.assertEquals(1, engines.size());
    }

    @Test
    public void testFindAllBySizeLitersFailure(){
        List<CombustionEngine> engines=combustionEngineRepository.findAllBySizeLiters(6);

        Assertions.assertEquals(0, engines.size());
    }

}
