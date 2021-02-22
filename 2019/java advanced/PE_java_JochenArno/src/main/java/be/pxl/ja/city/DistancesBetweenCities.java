package be.pxl.ja.city;

import be.pxl.ja.common.DistanceFunction;
import be.pxl.ja.common.DistanceUtil;

import java.util.SortedSet;
import java.util.TreeSet;

public class DistancesBetweenCities {

	public static void main(String[] args) {
		City leuven = new City("Leuven", 50.88151970000001, 4.6967578);
		City roermond = new City("Roermond", 51.19417, 5.9875);
		City maastricht = new City("Maastricht", 50.84833, 5.68889);
		City aken = new City("Aken", 50.77664, 6.08342);

		SortedSet<City> cities = new TreeSet<>();
		cities.add(leuven);
		cities.add(roermond);
		cities.add(maastricht);
		cities.add(aken);

		// alle steden afdrukken
		for (City city : cities) {
			System.out.println(city.toString());
		}

		// eigen gemeente
		City wellen = new City("Wellen", 50.8404, 5.33835); //actually a town
		System.out.println("The closest city to " + wellen.toString() + " is: " + DistanceUtil.findClosest(cities, wellen).toString());

	}

}
