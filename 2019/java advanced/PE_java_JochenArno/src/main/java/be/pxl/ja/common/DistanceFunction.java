package be.pxl.ja.common;

import be.pxl.ja.city.City;

@FunctionalInterface
public interface DistanceFunction<T> {
    double distance(T e);
}
