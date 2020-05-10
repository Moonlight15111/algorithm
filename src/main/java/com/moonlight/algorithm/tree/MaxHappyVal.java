package com.moonlight.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MaxHappyVal
 * @Description: 一颗标准的无环多叉树，每个员工只有一个直接下级。
 *                开派对时，你可以决定哪些员工来，哪些员工不来，如果某个员工来了，那么他
 *                的直接下级都不能来，派对的整体快乐值是所有在场员工快乐值的累加，目标是让派对的整体快乐值
 *                尽量大。
 *                还是分为两类情况讨论：
 *                一。让root节点参加：此时就需要讨论当root节点参加时，它所有直接下属不来参加，整棵树的最大快乐值
 *                二。不让root节点参加: 此时需要讨论它直接下属来和不来时整体快乐值哪个大
 * @Author Moonlight
 * @Date 2020/5/9 22:45
 * @Version V1.0
 **/
public class MaxHappyVal {

    public static void main (String[] args) {
        Employee root = new Employee(1);
        Employee e1 = new Employee(2);
        Employee e2 = new Employee(3);
        Employee e3 = new Employee(4);
        Employee e4 = new Employee(5);
        Employee e5 = new Employee(6);
        Employee e6 = new Employee(7);
        Employee e7 = new Employee(8);

        root.subordinates.add(e1);
        root.subordinates.add(e2);
        root.subordinates.add(e3);

        e1.subordinates.add(e4);
        e1.subordinates.add(e5);

        e2.subordinates.add(e6);
        e6.subordinates.add(e7);

        System.out.println(maxHappy(root));
    }

    public static int maxHappy(Employee root){
        if (root == null) {
            return 0;
        }
        Info info = findMaxHappy(root);
        return Math.max(info.rootComing, info.rootNotComing);
    }

    public static Info findMaxHappy(Employee root){
        if (root.subordinates.isEmpty()) {
            return new Info(root.happyVal, 0);
        }

        int rootComing = root.happyVal, rootNotComing = 0;
        for (Employee employee : root.subordinates) {
            Info subInfo = findMaxHappy(employee);
            rootComing += subInfo.rootNotComing;
            rootNotComing += Math.max(subInfo.rootComing, subInfo.rootNotComing);
        }
        return new Info(rootComing, rootNotComing);
    }


    static class Info {
        public int rootComing;
        public int rootNotComing;

        public Info (int rootComing, int rootNotComing) {
            this.rootComing = rootComing;
            this.rootNotComing = rootNotComing;
        }
    }

    static class Employee{
        // 快乐值
        public int happyVal;
        // 直接下级
        public List<Employee> subordinates;

        public Employee (int happyVal) {
            this.happyVal = happyVal;
            subordinates = new ArrayList<>();
        }
    }
}
