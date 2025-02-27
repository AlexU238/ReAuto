package u238.reauto.datamodel.vehicle.parts.seats;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import u238.reauto.datamodel.vehicle.Vehicle;

import java.util.Collection;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seats_id")
    private Long id;

    @NotNull
    private Integer number;

    private String material;

    private boolean heating;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "seats")
    private Collection<Vehicle> vehicles;
}
