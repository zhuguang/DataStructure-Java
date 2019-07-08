package performance;

public class StopWatch {
    private long start;

    public StopWatch() {
        start = System.currentTimeMillis();
    }

    public long elapsedMillisTime() {
        return System.currentTimeMillis() - start;
    }
}
