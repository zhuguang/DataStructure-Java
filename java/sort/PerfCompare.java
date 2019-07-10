package sort;

import com.sun.deploy.util.StringUtils;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import performance.StopWatch;

import java.util.Random;

/**
 * javac -Xlint:unchecked -cp ../otherlib/algs4.jar:. sort/PerfCompare.java
 * java -cp ../otherlib/algs4.jar:. sort.PerfCompare selection insertion 1 10
 */
public class PerfCompare {

    private static Random random = new Random();

    public static long perf(String alg, Comparable[] arr) {
        SortExample sort = new SelectSort();
        StopWatch watch = new StopWatch();
        if ("selection".equals(alg)) {
            sort = new SelectSort();
        }
        if ("insertion".equals(alg)) {
            sort = new InsertSort();
        }
        sort.sort(arr);
//        sort.show(arr);
        return watch.elapsedMillisTime();
    }

    public static long[] time(String alg1, String alg2, int T, int N, Integer[] arr) {
        long elapsedTime1 = 0;
        long elapsedTime2 = 0;
        for (int a = 0; a < T; a++) {
            if (arr == null || arr.length < 1) {
                arr = random(N);
            }
            elapsedTime1 += perf(alg1, arr);
            elapsedTime2 += perf(alg2, arr);
        }
        long[] elaArr = new long[2];
        elaArr[0] = elapsedTime1;
        elaArr[1] = elapsedTime2;
        return elaArr;
    }

    private static Integer[] random(int N) {
        Integer[] d = new Integer[N];
        for (int b = 0; b < N; b++) {
            d[b] = random.nextInt();
        }
        return d;
    }


    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        String file = args[2];
        String T = args[3];
        String N = args[4];
        Integer[] ints = null;
        if ("true".equals(file)) {
            int[] input = new In().readAllInts();
            ints = new Integer[input.length];
            for (int idx = 0; idx < input.length; idx++) {
                ints[idx] = input[idx];
            }
        }
        long[] times = PerfCompare.time(alg1, alg2, Integer.valueOf(T), Integer.valueOf(N), ints);
        if (times[0] < 1 || times[1] < 1) {
            StdOut.println("Exception: time " + times[0] + "," + times[1]);
            return;
        }
        System.out.println(alg1 + "执行时间" + times[0] + "," + alg2 + "执行时间：" + times[1]);
        System.out.println(alg1 + "执行时间是" + alg2 + "的" + times[0] / times[1] + "倍");
    }
}
