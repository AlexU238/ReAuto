package u238.reauto.repository.advertisement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import u238.reauto.datamodel.advertisement.VehicleAdvertisement;
import u238.reauto.repository.DefaultRepository;

@Repository
public interface AdvertisementRepository extends DefaultRepository<Long, VehicleAdvertisement>, JpaRepository<VehicleAdvertisement, Long> {

}
