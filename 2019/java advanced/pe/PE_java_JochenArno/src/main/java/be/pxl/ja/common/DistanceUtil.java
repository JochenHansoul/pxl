package be.pxl.ja.common;

import java.util.Iterator;
import java.util.Set;

public class DistanceUtil {
    // takes a set of alement and another element, finds the closest element to the other element and returns that element
    public static<T extends DistanceFunction<T>> T findClosest(Set<T> elements, T otherElement) {
        Iterator<T> iterator = elements.iterator();
        T shortestElement = iterator.next();
        double shortestDistance = shortestElement.distance(otherElement);
        while (iterator.hasNext()) {
            T element = iterator.next();
            double distance = element.distance(otherElement);
            if (distance < shortestDistance) {
                shortestElement = element;
                shortestDistance = distance;
            }
        }
        return shortestElement;
    }
}
