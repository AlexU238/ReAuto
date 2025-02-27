package u238.reauto.repository.vehicle.parts.climateControl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import u238.reauto.datamodel.vehicle.parts.climateControl.ClimateControl;
import u238.reauto.repository.DefaultRepository;

@Repository
public interface ClimateControlRepository extends DefaultRepository<Long, ClimateControl>, JpaRepository<ClimateControl, Long> {
}
