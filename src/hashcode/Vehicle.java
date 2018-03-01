package hashcode;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

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

    public boolean checkIfPossible (int myX, int myY, Ride ride, int currentTime) {
        int fromX = ride.getStartIntersection().getX();
        int fromY = ride.getStartIntersection().getY();
        int toX = ride.getEndIntersection().getX();
        int toY = ride.getEndIntersection().getY();
        int earliestStart = ride.getEarliestStart();
        int latestFinish = ride.getLatestFinish();

        if (abs(fromX - toX) + abs(fromY - toY) <= latestFinish - earliestStart) {
            // Possible at all
            if (abs(myX - fromX) + abs(myY - fromY) + abs(fromX - toX) + abs(fromY - toY) <= (latestFinish - currentTime)) {
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
