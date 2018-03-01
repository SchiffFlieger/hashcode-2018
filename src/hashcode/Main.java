package hashcode;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int rows, cols, nVehicles, nRides, bonus, steps;

    private static List<Ride> rides;
    private static List<Vehicle> vehicles;

    public static void main (String[] args) throws FileNotFoundException {
        String filename = "b";
        Input.read("res/" + filename + "" + ".in");

        int currentVehicle = 0;
        for (Ride ride : rides) {
            vehicles.get(currentVehicle).addRide(ride);
            currentVehicle = (currentVehicle + 1) % vehicles.size();
        }

        Output.writeOutput(vehicles, "out/" + filename + ".out");

        System.out.println(nRides);
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
