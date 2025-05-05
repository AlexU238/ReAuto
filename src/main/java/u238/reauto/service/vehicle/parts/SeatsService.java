package u238.reauto.service.vehicle.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.parts.seats.Seats;
import u238.reauto.repository.vehicle.parts.seats.SeatsRepository;
import u238.reauto.util.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SeatsService implements u238.reauto.service.Service<Seats,Long> {

    private final SeatsRepository seatsRepository;

    @Override
    public Seats save(Seats seats) {
        return seatsRepository.save(seats);
    }

    @Override
    public Seats update(Seats seats) {
        Optional<Seats> existing = seatsRepository.findById(seats.getId());
        if (existing.isPresent()) {
            seats.setId(existing.get().getId());
        }else throw new ResourceNotFoundException("Seats not found for update");

        return seatsRepository.save(seats);
    }

    @Override
    public void delete(Seats seats) {
        Optional<Seats> existing = seatsRepository.findById(seats.getId());
        if (existing.isPresent()) {
            seatsRepository.delete(existing.get());
        }else throw new ResourceNotFoundException("Seats not found for delete");
    }

    @Override
    public void deleteById(Long id) {
    Optional<Seats> existing = seatsRepository.findById(id);
    if (existing.isPresent()) {
        seatsRepository.delete(existing.get());
    }else throw new ResourceNotFoundException("Seats with id: " + id +"not found for delete");
    }

    @Override
    public List<Seats> findAll() {
        return seatsRepository.findAll();
    }

    @Override
    public Optional<Seats> findById(Long aLong) {
        return seatsRepository.findById(aLong);
    }
}
