package u238.reauto.service.advertisement;

import u238.reauto.datamodel.advertisement.VehicleAdvertisement;
import u238.reauto.datamodel.user.User;
import u238.reauto.service.Service;

import java.util.List;

public interface VehicleAdvertisementService extends Service<VehicleAdvertisement, Long> {

    List<VehicleAdvertisement> findAdvertisementsByUser(User user);

}
