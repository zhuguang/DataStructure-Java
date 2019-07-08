package unionfind;

import java.util.Scanner;

//抽象类中只声明非空构造函数，子类必须显示声明非空构造方法。如果子类没有声明构造方法，默认调用父类空构造方法
public abstract class UF {
    //    分量 触点作为索引
    protected int[] id;
    //    分量数量
    protected int count;

    //    初始化
    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    //    查找分量标识符
    abstract int find(int p);

    //    两个触点是否连接，也就是是否在同一个分量
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    //    连接两个触点
    abstract void union(int p, int q);

    public int count() {
        return count;
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