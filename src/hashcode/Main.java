package hashcode;

import java.io.FileNotFoundException;
import java.util.List;

import static java.lang.Math.abs;

public class Main {

    private static List<Ride> rides;
    private static List<Vehicle> vehicles;

    public static void main (String[] args) throws FileNotFoundException {
        Input input = new Input();
        input.readFile("res/input.in");

        int currentVehicle = 0;
        for (Ride ride : rides) {
            vehicles.get(currentVehicle).addRide(ride);
            currentVehicle = (currentVehicle + 1) % vehicles.size();
        }

        //TODO Output
    }

    public boolean checkIfPossible (int myX, int myY, int fromX, int toX, int fromY, int toY, int currentTime, int earliestStart, int latestFinish) {

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
