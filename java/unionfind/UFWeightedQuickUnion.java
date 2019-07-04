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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
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
        System.out.println(qf.count() + " components");
    }
}
