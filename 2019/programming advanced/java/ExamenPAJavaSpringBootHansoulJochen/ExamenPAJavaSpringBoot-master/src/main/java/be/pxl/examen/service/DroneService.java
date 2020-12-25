package be.pxl.examen.service;

import be.pxl.examen.exception.DroneUnavailableException;
import be.pxl.examen.exception.NotQualifiedException;
import be.pxl.examen.model.Drone;
import be.pxl.examen.model.Droneflight;
import be.pxl.examen.model.Dronepilot;
import be.pxl.examen.rest.resources.DroneResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.stereotype.Service;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DroneService {

	// TODO: provide the requested DAO's to solve the compilation errors
	private static class DroneDao {
		private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("course");
		private final EntityManager em = emf.createEntityManager();

		public List<Drone> findAll() {
			TypedQuery<Drone> query = em.createQuery("SELECT * FROM drone AS drone", Drone.class);
			return query.getResultList();
		}

		public Optional<Drone> findById(Long id) {
			TypedQuery<Drone> query = em.createQuery("SELECT * FROM drone AS drone WHERE drone.id=:id", Drone.class);
			query.setParameter("id", id);
			return new Optional<Drone>(query.getSingleResult());
		}
	}

	private static class DronepilotDao {
		private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("course");
		private final EntityManager em = emf.createEntityManager();

		Dronepilot findByEmail(String email) {
			TypedQuery<Dronepilot> query = em.createQuery("SELECT * FROM d AS d WHERE d.email=:email", Dronepilot.class);
			query.setParameter("email", email);
			return query.getSingleResult();
		}
	}

	private static class DroneflightDao {
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("course");
		private final EntityManager em = emf.createEntityManager();

		Droneflight findByDroneAndDate(Drone drone, LocalDate date) {
			TypedQuery<Droneflight> query = em.createQuery("SELECT * FROM d AS d WHERE d.drone=:drone AND d.date=:date", Droneflight.class);
			query.setParameter("drone", drone);
			query.setParameter("date", date);
			return query.getSingleResult();
		}

		Droneflight save (Droneflight droneflight) {

			return null;
		}

		long count() {
			TypedQuery<Droneflight> query = em.createQuery("SELECT * FROM drone AS drone", Droneflight.class);
			return query.getResultList().size();
		}
	}

	@Autowired
	private final DroneDao droneDao = new DroneDao();
	@Autowired
	private final DronepilotDao dronepilotDao = new DronepilotDao();
	@Autowired
	private final DroneflightDao droneflightDao = new DroneflightDao();

	public List<DroneResource> getDrones() {
		return droneDao.findAll().stream().map(this::mapDroneToDroneResource).collect(Collectors.toList());
	}

	private DroneResource mapDroneToDroneResource(Drone drone) {
		DroneResource droneResource = new DroneResource();
		droneResource.setId(drone.getId());
		droneResource.setCode(drone.getCode());
		droneResource.setWeight(drone.getWeight());
		droneResource.setDescription(drone.getDescription());
		droneResource.setDroneclass(drone.getDroneclass().name());
		return droneResource;
	}

	public void scheduleDroneflight(Long droneId, String pilot, LocalDate date) throws DroneUnavailableException, NotQualifiedException {
		Dronepilot piloot = dronepilotDao.findByEmail(pilot);
		Drone drone = droneDao.findById(droneId).get();

		if (!piloot.allowedToFly(drone)) {
			throw new NotQualifiedException("Dronepilot [" + piloot + "] is not qualified to fly dron [" + drone.getDescription() + "]");
		}
		Droneflight byDroneAndDatum = droneflightDao.findByDroneAndDate(drone, date);
		if (byDroneAndDatum != null) {
			throw new DroneUnavailableException("Drone [" + drone.getDescription() + "] is not availabe at [" + date + "]");
		}

		Droneflight vlucht = new Droneflight(piloot, drone, date);
		droneflightDao.save(vlucht);
	}

	public long countDroneflights() {
		return droneflightDao.count();
	}

}
