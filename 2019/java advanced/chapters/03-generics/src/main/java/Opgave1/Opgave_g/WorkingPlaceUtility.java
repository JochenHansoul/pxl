package Opgave1.Opgave_g;


import Opgave1.Car;
import Opgave1.Motorized;
import Opgave1.Vehicle;

public class WorkingPlaceUtility {
	public static int getScore(WorkingPlace<? extends Car> workingPlace) {
		return workingPlace.getNumberOfThingsFixed();
	}
}
