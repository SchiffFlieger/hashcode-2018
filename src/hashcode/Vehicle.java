package hashcode;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private final List<Ride> rides;

    public Vehicle () {
        rides = new ArrayList<Ride>();
    }

    public boolean addRide (Ride ride) {
        return rides.add(ride);
    }

    public Ride getRide (int index) {
        return rides.get(index);
    }
}
