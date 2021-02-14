package Opgave1.Opgave_e;


import Opgave1.Vehicle;

public class WorkingPlaceUtility {
	public static int getScore(WorkingPlace<? extends Vehicle> workingPlace) {
		return workingPlace.getNumberOfThingsFixed();
	}
}
