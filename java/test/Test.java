package test;

import list.implement.ListArray;

public class Test {
        String name;
        int age;

        public Test(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public static void main(String[] args) throws Exception {
            ListArray<Test> la = new ListArray<>();
            for (int a = 0; a < 10; a++) {
                la.add(new Test("haha", a));
            }
            System.out.print("maindemo");
            la.remove(1);

            System.out.println(la.toString());
            la.modify(3, new Test("update", 3));
            System.out.println(la.toString());
            ListArray slice = la.slice(1, 9);
            System.out.println(la.toString());
            System.out.println(slice.toString());


        }

        @Override
        public String toString() {
            return "Test{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
