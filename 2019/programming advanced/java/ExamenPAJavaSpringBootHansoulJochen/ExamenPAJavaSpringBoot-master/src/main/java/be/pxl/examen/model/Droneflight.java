package be.pxl.examen.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(
        name="droneflight",
        indexes = {
                @Index(name = "DATE_INDEX", columnList = "DATE")}
)
public class Droneflight {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(mappedBy = "pilot")
    private Dronepilot pilot;
    @OneToOne(mappedBy = "drone")
    private Drone drone;
    @Column (name = "DATE")
    private LocalDate date;

    public Droneflight() {
        // JPA only
    }

    public Droneflight(Dronepilot pilot, Drone drone, LocalDate date) {
        this.pilot = pilot;
        this.drone = drone;
        this.date = date;
    }

    public Drone getDrone() {
        return drone;
    }

    public LocalDate getDate() {
        return date;
    }

    public Dronepilot getPilot() {
        return pilot;
    }

}
