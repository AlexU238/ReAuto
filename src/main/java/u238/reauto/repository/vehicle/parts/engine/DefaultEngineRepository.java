package u238.reauto.repository.vehicle.parts.engine;

import u238.reauto.repository.DefaultRepository;

import java.util.List;

public interface DefaultEngineRepository<T> extends DefaultRepository<Long,T> {

    List<T> findAllByManufacturer(String manufacturer);

    List<T> findAllByLocation(String location);

}
