package u238.reauto.service.advertisement;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.advertisement.VehicleAdvertisement;
import u238.reauto.datamodel.user.User;
import u238.reauto.repository.advertisement.AdvertisementRepository;
import u238.reauto.util.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdvertisementService implements VehicleAdvertisementService{

    private final AdvertisementRepository advertisementRepository;

    @Override
    public List<VehicleAdvertisement> findAdvertisementsByUser(User user) {
        return advertisementRepository.findAllByUser(user);
    }

    @Override
    public VehicleAdvertisement save(VehicleAdvertisement vehicleAdvertisement) {
        return advertisementRepository.save(vehicleAdvertisement);
    }

    @Override
    public VehicleAdvertisement update(VehicleAdvertisement vehicleAdvertisement) {
        Optional<VehicleAdvertisement> existing = advertisementRepository.findById(vehicleAdvertisement.getId());
        if (existing.isPresent()) {
            vehicleAdvertisement.setId(existing.get().getId());
        }else throw new ResourceNotFoundException("Vehicle advertisement for update not found");

        return advertisementRepository.save(vehicleAdvertisement);
    }

    @Override
    public void delete(VehicleAdvertisement vehicleAdvertisement) {
        Optional<VehicleAdvertisement> existing = advertisementRepository.findById(vehicleAdvertisement.getId());
        if (existing.isPresent()) {
            advertisementRepository.delete(existing.get());
        } else throw new ResourceNotFoundException("Vehicle advertisement for delete not found");
    }

    @Override
    public void deleteById(Long id) {
        Optional<VehicleAdvertisement> existing = advertisementRepository.findById(id);
        if (existing.isPresent()) {
            advertisementRepository.delete(existing.get());
        }else throw new ResourceNotFoundException("Vehicle advertisement with id: " +id+ " for delete not found");
    }

    @Override
    public List<VehicleAdvertisement> findAll() {
        return advertisementRepository.findAll();
    }

    @Override
    public Optional<VehicleAdvertisement> findById(Long id) {
        return advertisementRepository.findById(id);
    }
}
