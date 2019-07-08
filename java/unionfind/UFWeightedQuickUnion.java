package unionfind;

import java.util.Scanner;

public class UFWeightedQuickUnion extends UF {

    protected int[] height;

    public UFWeightedQuickUnion(int N) {
        super(N);
        height = new int[N];
        for (int i = 0; i < N; i++) {
            height[i] = i;
        }
    }

    @Override
    int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        int pH = height[pRoot];
        int qH = height[qRoot];
        if (pH > qH) {
            id[qRoot] = pRoot;
            height[pRoot]++;
        } else {
            id[pRoot] = qRoot;
            height[qRoot]++;
        }
        count--;
        return;
    }

}
