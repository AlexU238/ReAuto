package u238.reauto.datamodel.vehicle;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import u238.reauto.datamodel.vehicle.parts.engine.ElectricEngine;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ElectricVehicle extends Vehicle<ElectricEngine> {

    @NotNull
    Integer drivingRange;
}
