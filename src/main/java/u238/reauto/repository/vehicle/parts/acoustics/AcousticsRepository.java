package u238.reauto.repository.vehicle.parts.acoustics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import u238.reauto.datamodel.vehicle.parts.acustics.Acoustics;
import u238.reauto.repository.DefaultRepository;

@Repository
public interface AcousticsRepository extends DefaultRepository<Long, Acoustics>, JpaRepository<Acoustics, Long> {

}
