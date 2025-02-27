package u238.reauto.datamodel.vehicle.parts.sensors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import u238.reauto.datamodel.vehicle.Vehicle;
import u238.reauto.datamodel.vehicle.parts.sensors.enums.SensorType;

import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private Long id;

    @NotNull
    private SensorType sensorType;

    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(mappedBy = "sensors")
    private Collection<Vehicle> vehicle;
}
