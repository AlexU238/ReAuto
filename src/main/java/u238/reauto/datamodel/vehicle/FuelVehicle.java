package u238.reauto.datamodel.vehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import u238.reauto.datamodel.vehicle.parts.engine.CombustionEngine;
import u238.reauto.datamodel.vehicle.parts.fuel.Fuel;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuelVehicle extends Vehicle<CombustionEngine> {

    @ManyToOne
    Fuel fuel;

}
