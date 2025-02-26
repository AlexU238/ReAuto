package u238.reauto.datamodel.advertisement;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import u238.reauto.datamodel.user.User;
import u238.reauto.datamodel.vehicle.Vehicle;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advertisement_id")
    private Long id;

    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;

    @NotNull
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
