package u238.reauto.repository.vehicle.parts.engine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import u238.reauto.datamodel.vehicle.parts.engine.ElectricEngine;

import java.util.List;

@Repository
public interface ElectricEngineRepository extends DefaultEngineRepository<ElectricEngine>, JpaRepository<ElectricEngine, Long> {

    List<ElectricEngine> findAllByMotorBatteryType(String motorBatteryType);

    List<ElectricEngine> findAllByAmpHours(int ampHours);

    List<ElectricEngine> findAllByWallBoxChargingVoltage(int wallBoxChargingVoltage);

    List<ElectricEngine> findAllByWallOutletChargingTime(int wallOutletChargingTime);

    List<ElectricEngine> findAllByChargeTimeDC(int chargeTimeDC);

}
