package Opgave1.Opgave_f;


import Opgave1.Motorized;

public class WorkingPlaceUtility {
	public static int getScore(WorkingPlace<? extends Motorized> workingPlace) {
		return workingPlace.getNumberOfThingsFixed();
	}
}
