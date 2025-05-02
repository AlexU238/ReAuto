package u238.reauto.service.vehicle.parts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import u238.reauto.datamodel.vehicle.parts.addOns.AddOn;
import u238.reauto.repository.vehicle.parts.addOns.AddOnsRepository;

import java.util.List;

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
        AddOn existing = addOnsRepository.findById(addOn.getId()).orElse(null);
        if(existing != null) {
            addOn.setId(existing.getId());
            return addOnsRepository.save(addOn);
        }else throw new NullPointerException("AddOn with id " + addOn.getId() + " does not exist for update");
    }

    @Override
    public void delete(AddOn addOn) {
        AddOn existing = addOnsRepository.findById(addOn.getId()).orElse(null);
        if(existing != null) {
            addOnsRepository.delete(existing);
        }else throw new NullPointerException("AddOn with id " + addOn.getId() + " does not exist for delete");
    }

    @Override
    public void deleteById(Long id) {
        AddOn existing = addOnsRepository.findById(id).orElse(null);
        if(existing != null) {
            addOnsRepository.delete(existing);
        }else throw new NullPointerException("AddOn with id " + id + " does not exist for delete");
    }

    @Override
    public List<AddOn> findAll() {
        return addOnsRepository.findAll();
    }

    @Override
    public AddOn findById(Long aLong) {
        AddOn existing = addOnsRepository.findById(aLong).orElse(null);
        if(existing != null) {
            return existing;
        }else throw new NullPointerException("AddOn with id " + aLong + " does not exist for findById");
    }
}
