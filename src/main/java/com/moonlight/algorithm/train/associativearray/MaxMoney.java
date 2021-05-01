package com.moonlight.algorithm.train.associativearray;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 给定数组hard和money，长度都为N
 * hard[i]表示i号的难度， money[i]表示i号工作的收入
 * 给定数组ability，长度都为M，ability[j]表示j号人的能力
 * 每一号工作，都可以提供无数的岗位，难度和收入都一样
 * 但是人的能力必须>=这份工作的难度，才能上班
 * 返回一个长度为M的数组ans，ans[j]表示j号人能获得的最好收入
 *
 *
 * @ClassName MaxMoney
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/1 11:56
 * @Version V1.0
 **/
public class MaxMoney {

    public static int[] maxMoney(int[] hard, int[] money, int[] ability) {
        int n = hard.length;

        List<Job> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Job(hard[i], money[i]));
        }
        list.sort((a, b) -> a.hard == b.hard ? b.money - a.money : a.hard - b.hard);

        Job pre = list.get(0);

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(pre.hard, pre.money);
        treeMap.put(Integer.MIN_VALUE, 0);

        for (int i = 1; i < n; i++) {
            if (pre.hard != list.get(i).hard && pre.money < list.get(i).money) {
                pre = list.get(i);
                treeMap.put(pre.hard, pre.money);
            }
        }

        int[] ans = new int[ability.length];
        for (int i = 0; i < ability.length; i++) {
            ans[i] = treeMap.floorKey(ability[i]);
        }
        return ans;
    }


    static class Job {
        int hard;
        int money;

        public Job(int hard, int money) {
            this.hard = hard;
            this.money = money;
        }

    }

}
