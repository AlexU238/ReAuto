package u238.reauto.repository.vehicle.parts.seats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import u238.reauto.datamodel.vehicle.parts.seats.Seats;
import u238.reauto.repository.DefaultRepository;

import java.util.List;

@Repository
public interface SeatsRepository extends DefaultRepository<Long, Seats>, JpaRepository<Seats, Long> {

}
