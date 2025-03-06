package u238.reauto.datamodel.vehicle;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import u238.reauto.datamodel.vehicle.parts.engine.CombustionEngine;
import u238.reauto.datamodel.vehicle.parts.fuel.Fuel;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class FuelVehicle extends Vehicle<CombustionEngine> {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fuel_id")
    Fuel fuel;

}
