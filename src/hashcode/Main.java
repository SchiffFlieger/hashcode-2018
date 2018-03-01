package hashcode;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    private static List<Ride> rides;
    private static List<Vehicle> vehicles;

    public static void main (String[] args) throws FileNotFoundException {
        Input input = new Input();
        input.readFile("res/a.in");

        int currentVehicle = 0;
        for (Ride ride : rides) {
            vehicles.get(currentVehicle).addRide(ride);
            currentVehicle = (currentVehicle + 1) % vehicles.size();
        }

        Output.writeOutput(vehicles);
    }
}
