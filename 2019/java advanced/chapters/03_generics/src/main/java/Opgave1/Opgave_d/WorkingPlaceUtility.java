package Opgave1.Opgave_d;

import Opgave1.Bike;

public class WorkingPlaceUtility {
	public static int getScore(WorkingPlace<? extends Bike> workingPlace) {
		return workingPlace.getNumberOfThingsFixed();
	}
}
