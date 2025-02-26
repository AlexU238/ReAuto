package u238.reauto.datamodel.vehicle.parts.acustics;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import u238.reauto.datamodel.vehicle.Vehicle;

import java.util.Collection;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Acoustics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acoustics_id")
    private Long id;

    @NotBlank
    private String model;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "acoustics")
    private Collection<Vehicle> vehicle;
}
