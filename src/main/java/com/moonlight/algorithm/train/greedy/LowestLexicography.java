package com.moonlight.algorithm.train.greedy;

import java.util.Arrays;

/**
 * 给定一个由字符串组成的数组
 * 必须把所有的字符串拼接起来
 * 返回所有拼接结果中字典序最小的结果
 * @ClassName LowestLexicography
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/2 12:04
 * @Version V1.0
 **/
public class LowestLexicography {

    public static void main(String[] args) {
        String[] arr = {"ab", "bc", "zb", "sk", "c"};
        System.out.println(lowestString(arr));
    }

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 按相加的字典序ASC排序
        Arrays.sort(strs, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

}
