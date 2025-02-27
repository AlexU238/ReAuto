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
@Builder
public class CombustionEngine extends Engine {

    private Integer sizeCC; //int cubic centimeters

    private Integer sizeLiters;

    private String engineConfiguration; //Layout of the cylinders within an engine, typically configured in a straight line (in-line) or a V.

    @NotNull
    private Induction induction;

    @NotNull
    private Integer cylinders; //Number of combustion chambers in an internal combustion engine.

    private String camshaft; //The Camshaft is an internal component of a vehicle's engine that provides the correct timings for the valves to take in fuel and expel gasses from the engine.

    private Integer portsPerCylinder;

    private Double compressionRatio;

}
