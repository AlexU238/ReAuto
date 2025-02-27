package u238.reauto.datamodel.vehicle;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import u238.reauto.datamodel.vehicle.parts.engine.ElectricEngine;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElectricVehicle extends Vehicle<ElectricEngine> {

    @NotNull
    Integer drivingRange;
}
