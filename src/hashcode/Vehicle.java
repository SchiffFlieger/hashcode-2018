package hashcode;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private final int id;
    private final List<Ride> rides;
    private Intersection position;
    private int currentTime;

    public Vehicle (int id) {
        this.id = id;
        rides = new ArrayList<>();
        position = new Intersection(0, 0);
    }

    public int getId () {
        return id;
    }

    public int getNumberOfRides () {
        return rides.size();
    }

    public void addRide (Ride ride) {
        rides.add(ride);
        currentTime += position.distance(ride.getStartIntersection()) + ride.getStartIntersection().distance(ride.getEndIntersection());
        position = ride.getEndIntersection();
    }

    public Ride getRide (int index) {
        return rides.get(index);
    }

    public boolean checkIfPossible (Ride ride) {
        int myX = position.getX();
        int myY = position.getY();
        int fromX = ride.getStartIntersection().getX();
        int fromY = ride.getStartIntersection().getY();
        int toX = ride.getEndIntersection().getX();
        int toY = ride.getEndIntersection().getY();
        int earliestStart = ride.getEarliestStart();
        int latestFinish = ride.getLatestFinish();

        if (ride.getStartIntersection().distance(ride.getEndIntersection()) <= latestFinish - earliestStart) {
            // Possible at all
            if (position.distance(ride.getStartIntersection()) + ride.getStartIntersection().distance(ride.getEndIntersection()) <= (latestFinish - currentTime)) {
                //Possible from current position
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
