package u238.reauto.repository.vehicle.parts.addOns;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import u238.reauto.datamodel.vehicle.parts.addOns.AddOn;
import u238.reauto.repository.DefaultRepository;

@Repository
public interface AddOnsRepository extends DefaultRepository<Long, AddOn>, JpaRepository<AddOn, Long> {
}
