package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.HashMap;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/count-good-meals/
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。你可以搭配 任意 两道餐品做一顿大餐。
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，
 * 返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 *
 * 1 <= deliciousness.length <= 105
 * 0 <= deliciousness[i] <= 2的20次方
 *
 * 输入：deliciousness = [1,3,5,7,9]       输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 *       它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 *
 * 输入：deliciousness = [1,1,1,3,3,3,7]   输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 *
 * @author Moonlight
 * @date 2021/3/6 14:44
 */
public class CountGoodMeals {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9}, b = {1, 1, 1, 3, 3, 3, 7};
        System.out.println(countPairs1231(a));
        System.out.println(countPairs1231(b));
    }

    public static int countPairs1231(int[] deliciousness) {
        // 数组中任意两个数x,y 相加绝不会超过 2的21次方 因为deliciousness[i] <= 2的20次方
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int deliciousnes : deliciousness) {
            for (int j = 0; j < 22; j++) {
                if (((1 << j) - deliciousnes) < 0) {
                    continue;
                }
                if (map.containsKey((1 << j) - deliciousnes)) {
                    res += map.get((1 << j) - deliciousnes);
                    res %= 1_000_000_007;
                }
            }
            map.put(deliciousnes, map.getOrDefault(deliciousnes, 0) + 1);
        }
        return res;
    }

}
