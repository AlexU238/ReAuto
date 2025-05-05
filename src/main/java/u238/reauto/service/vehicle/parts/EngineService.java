package u238.reauto.service.vehicle.parts;

import u238.reauto.datamodel.vehicle.parts.engine.Engine;
import u238.reauto.service.Service;

import java.util.List;

public interface EngineService<T extends Engine> extends Service<T,Long> {

    List<T> getAllByManufacturer(String manufacturer);

    List<T> getAllByLocation(String location);

}
