package com.moonlight.algorithm.train.bitManipulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/bitwise-ors-of-subarrays/
 * 对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），
 * 我们对 B 中的每个元素进行按位或操作，获得结果 A[i] | A[i+1] | ... | A[j]。
 * 返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）
 * 输入：[0]
 * 输出：1
 * 解释：只有一个可能的结果 0 。
 * 输入：[1,1,2]
 * 输出：3
 * 解释：
 * 可能的子数组为 [1]，[1]，[2]，[1, 1]，[1, 2]，[1, 1, 2]。
 * 产生的结果为 1，1，2，1，3，3 。
 * 有三个唯一值，所以答案是 3 。
 * @author Moonlight
 * @date 2020/12/16 9:40
 */

public class SubArrayBitwiseORs {

    public static void main(String[] args) {
        int[] test1 = {0};
        int[] test2 = {1, 1, 2};
        int[] test3 = {1, 2, 4};
        int[] test4 = {13, 4, 2};

        System.out.println(subArrayBitwiseORs(test1));
        System.out.println(subArrayBitwiseORs(test2));
        System.out.println(subArrayBitwiseORs(test3));
        System.out.println(subArrayBitwiseORs(test4));
    }

    public static int subArrayBitwiseORs(int[] arrs) {
        if (arrs == null) {
            return 0;
        }
        if (arrs.length == 1) {
            return 1;
        }
        Set<Integer> res = new HashSet<>();
        for (int i : arrs) {
            res.add(i);
        }
        // 从后往前看，进行 | 运算，并将 | 运算的结果放到前面的位置上，表示已经进行过计算了
        for (int i = 0, length = arrs.length; i < length; i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                if ((arrs[j] | arrs[i]) == arrs[j]) {
                    break;
                }
                arrs[j] |= arrs[i];
                res.add(arrs[j]);
            }
        }
        System.out.println(Arrays.toString(res.toArray()));
        return res.size();
    }

}
