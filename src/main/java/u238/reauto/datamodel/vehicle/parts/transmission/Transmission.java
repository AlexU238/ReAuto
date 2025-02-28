package u238.reauto.datamodel.vehicle.parts.transmission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import u238.reauto.datamodel.vehicle.Vehicle;
import u238.reauto.datamodel.vehicle.parts.engine.Engine;
import u238.reauto.datamodel.vehicle.parts.transmission.enums.Drive;
import u238.reauto.datamodel.vehicle.parts.transmission.enums.TransmissionLocation;
import u238.reauto.datamodel.vehicle.parts.transmission.enums.TransmissionType;

import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Transmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transmission_id")
    private Long id;

    private String model;

    @NotNull
    private TransmissionType type;

    @NotNull
    private TransmissionLocation location;

    @NotNull
    private Drive drive;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "transmission")
    private Collection<Vehicle<Engine>> vehicle;
}
