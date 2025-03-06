package u238.reauto.repository.vehicle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import u238.reauto.datamodel.vehicle.FuelVehicle;
import u238.reauto.datamodel.vehicle.enums.VehicleBodyType;
import u238.reauto.datamodel.vehicle.parts.fuel.Fuel;
import u238.reauto.datamodel.vehicle.parts.transmission.Transmission;
import u238.reauto.datamodel.vehicle.parts.transmission.enums.Drive;
import u238.reauto.datamodel.vehicle.parts.transmission.enums.TransmissionLocation;
import u238.reauto.datamodel.vehicle.parts.transmission.enums.TransmissionType;

import java.util.List;

@DataJpaTest
public class FuelVehicleRepositoryTest {

    @Autowired
    private FuelVehicleRepository fuelVehicleRepository;

    private Fuel fuel;

    @BeforeEach
    public void setUp(){

        fuel = Fuel.builder().typeOfFuel("Petrol").capacity(60.0).build();
        Transmission transmission = Transmission.builder().type(TransmissionType.CVT).location(TransmissionLocation.STEERING_COLUMN).drive(Drive.ALL_WHEEL).build();

        FuelVehicle fuelVehicle = FuelVehicle.builder()
                .manufacturer("test")
                .bodyType(VehicleBodyType.COUPE)
                .yearOfProduction(2000)
                .model("T60x")
                .fuel(fuel)
                .airbags(2)
                .transmission(transmission)
                .build();
        FuelVehicle fuelVehicle1 = FuelVehicle.builder()
                .manufacturer("test")
                .bodyType(VehicleBodyType.HATCHBACK)
                .yearOfProduction(2010)
                .model("T80")
                .fuel(fuel)
                .airbags(2)
                .transmission(transmission)
                .build();

        fuelVehicleRepository.save(fuelVehicle);
        fuelVehicleRepository.save(fuelVehicle1);
    }

    @Test
    public void testFindALlByManufacturerSuccess(){
        List<FuelVehicle> fuelVehicles = fuelVehicleRepository.findAllByManufacturer("test");

        Assertions.assertEquals(2, fuelVehicles.size());
        Assertions.assertEquals("test", fuelVehicles.get(0).getManufacturer());
        Assertions.assertEquals("test", fuelVehicles.get(1).getManufacturer());
    }

    @Test
    public void testFindALlByManufacturerFail(){
        List<FuelVehicle> fuelVehicles = fuelVehicleRepository.findAllByManufacturer("test2");

        Assertions.assertEquals(0, fuelVehicles.size());

    }

    @Test
    public void testFindAllByModelSuccess() {
        List<FuelVehicle> fuelVehicles = fuelVehicleRepository.findAllByModel("T80");

        Assertions.assertEquals(1, fuelVehicles.size());
        Assertions.assertEquals("test", fuelVehicles.get(0).getManufacturer());
        Assertions.assertEquals("T80", fuelVehicles.get(0).getModel());
        Assertions.assertEquals(VehicleBodyType.HATCHBACK, fuelVehicles.get(0).getBodyType());
    }

    @Test
    public void testFindAllByModelFail(){
        List<FuelVehicle> fuelVehicles = fuelVehicleRepository.findAllByModel("T90");

        Assertions.assertEquals(0, fuelVehicles.size());
    }

    @Test
    public void testFindAllByYearSuccess(){
        List<FuelVehicle> fuelVehicles = fuelVehicleRepository.findAllByYearOfProduction(2000);

        Assertions.assertEquals(1, fuelVehicles.size());
        Assertions.assertEquals("test", fuelVehicles.get(0).getManufacturer());
        Assertions.assertEquals("T60x", fuelVehicles.get(0).getModel());
    }

    @Test
    public void testFindAllByYearFail(){
        List<FuelVehicle> fuelVehicles = fuelVehicleRepository.findAllByYearOfProduction(2019);

        Assertions.assertEquals(0, fuelVehicles.size());
    }

    @Test
    public void testFindAllByBodyTypeSuccess(){
        List<FuelVehicle> fuelVehicles = fuelVehicleRepository.findAllByBodyType(VehicleBodyType.HATCHBACK);

        Assertions.assertEquals(1, fuelVehicles.size());
        Assertions.assertEquals("test", fuelVehicles.get(0).getManufacturer());
        Assertions.assertEquals("T80", fuelVehicles.get(0).getModel());
        Assertions.assertEquals(VehicleBodyType.HATCHBACK, fuelVehicles.get(0).getBodyType());
    }

    @Test
    public void testFindAllByBodyTypeFail(){
        List<FuelVehicle> fuelVehicles = fuelVehicleRepository.findAllByBodyType(VehicleBodyType.MICRO);

        Assertions.assertEquals(0, fuelVehicles.size());
    }

    @Test
    public void testFindAllByFuelSuccess(){
        List<FuelVehicle> fuelVehicles = fuelVehicleRepository.findAllByFuel(fuel);

        Assertions.assertEquals(2, fuelVehicles.size());
    }

    @Test
    public void testFindAllByFuelFail(){
        List<FuelVehicle> fuelVehicles = fuelVehicleRepository.findAllByFuel(Fuel.builder().id(30L).typeOfFuel("Gas").capacity(20.0).build());

        Assertions.assertEquals(0, fuelVehicles.size());
    }

}
