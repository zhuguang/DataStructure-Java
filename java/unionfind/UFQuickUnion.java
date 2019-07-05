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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        long start = System.currentTimeMillis();
        UFQuickUnion qf = new UFQuickUnion(count);
        while (scanner.hasNextInt()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
//            判断是否连接
            if (qf.connected(p, q)) {
                System.out.println(p + "和" + q + "已连接");
                continue;
            }
//            如果没连接，则归并分量
            qf.union(p, q);
//            打印连接
            System.out.println(p + " " + q);
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.println(qf.count() + " components" + ", elapsed(ms):" + elapsed);
    }
}
