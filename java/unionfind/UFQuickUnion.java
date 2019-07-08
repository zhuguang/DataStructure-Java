package unionfind;

import java.util.Scanner;

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
