package u238.reauto.service.vehicle.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.parts.fuel.Fuel;
import u238.reauto.repository.vehicle.parts.fuel.FuelRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelService implements u238.reauto.service.Service<Fuel,Long> {

    private final FuelRepository fuelRepository;

    @Override
    public Fuel save(Fuel fuel) {
        return null;
    }

    @Override
    public Fuel update(Fuel fuel) {
        return null;
    }

    @Override
    public void delete(Fuel fuel) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<Fuel> findAll() {
        return List.of();
    }

    @Override
    public Fuel findById(Long aLong) {
        return null;
    }
}
