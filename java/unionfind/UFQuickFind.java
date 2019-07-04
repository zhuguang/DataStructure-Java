package unionfind;

import java.util.Scanner;

/**
 * 在命令行执行的时候，要在上一级目录 java/，执行：
 * javac unionfind/UFQuickUnion.java
 * java unionfind/UFQuickUnion < ../data/tinyUF.txt
 * 这样才符合类上面声明的包路径 package unionfind;
 * 如果在当前路径执行，需要把类上面的 package unionfind; 去掉
 */
public class UFQuickFind extends UF {

    public UFQuickFind(int N) {
        super(N);
    }
    //    查找分量标识符
    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
//        找p和q各自所属分量
        int pGroup = find(p);
        int qGroup = find(q);
        if (pGroup == qGroup) {
            return;
        }
//        遍历所有元素，把与q同一个分量的元素放到p所属的分量
        for (int t = 0; t < id.length; t++) {
            if (id[t] == qGroup) {
                id[t] = pGroup;
            }
        }
        count--;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        UFQuickFind qf = new UFQuickFind(count);
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
