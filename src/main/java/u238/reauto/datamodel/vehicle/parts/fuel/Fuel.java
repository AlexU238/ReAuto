package u238.reauto.datamodel.vehicle.parts.fuel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import u238.reauto.datamodel.vehicle.FuelVehicle;
import u238.reauto.datamodel.vehicle.HybridVehicle;

import java.util.Collection;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fuel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fuel_id")
    private Long id;

    @NotNull
    private Double capacity;

    @NotNull
    private String type;

    private double fuelConsumptionCombined;

    private double fuelConsumptionHighway;

    private double fuelConsumptionCity;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "fuel")
    private Collection<FuelVehicle>fuelVehicles;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "fuel")
    private Collection<HybridVehicle>hybridVehicles;
}
