package com.moonlight.algorithm.train.search;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/destination-city/
 *
 * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。
 * 请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
 * 题目数据保证线路图会形成一条不存在循环的线路，因此恰有一个旅行终点站。
 *
 * 输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]  输出："Sao Paulo"
 * 解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
 *
 * 输入：paths = [["B","C"],["D","B"],["C","A"]]  输出："A"
 * 解释：所有可能的线路是：
 * "D" -> "B" -> "C" -> "A". 
 * "B" -> "C" -> "A". 
 * "C" -> "A". 
 * "A". 
 * 显然，旅行终点站是 "A" 。
 *
 * 输入：paths = [["A","Z"]]  输出："Z"
 *
 * @ClassName DestCity
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/1 14:05
 * @Version V1.0
 **/
public class DestCity {

    public static void main(String[] args) {
        List<String> a = new ArrayList<>(), b = new ArrayList<>(), c = new ArrayList<>();
        a.add("B"); a.add("C"); b.add("D"); b.add("B"); c.add("C"); c.add("A");

        List<List<String>> d = new ArrayList<>();
        d.add(a); d.add(b); d.add(c);

        System.out.println(destCity(d));
    }

    public static String destCity(List<List<String>> paths) {
        Map<String, String> m = new HashMap<>();
        for (List<String> list : paths) {
            m.put(list.get(0), list.get(1));
        }
        for (String val : m.values()) {
            if (!m.containsKey(val)) {
                return val;
            }
        }
        return null;
    }

}
