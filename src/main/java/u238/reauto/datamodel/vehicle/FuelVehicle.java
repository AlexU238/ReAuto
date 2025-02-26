package u238.reauto.datamodel.vehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import u238.reauto.datamodel.vehicle.parts.fuel.Fuel;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FuelVehicle extends Vehicle {

    @ManyToOne
    Fuel fuel;


}
