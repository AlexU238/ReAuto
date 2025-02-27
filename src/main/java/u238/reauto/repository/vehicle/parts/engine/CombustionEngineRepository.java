package u238.reauto.repository.vehicle.parts.engine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import u238.reauto.datamodel.vehicle.parts.engine.CombustionEngine;

import java.util.List;

@Repository
public interface CombustionEngineRepository extends DefaultEngineRepository<CombustionEngine>, JpaRepository<CombustionEngine, Long> {

    List<CombustionEngine> findAllByCylinders(int cylinderNumber);

    List<CombustionEngine> findAllBySizeLiters(double sizeLiters);

}
