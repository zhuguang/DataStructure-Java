package unionfind;

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

}