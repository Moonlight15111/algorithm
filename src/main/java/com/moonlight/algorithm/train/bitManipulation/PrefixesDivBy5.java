package com.moonlight.algorithm.train.bitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false
 *
 * 输入：[0,1,1]  输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 *
 * 输入：[1,1,1]     输出：[false,false,false]
 *
 * 输入：[0,1,1,1,1,1]     输出：[true,false,false,false,true,false]
 *
 * @author Moonlight
 * @date 2021/1/14 15:16
 */
public class PrefixesDivBy5 {

    public static void main(String[] args) {
//        for (Boolean b : prefixesDivBy5(new int[]{1, 1, 1, 0, 1})) {
//            System.out.print(b + ",");
//        }
        System.out.println();
        for (Boolean b : prefixesDivBy5(new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1})) {
            System.out.print(b + ",");
        }
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        if (A == null || A.length == 0) {
            return new ArrayList<>();
        }
        List<Boolean> res = new ArrayList<>();
        long tmp = 0;
        for (int aA : A) {
            tmp = ((tmp << 1) + aA) % 5;
            res.add(tmp == 0);
        }
        return res;
    }

}
