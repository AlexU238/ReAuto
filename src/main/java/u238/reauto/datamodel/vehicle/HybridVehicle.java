package u238.reauto.datamodel.vehicle;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import u238.reauto.datamodel.vehicle.parts.engine.Engine;
import u238.reauto.datamodel.vehicle.parts.fuel.Fuel;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class HybridVehicle extends Vehicle<Engine> {

    @NonNull
    Integer drivingRange;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fuel_id")
    Fuel fuel;

}
