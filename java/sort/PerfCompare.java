package sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import performance.StopWatch;

import java.util.Random;

/**
 * javac -Xlint:unchecked -cp ../otherlib/algs4.jar:. sort/PerfCompare.java
 * java -cp ../otherlib/algs4.jar:. sort.PerfCompare selection insertion 1 10
 */
public class PerfCompare {

    public static <T> long perf(String alg, Comparable<T>[] arr) {
        SortExample<T> sort = new SelectSort<T>();
        StopWatch watch = new StopWatch();
        if ("selection".equals(alg)) {
            sort = new SelectSort<T>();
        }
        if ("insertion".equals(alg)) {
            sort = new InsertSort<T>();
        }
        sort.sort(arr);
        sort.show(arr);
        return watch.elapsedMillisTime();
    }

    public static long[] time(String alg1, String alg2, int T, int N) {
        long elapsedTime1 = 0;
        long elapsedTime2 = 0;
        for (int a = 0; a < T; a++) {
            Double[] d = new Double[N];
            for (int b = 0; b < N; b++) {
                d[b] = StdRandom.uniform();
            }
            elapsedTime1 += perf(alg1, d);
            elapsedTime2 += perf(alg2, d);
        }
        long[] elaArr = new long[2];
        elaArr[0] = elapsedTime1;
        elaArr[1] = elapsedTime2;
        return elaArr;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        String T = args[2];
        String N = args[3];
        long[] times = PerfCompare.time(alg1, alg2, Integer.valueOf(T), Integer.valueOf(N));
        if (times[0] < 1 || times[1] < 1) {
            StdOut.println("Exception: time " + times[0] + "," + times[1]);
            return;
        }
        System.out.println(alg1 + "执行时间" + times[0]);
        System.out.println(alg1 + "执行时间是" + alg2 + "的" + times[0] / times[1] + "倍");
    }
}
