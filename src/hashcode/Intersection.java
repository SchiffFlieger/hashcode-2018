package hashcode;

import static java.lang.Math.abs;

public class Intersection {
    private final int x;
    private final int y;

    public Intersection (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distance (Intersection other) {
        return abs(x - other.getX()) + abs(y - other.getY());
    }

    public int getX () {
        return x;
    }

    public int getY () {
        return y;
    }
}

