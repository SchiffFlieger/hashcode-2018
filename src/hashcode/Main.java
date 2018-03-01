package hashcode;

import static java.lang.Math.abs;

public class Main {
    public static void main (String[] args) {
        System.out.println("hello hashcode");

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
