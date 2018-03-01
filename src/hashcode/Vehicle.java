package hashcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        currentTime += getStepsToEnd(ride);
        position = ride.getEndIntersection();
    }

    public Ride getRide (int index) {
        return rides.get(index);
    }

    public String outputString () {
        StringBuilder builder = new StringBuilder();
        builder.append(this.rides.size()).append(" ");
        for (Ride ride : this.rides) {
            builder.append(ride.getId()).append(" ");
        }
        return builder.toString();
    }

    public Ride getBestPossibleRide (List<Ride> rides) {
        final List<Ride> possibles = new ArrayList<>();
        for (Ride ride : rides) {
            if (checkIfPossible(ride)) {
                possibles.add(ride);
            }
        }
        final List<Ride> list = possibles.stream().sorted(Comparator.comparingInt(this::getDelta)).collect(Collectors.toList());
        return list.stream()
                .filter(e -> Math.abs(e.getEarliestStart() - currentTime) >= position.distance(e.getStartIntersection()))
                .findFirst().orElse(getNearestRide(possibles));
    }

    private Ride getNearestRide (List<Ride> rides) {
        Ride min = null;
        for (Ride ride : rides) {
            if (getDelta(ride) < getDelta(min)) {
                min = ride;
            }
        }
        return min;
    }

    private int getDelta (Ride ride) {
        if (ride == null) {
            return Integer.MAX_VALUE;
        }
        final int dDistance = position.distance(ride.getStartIntersection());
        final int dTime = Math.abs(ride.getEarliestStart() - currentTime);
        return dDistance + dTime;
    }

    private Ride getBonusRide (List<Ride> rides) {
        Ride min = null;
        for (Ride ride : rides) {
            if (getBonusDelta(ride) < getBonusDelta(min)) {
                min = ride;
            }
        }
        return min;
    }

    private int getBonusDelta (Ride ride) {
        if (ride == null) {
            return Integer.MAX_VALUE;
        }
        final int dDistance = position.distance(ride.getStartIntersection());
        final int dTime = Math.abs(ride.getEarliestStart() - currentTime);
        return dDistance + dTime;
    }

    private int getStepsToEnd (Ride ride) {
        return position.distance(ride.getStartIntersection()) + ride.getStartIntersection().distance(ride.getEndIntersection());
    }

    public boolean checkIfPossible (Ride ride) {
        int earliestStart = ride.getEarliestStart();
        int latestFinish = ride.getLatestFinish();

        // Possible at all
        if (ride.getStartIntersection().distance(ride.getEndIntersection()) <= latestFinish - earliestStart) {
            //Possible from current position
            return getStepsToEnd(ride) <= (latestFinish - currentTime);
        } else {
            return false;
        }
    }
}
