package u238.reauto.datamodel.vehicle;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElectricVehicle extends Vehicle {

    @NotNull
    Integer drivingRange;
}
