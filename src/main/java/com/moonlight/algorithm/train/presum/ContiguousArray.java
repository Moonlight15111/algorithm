package com.moonlight.algorithm.train.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/contiguous-array/
 *
 * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
 *
 * 输入: [0,1]    输出: 2   说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 *
 * 输入: [0,1,0]  输出: 2   说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *
 * @author Moonlight
 * @date 2021/5/7 12:51
 */
public class ContiguousArray {

    public static void main(String[] args) {
        int[] a = {0, 1}, b = {0, 1, 0};
        System.out.println(findMaxLength(a));
        System.out.println(findMaxLength(b));
    }

    public static int findMaxLength(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int presum = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                presum += 1;
            } else {
                presum += -1;
            }
            if (map.containsKey(presum)) {
                ans = Math.max(ans, i - map.get(presum));
            } else {
                map.put(presum, i);
            }
        }
        return ans;
    }

}