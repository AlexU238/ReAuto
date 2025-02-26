package u238.reauto.datamodel.vehicle.parts.engine;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import u238.reauto.datamodel.vehicle.parts.engine.enums.Induction;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CombustionEngine extends Engine {

    private Integer size; //int cubic centimeters

    @NotNull
    private Induction induction;

    @NotNull
    private Integer cylinders;

    private String camshaft;

    private Integer portsPerCylinder;

    private Double compressionRatio;

}
