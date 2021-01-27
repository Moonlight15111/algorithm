package com.moonlight.algorithm.train.other;

import java.util.*;
/**
 * 每个理财产品的理财天数/年化收益率用<key, val>形式存储。所有的信息都放在一个List<Map<Int, Double>>中
 * 请根据理财天数分区间统计每个区间的最高收益率。区间有4个: [1, 30]  [31, 90]  [91, 180]  [181, 365]
 * @ClassName Test
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/27 23:37
 * @Version V1.0
 **/
public class Test {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(test(buildData())));
    }

    public static double[] test(List<Map<Integer, Double>> data) {
        double first = 0, second = 0, third = 0, fourth = 0;
        for (Map<Integer, Double> m : data) {
            for (Integer key : m.keySet()) {
                if (key < 31) {
                    first = Math.max(first, m.get(key));
                }
                if (key < 91) {
                    second = Math.max(second, m.get(key));
                }
                if (key < 181) {
                    third = Math.max(third, m.get(key));
                }
                if (key < 366) {
                    fourth = Math.max(fourth, m.get(key));
                }
            }
        }
        return new double[]{first, second, third, fourth};
    }

    public static List<Map<Integer, Double>> buildData() {
        List<Map<Integer, Double>> res = new ArrayList<>();

        Map<Integer, Double> m1 = new HashMap<>();
        m1.put(7, 0.03);
        res.add(m1);

        Map<Integer, Double> m2 = new HashMap<>();
        m2.put(15, 0.05);
        res.add(m2);

        Map<Integer, Double> m3 = new HashMap<>();
        m3.put(7, 0.08);
        res.add(m3);

        Map<Integer, Double> m4 = new HashMap<>();
        m4.put(30, 0.05);
        res.add(m4);

        Map<Integer, Double> m5 = new HashMap<>();
        m5.put(60, 0.1);
        res.add(m5);

        Map<Integer, Double> m6 = new HashMap<>();
        m6.put(30, 0.08);
        res.add(m6);

        Map<Integer, Double> m7 = new HashMap<>();
        m7.put(60, 0.02);
        res.add(m7);

        Map<Integer, Double> m8 = new HashMap<>();
        m8.put(90, 0.05);
        res.add(m8);

        Map<Integer, Double> m9 = new HashMap<>();
        m9.put(90, 0.07);
        res.add(m9);

        Map<Integer, Double> m10 = new HashMap<>();
        m10.put(120, 0.08);
        res.add(m10);

        Map<Integer, Double> m11 = new HashMap<>();
        m11.put(120, 0.09);
        res.add(m11);

        Map<Integer, Double> m12 = new HashMap<>();
        m12.put(180, 0.1);
        res.add(m12);

        Map<Integer, Double> m13 = new HashMap<>();
        m13.put(200, 0.1);
        res.add(m13);

        Map<Integer, Double> m14 = new HashMap<>();
        m14.put(365, 0.15);
        res.add(m14);

        return res;
    }

}
