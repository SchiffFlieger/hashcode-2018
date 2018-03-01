package hashcode;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    static int rows, cols, nVehicles, nRides, bonus, steps;
    static ArrayList<Ride> rides;

    public static void main (String[] args) throws FileNotFoundException {
        Input.read("res/a.in");

        System.out.println(nRides);
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

    public static ArrayList<Ride> getRides () {
        return rides;
    }

    public static void setRides (ArrayList<Ride> rides) {
        Main.rides = rides;
    }
}
