package be.pxl.examen.model;

import javax.persistence.*;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Table(
        name="dronepilot",
        indexes = {
                @Index(name = "EMAIL_INDEX", columnList = "EMAIL"),
                @Index(name = "DRONECLASS_INDEX", columnList = "DRONECLASS")},
        uniqueConstraints = {
                @UniqueConstraint(columnNames="EMAIL")}
)
public final class Dronepilot {
    @Id
    @GeneratedValue
    private Long id;
    @Column (name = "EMAIL")
    private String email;
    @Column (name = "DRONECLASS")
    @Enumerated(EnumType.STRING)
    private Droneclass droneclass;

    public Dronepilot() {
        // JPA only
    }

    public Dronepilot(String email, Droneclass droneclass) {
        this.email = email;
        this.droneclass = droneclass;
    }

    @Override
    public String toString() {
        return email;
    }

    public boolean allowedToFly(Drone drone) {
        return drone.getDroneclass().ordinal() <= droneclass.ordinal();
    }
}
