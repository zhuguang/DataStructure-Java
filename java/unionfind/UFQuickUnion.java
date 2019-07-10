package unionfind;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

/**
 * javac -cp ../otherlib/algs4.jar:. unionfind/UFQuickUnion.java
 * java -cp ../otherlib/algs4.jar:. unionfind.UFQuickUnion unionfind.UFQuickUnion Xlint:unchecked <../data/tinyUF.txt
 */
public class UFQuickUnion extends UF {
    public UFQuickUnion(int N) {
        super(N);
    }

    public int find(int p) {
//        递归
       /* int pVal = id[p];
        if (pVal == p) {
            return p;
        }
        return find(pVal);*/
//        while() 循环
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        StdOut.printf("ufquickunion union");
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        count--;
        return;
    }


}
