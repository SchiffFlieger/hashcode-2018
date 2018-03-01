package hashcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by nilsw
 */
public class Input {

    public static void read (File f) throws FileNotFoundException {
        final Scanner scanner = new Scanner(f);

        int nRides, nVehicles;
        Main.setRows(scanner.nextInt());
        Main.setCols(scanner.nextInt());
        nRides = scanner.nextInt();
        nVehicles = scanner.nextInt();

        Main.setnVehicles(nVehicles);
        Main.setnRides(nRides);
        Main.setBonus(scanner.nextInt());
        Main.setSteps(scanner.nextInt());

        final ArrayList<Ride> rides = new ArrayList<>(nRides);
        for (int i = 0; i < nRides; i++) {
            final Intersection start = new Intersection(scanner.nextInt(), scanner.nextInt());
            final Intersection finish = new Intersection(scanner.nextInt(), scanner.nextInt());
            final Ride ride = new Ride(i, start, finish, scanner.nextInt(), scanner.nextInt());
            rides.add(ride);
        }
        Main.setRides(rides);

        final ArrayList<Vehicle> vehicles = new ArrayList<>(nVehicles);
        for (int i = 0; i < nVehicles; i++) {
            vehicles.add(new Vehicle(i));
        }
        Main.setVehicles(vehicles);
    }
}
