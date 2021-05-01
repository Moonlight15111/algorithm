package com.moonlight.algorithm.train.other;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/employee-importance/
 *
 * 给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度 和 直系下属的 id 。
 * 比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。
 * 那么员工 1 的数据结构是 [1, 15, [2]] ，员工 2的 数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。
 * 注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。
 * 现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。
 *
 * 输入：[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1   输出：11
 * 解释：员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 11 。
 *
 * @ClassName EmployeeImportance
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/1 10:46
 * @Version V1.0
 **/
public class EmployeeImportance {

    public static void main(String[] args) {
        Employee a = new Employee(2, 3, null);
        Employee b = new Employee(3, 3, null);
        List<Integer> ids = new ArrayList<>();
        ids.add(a.id);
        ids.add(b.id);
        Employee root = new Employee(1, 5, ids);
        List<Employee> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(root);
        System.out.println(map(list, 1));
    }

    public static int recursion(List<Employee> employees, int id) {
        Employee e = null;
        for (Employee employee : employees) {
            if (employee.id == id) {
                e = employee;
                break;
            }
        }

        if (e == null) {
            return 0;
        }
        int ans = e.importance;
        for (int sub : e.subordinates) {
            ans += recursion(employees, sub);
        }
        return ans;
    }

    public static int map(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        int ans = map.get(id).importance;
        Stack<Integer> sub = new Stack<>();
        if (map.get(id).subordinates != null) {
            sub.addAll(map.get(id).subordinates);
        }
        Employee employee;
        while (!sub.isEmpty()) {
            employee = map.get(sub.pop());
            ans += employee.importance;
            if (employee.subordinates != null) {
                sub.addAll(employee.subordinates);
            }
        }
        return ans;
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }

}
