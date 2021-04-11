package com.moonlight.algorithm.train.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 *
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 输入: [10,2]   输出: "102"
 *
 * 输入: [3,30,34,5,9]  输出: "3033459"
 *
 * @ClassName MinNumber
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/11 16:42
 * @Version V1.0
 **/
public class MinNumber {

    public static void main(String[] args) {
        int[] a = {10, 2}, b = {3, 30, 34, 5, 9};
        System.out.println(minNumber(a));
        System.out.println(minNumber(b));
    }

    public static String minNumber(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            // 字典序列小的放在堆顶
            return (o1 + o2).compareTo(o2 + o1);
        });
        for (int num : nums) {
            queue.add("" + num);
        }
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()){
            res.append(queue.poll());
        }
        return res.toString();
    }

}
