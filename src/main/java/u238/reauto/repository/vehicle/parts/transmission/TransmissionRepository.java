package u238.reauto.repository.vehicle.parts.transmission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import u238.reauto.datamodel.vehicle.parts.transmission.Transmission;
import u238.reauto.datamodel.vehicle.parts.transmission.enums.Drive;
import u238.reauto.datamodel.vehicle.parts.transmission.enums.TransmissionLocation;
import u238.reauto.datamodel.vehicle.parts.transmission.enums.TransmissionType;
import u238.reauto.repository.DefaultRepository;

import java.util.List;

@Repository
public interface TransmissionRepository extends DefaultRepository<Long, Transmission>, JpaRepository<Transmission, Long> {

    List<Transmission> findAllByType(TransmissionType type);

    List<Transmission> findAllByLocation(TransmissionLocation location);

    List<Transmission> findAllByDrive(Drive drive);

}
