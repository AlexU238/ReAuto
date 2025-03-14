package u238.reauto.datamodel.vehicle.parts.engine;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ElectricEngine extends Engine {

    @NotBlank
    private String motorBatteryType;

    @NotNull
    private Integer wallBoxChargingVoltage;

    @NotNull
    private Integer wallOutletChargingTime;

    @NotNull
    private Integer chargeTimeDC;

    private String alternativeChargingMethod;

    @NotNull
    private Integer ampHours;

    @NotNull
    private Integer capacity;

}
