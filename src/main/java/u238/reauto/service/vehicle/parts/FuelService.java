package u238.reauto.service.vehicle.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.parts.fuel.Fuel;
import u238.reauto.repository.vehicle.parts.fuel.FuelRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuelService implements u238.reauto.service.Service<Fuel,Long> {

    private final FuelRepository fuelRepository;

    @Override
    public Fuel save(Fuel fuel) {
        return fuelRepository.save(fuel);
    }

    @Override
    public Fuel update(Fuel fuel) {
        Optional<Fuel> existing = fuelRepository.findById(fuel.getId());
        if (existing.isPresent()) {
            fuel.setId(existing.get().getId());
        }else throw new RuntimeException("Fuel not found for update");

        return fuelRepository.save(fuel);
    }

    @Override
    public void delete(Fuel fuel) {
        Optional<Fuel> existing = fuelRepository.findById(fuel.getId());
        if (existing.isPresent()) {
            fuelRepository.delete(fuel);
        }else throw new RuntimeException("Fuel not found for delete");
    }

    @Override
    public void deleteById(Long id) {
    Optional<Fuel> existing = fuelRepository.findById(id);
    if (existing.isPresent()) {
        fuelRepository.delete(existing.get());
    }else throw new RuntimeException("Fuel with id: " + id +" not found for delete");
    }

    @Override
    public List<Fuel> findAll() {
        return fuelRepository.findAll();
    }

    @Override
    public Optional<Fuel> findById(Long aLong) {
        return fuelRepository.findById(aLong);
    }
}
