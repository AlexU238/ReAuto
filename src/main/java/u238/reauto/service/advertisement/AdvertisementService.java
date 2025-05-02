package u238.reauto.service.advertisement;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.advertisement.VehicleAdvertisement;
import u238.reauto.datamodel.user.User;
import u238.reauto.repository.advertisement.AdvertisementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvertisementService implements VehicleAdvertisementService{

    private final AdvertisementRepository advertisementRepository;

    @Override
    public void findAdvertisementsByUser(User user) {

    }

    @Override
    public VehicleAdvertisement save(VehicleAdvertisement vehicleAdvertisement) {
        return null;
    }

    @Override
    public VehicleAdvertisement update(VehicleAdvertisement vehicleAdvertisement) {
        return null;
    }

    @Override
    public void delete(VehicleAdvertisement vehicleAdvertisement) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<VehicleAdvertisement> findAll() {
        return List.of();
    }

    @Override
    public VehicleAdvertisement findById(Long aLong) {
        return null;
    }
}
