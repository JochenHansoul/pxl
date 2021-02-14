package Opgave2;

public interface Movable<T> {
    void move(T location);

    T getLocation();
}