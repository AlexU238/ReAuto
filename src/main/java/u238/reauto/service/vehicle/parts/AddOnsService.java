package u238.reauto.service.vehicle.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.parts.addOns.AddOn;
import u238.reauto.repository.vehicle.parts.addOns.AddOnsRepository;
import u238.reauto.util.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddOnsService implements u238.reauto.service.Service<AddOn,Long> {

    private final AddOnsRepository addOnsRepository;

    @Override
    public AddOn save(AddOn addOn) {
        return addOnsRepository.save(addOn);
    }

    @Override
    public AddOn update(AddOn addOn) {
        Optional<AddOn> existing = addOnsRepository.findById(addOn.getId());
        if(existing.isPresent()) {
            addOn.setId(existing.get().getId());
        }else throw new ResourceNotFoundException("AddOn with id " + addOn.getId() + " does not exist for update");

        return addOnsRepository.save(addOn);
    }

    @Override
    public void delete(AddOn addOn) {
        Optional<AddOn> existing = addOnsRepository.findById(addOn.getId());
        if(existing.isPresent()) {
            addOnsRepository.delete(existing.get());
        }else throw new ResourceNotFoundException("AddOn with id " + addOn.getId() + " does not exist for delete");
    }

    @Override
    public void deleteById(Long id) {
        Optional<AddOn> existing = addOnsRepository.findById(id);
        if(existing.isPresent()) {
            addOnsRepository.delete(existing.get());
        }else throw new ResourceNotFoundException("AddOn with id " + id + " does not exist for delete");
    }

    @Override
    public List<AddOn> findAll() {
        return addOnsRepository.findAll();
    }

    @Override
    public Optional<AddOn> findById(Long id) {
        return addOnsRepository.findById(id);
    }
}
