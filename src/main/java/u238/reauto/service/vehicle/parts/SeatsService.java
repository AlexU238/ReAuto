package u238.reauto.service.vehicle.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.parts.seats.Seats;
import u238.reauto.repository.vehicle.parts.seats.SeatsRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SeatsService implements u238.reauto.service.Service<Seats,Long> {

    private final SeatsRepository seatsRepository;

    @Override
    public Seats save(Seats seats) {
        return null;
    }

    @Override
    public Seats update(Seats seats) {
        return null;
    }

    @Override
    public void delete(Seats seats) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<Seats> findAll() {
        return List.of();
    }

    @Override
    public Seats findById(Long aLong) {
        return null;
    }
}
