package u238.reauto.datamodel.vehicle.parts.addOns;

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
@NoArgsConstructor
@AllArgsConstructor
public class AddOn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addOn_Id")
    private Long id;

    @NotBlank
    private String name;

    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(mappedBy = "addOns")
    private Collection<Vehicle> vehicles;
}
