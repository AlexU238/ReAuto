package u238.reauto.repository.vehicle.parts.fuel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import u238.reauto.datamodel.vehicle.parts.fuel.Fuel;

import java.util.List;

@DataJpaTest
public class FuelRepositoryTest {

    @Autowired
    private FuelRepository fuelRepository;

    @BeforeEach
    public void setUp(){
        Fuel fuel = Fuel.builder()
                .capacity(200.0)
                .typeOfFuel("Petrol")
                .build();

        Fuel fuel1 = Fuel.builder()
                .capacity(150.0)
                .typeOfFuel("Bio")
                .build();

        fuelRepository.save(fuel);
        fuelRepository.save(fuel1);
    }

    @Test
    public void testFindAllByCapacitySuccess(){
        List<Fuel> fuels = fuelRepository.findAllByCapacity(150.0);

        Assertions.assertEquals(1, fuels.size());
        Assertions.assertEquals(150.0, fuels.get(0).getCapacity());
        Assertions.assertEquals("Bio", fuels.get(0).getTypeOfFuel());
    }

    @Test
    public void testFindAllByCapacityFail(){
        List<Fuel> fuels = fuelRepository.findAllByCapacity(250.0);

        Assertions.assertEquals(0, fuels.size());
    }

    @Test
    public void testFindAllByTypeSuccess(){
        List<Fuel> fuels = fuelRepository.findAllByTypeOfFuel("Petrol");
        Assertions.assertEquals(1, fuels.size());
        Assertions.assertEquals(200.0, fuels.get(0).getCapacity());
        Assertions.assertEquals("Petrol", fuels.get(0).getTypeOfFuel());
    }

    @Test
    public void testFindAllByTypeFail(){
        List<Fuel> fuels = fuelRepository.findAllByTypeOfFuel("Dizel");

        Assertions.assertEquals(0, fuels.size());

    }
}
