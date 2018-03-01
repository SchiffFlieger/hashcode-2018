package hashcode;

import java.io.*;
import java.util.Comparator;
import java.util.List;

public class Output {

    public static void writeOutput (List<Vehicle> vehicles, String filename) {
        Comparator<Integer> natural = Comparator.naturalOrder();

        vehicles.sort((o1, o2) -> natural.compare(o1.getId(), o2.getId()));

        try {
            File fout = new File(filename);
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (Vehicle car : vehicles) {
                bw.write(car.getNumberOfRides() + " ");
                for (int i = 0; i < car.getNumberOfRides(); i++) {
                    bw.write(car.getRide(i).getId() + " ");
                }
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
