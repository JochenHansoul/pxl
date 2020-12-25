package be.pxl.examen.rest;

import be.pxl.examen.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "drones")
public class DroneRest {

	@Autowired
	private DroneService droneService;

	// TODO implement rest endpoints

}
