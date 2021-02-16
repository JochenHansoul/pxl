package Opgave2;

public class Elephant implements Movable<Location> {
    Location location;

    @Override
    public void move(Location location) {
        this.location = location;
    }

    @Override
    public Location getLocation() {
        return this.location;
    }
}
