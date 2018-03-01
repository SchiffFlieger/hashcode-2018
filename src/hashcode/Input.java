package hashcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input {
    public void readFile(String filename) throws FileNotFoundException {
        File f = new File(filename);
        Scanner scanner = new Scanner(f);
    }
}
