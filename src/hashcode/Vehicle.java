package hashcode;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private final int id;
    private final List<Ride> rides;

    public Vehicle (int id) {
        this.id = id;
        rides = new ArrayList<Ride>();
    }

    public int getId () {
        return id;
    }

    public int getNumberOfRides () {
        return rides.size();
    }

    public boolean addRide (Ride ride) {
        return rides.add(ride);
    }

    public Ride getRide (int index) {
        return rides.get(index);
    }
}
