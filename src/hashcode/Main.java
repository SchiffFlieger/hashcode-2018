package hashcode;

import java.io.FileNotFoundException;

public class Main {
    public static void main (String[] args) throws FileNotFoundException {
        Input input = new Input();
        input.readFile("res/input.in");
        System.out.println("hello hashcode");
    }
}
