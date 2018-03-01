package hashcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static int rows, cols, nVehicles, nRides, bonus, steps;

    private static List<Ride> rides;
    private static List<Vehicle> vehicles;

    public static void main (String[] args) throws FileNotFoundException {
        final File[] files = new File("res").listFiles();
        for (File file : files) {
            Input.read(file);

            rides.sort(Comparator.comparingInt(Ride::getEarliestStart));
            ridesLoop:
            while (!rides.isEmpty()) {
                for (Vehicle vehicle : vehicles) {
                    final Ride ride = vehicle.getBestPossibleRide(rides);
                    if (ride == null) {
                        break ridesLoop;
                    }
                    vehicle.addRide(ride);
                    rides.remove(ride);
                }
            }

            Output.writeOutput(vehicles, "out/" + file.getName().substring(0, 1) + ".out");

            System.out.println(file.getName());
            System.out.println("Vehicles: " + nVehicles);
            System.out.println("Rides:    " + nRides);
            System.out.println("Rides not taken: " + rides.size());
        }
    }

    public static void setRides (ArrayList<Ride> rides) {
        Main.rides = rides;
    }

    public static void setVehicles (List<Vehicle> vehicles) {
        Main.vehicles = vehicles;
    }

    public static int getRows () {
        return rows;
    }

    public static void setRows (int rows) {
        Main.rows = rows;
    }

    public static int getCols () {
        return cols;
    }

    public static void setCols (int cols) {
        Main.cols = cols;
    }

    public static int getnVehicles () {
        return nVehicles;
    }

    public static void setnVehicles (int nVehicles) {
        Main.nVehicles = nVehicles;
    }

    public static int getnRides () {
        return nRides;
    }

    public static void setnRides (int nRides) {
        Main.nRides = nRides;
    }

    public static int getBonus () {
        return bonus;
    }

    public static void setBonus (int bonus) {
        Main.bonus = bonus;
    }

    public static int getSteps () {
        return steps;
    }

    public static void setSteps (int steps) {
        Main.steps = steps;
    }

    public static List<Ride> getRides () {
        return rides;
    }
}
