package Opgave1.Opgave_g;

import Opgave1.*;

public class TestWorkingPlace {
	public static void main(String[] args) {
		WorkingPlace<Car> carWorkingPlace = new WorkingPlace<>();
		WorkingPlace<Bike> bikeWorkingPlace = new WorkingPlace<>();
		WorkingPlace<Vehicle> vehicleWorkingPlace = new WorkingPlace<>();
		WorkingPlace<CircularSaw> otherWorkPlace = new WorkingPlace<>();
		WorkingPlace<Motorized> motorizedWorkingPlace = new WorkingPlace<>();

		WorkingPlaceUtility.getScore(carWorkingPlace);
		//WorkingPlaceUtility.getScore(bikeWorkingPlace);
		//WorkingPlaceUtility.getScore(vehicleWorkingPlace);
		//WorkingPlaceUtility.getScore(otherWorkPlace);
		//WorkingPlaceUtility.getScore(motorizedWorkingPlace);
	}
}
