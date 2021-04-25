package com.moonlight.algorithm.train.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 *
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * 找到所有出现两次的元素。
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 输入: [4,3,2,7,8,2,3,1]   输出: [2,3]
 *
 * @ClassName FindAllDuplicates
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/24 14:56
 * @Version V1.0
 **/
public class FindAllDuplicates {

    public static void main(String[] args) {
        int[] a = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(map(a) + ", " + o1(a));
    }

    public static List<Integer> o1(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return ans;
        }
        // 根据题意1 ≤ a[i] ≤ n （n为数组长度） 有些元素出现两次而其他元素出现一次，可按如下操作：
        // 将元素转换成数组的下标，1放在0位置，2放在1位置 ... n 在 n - 1 位置
        // 将元素对应的位置的数置为负数，如果元素已经是负数了，那么说明这个位置已经对应过一次了
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                ans.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
        }

        return ans;
    }

    public static List<Integer> map(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return ans;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                ans.add(n);
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        return ans;
    }
}
