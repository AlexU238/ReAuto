package u238.reauto.datamodel.vehicle;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import u238.reauto.datamodel.user.User;
import u238.reauto.datamodel.vehicle.enums.VehicleBodyType;
import u238.reauto.datamodel.vehicle.parts.acustics.Acoustics;
import u238.reauto.datamodel.vehicle.parts.addOns.AddOn;
import u238.reauto.datamodel.vehicle.parts.climateControl.ClimateControl;
import u238.reauto.datamodel.vehicle.parts.engine.Engine;
import u238.reauto.datamodel.vehicle.parts.seats.Seats;
import u238.reauto.datamodel.vehicle.parts.sensors.Sensor;
import u238.reauto.datamodel.vehicle.parts.transmission.Transmission;

import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@ToString
public abstract class Vehicle<E extends Engine> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "vehicle_id")
    protected Long id;

    @NotBlank
    protected String manufacturer;

    @NotNull
    protected VehicleBodyType bodyType;

    @NotNull
    protected Integer year;

    @NotBlank
    protected String model;

    @ManyToMany
    @JoinTable(
            name = "vehicle_engine",
            joinColumns = {@JoinColumn(name = "engine_id")},
            inverseJoinColumns = {@JoinColumn(name = "vehicle_id")}
    )
    protected Collection<E> engines;

    @ManyToOne
    @JoinColumn(name = "climateControl_id")
    protected ClimateControl climateControl;

    @ManyToOne
    @JoinColumn(name="transmission_id", nullable = false)
    @NotNull
    protected Transmission transmission;

    @ManyToOne
    @JoinColumn(name = "acoustics_id")
    protected Acoustics acoustics;

    @NotNull
    protected Integer airbags;

    @ManyToMany
    @JoinTable(
            name = "vehicle_sensor",
            joinColumns = {@JoinColumn(name = "sensor_id")},
            inverseJoinColumns = {@JoinColumn(name = "vehicle_id")}
    )
    protected Collection<Sensor>sensors;

    @ManyToOne
    @JoinColumn(name = "seats_id")
    protected Seats seats;

    @ManyToMany
    @JoinTable(
            name="vehicle_addOn",
            joinColumns = {@JoinColumn(name = "addOn_id")},
            inverseJoinColumns = {@JoinColumn(name = "vehicle_id")}
    )
    protected Collection<AddOn> addOns;

    @ManyToOne
    @JoinColumn(name = "user_id")
    protected User user;
}
