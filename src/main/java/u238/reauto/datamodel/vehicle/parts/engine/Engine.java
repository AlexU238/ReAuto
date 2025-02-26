package u238.reauto.datamodel.vehicle.parts.engine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import u238.reauto.datamodel.vehicle.Vehicle;
import u238.reauto.datamodel.vehicle.parts.engine.enums.EngineType;

import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "engine_id")
    protected Long id;

    protected EngineType type;

    @NotBlank
    protected String location;

    @NotBlank
    protected String manufacturer;

    protected Integer powerRPMFrom;

    protected Integer powerRPMTo;

    protected Integer torqueRPMFrom;

    protected Integer torqueRPMTo;

    protected Double powerToWeightRatio;

    @NotNull
    protected Double power;

    protected Double torque;

    protected String manufacturerCode;

    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(mappedBy = "engines")
    protected Collection<Vehicle> vehicle;

}
