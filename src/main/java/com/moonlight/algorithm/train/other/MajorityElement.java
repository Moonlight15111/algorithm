package com.moonlight.algorithm.train.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 *
 * 输入：[3,2,3]  输出：[3]
 *
 * 输入：nums = [1]  输出：[1]
 *
 * 输入：[1,1,1,3,3,2,2,2]   输出：[1,2]
 *
 * @author Moonlight
 * @date 2021/7/7 16:49
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] a = {3, 2, 3}, b = {1}, c = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println(majorityElementByMap(a) + ", " + majorityElement(a));
        System.out.println(majorityElementByMap(b) + ", " + majorityElement(b));
        System.out.println(majorityElementByMap(c) + ", " + majorityElement(c));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int x = nums[0], y = nums[0], cntX = 0, cntY = 0;
        for (int i : nums) {
            if (x == i) {
                cntX++;
                continue;
            }
            if (y == i) {
                cntY++;
                continue;
            }
            if (cntX == 0) {
                x = i;
                cntX = 1;
                continue;
            }
            if (cntY == 0) {
                y = i;
                cntY = 1;
                continue;
            }
            cntX--;
            cntY--;
        }
        cntX = 0;
        cntY = 0;
        for (int i : nums) {
            if (i == x) {
                cntX++;
            } else if (i == y) {
                cntY++;
            }
        }
        if (cntX > nums.length / 3) {
            ans.add(x);
        }
        if (cntY > nums.length / 3) {
            ans.add(y);
        }
        return ans;
    }

    public static List<Integer> majorityElementByMap(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int limit = nums.length / 3;
        for (int k : map.keySet()) {
            if (map.get(k) > limit) {
                ans.add(k);
            }
        }
        return ans;
    }

}
