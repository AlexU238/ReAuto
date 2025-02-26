package u238.reauto.datamodel.vehicle.parts.climateControl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import u238.reauto.datamodel.vehicle.Vehicle;

import java.util.Collection;

@Entity
@Getter
@Setter
public class ClimateControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "climateControl_id")
    private Long id;

    @NotBlank
    private String type;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "climateControl")
    private Collection<Vehicle> vehicle;
}
