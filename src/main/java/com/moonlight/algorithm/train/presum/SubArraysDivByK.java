package com.moonlight.algorithm.train.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 *
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 * 输入：A = [4,5,0,-2,-3,1], K = 5  输出：7
 * 解释：有 7 个子数组满足其元素之和可被 K = 5 整除：
 *       [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 * @author Moonlight
 * @date 2021/5/6 17:35
 */
public class SubArraysDivByK {

    public static void main(String[] args) {
        int[] a = {4, 5, 0, -2, -3, 1};
        System.out.println(subarraysDivByK(a, 5));
    }

    public static int subarraysDivByK(int[] A, int K) {
        int presum = 0, ans = 0, div = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // 预存前缀和为0 的情况出现
        map.put(0, 1);
        for (int n : A) {
            presum += n;
            // 前缀和可能为负
            // -1 % 2 = -1  ==> ( -1 % 2 + 2) % 2 = 1
            // 1 % 2 = 1 ==> ( 1 % 2 + 2) % 2 = 1
            // 区间[i, j]的和 = presum[j] - presum[i - 1]
            // 则区间[i, j]的和是否可以整除K就等价于(presum[j] - presum[i - 1] ) % k 是否等于 0
            // 设: (presum[j] - presum[i - 1] ) % k == 0
            // 则: presum[j] % k - presum[i - 1] % k == 0;
            //     presum[j] % k == presum[i - 1] % k
            // 所以其实就是在求区间[i, j]的区间和能否被K整除
            div = (presum % K + K) % K;
            if (map.containsKey(div)) {
                ans += map.get(div);
            }
            map.put(div, map.getOrDefault(div, 0) + 1);
        }
        return ans;
    }

}
