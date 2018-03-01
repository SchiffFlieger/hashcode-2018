package hashcode;

public class Ride {
    private final Intersection startIntersection;
    private final Intersection endIntersection;
    private final int earliestStart;
    private final int latestFinish;

    public Ride (Intersection startIntersection, Intersection endIntersection, int earliestStart, int latestFinish) {
        this.startIntersection = startIntersection;
        this.endIntersection = endIntersection;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
    }

    public Intersection getStartIntersection () {
        return startIntersection;
    }

    public Intersection getEndIntersection () {
        return endIntersection;
    }

    public int getEarliestStart () {
        return earliestStart;
    }

    public int getLatestFinish () {
        return latestFinish;
    }
}
