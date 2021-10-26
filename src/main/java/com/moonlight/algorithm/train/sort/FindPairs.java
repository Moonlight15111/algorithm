package com.moonlight.algorithm.train.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/
 *
 * 给定一个整数数组和一个整数 k，你需要在数组里找到 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 * 这里将 k-diff 数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
 *   0 <= i < j < nums.length
 *   |nums[i] - nums[j]| == k
 * 注意，|val| 表示 val 的绝对值。
 *
 * 输入：nums = [3, 1, 4, 1, 5], k = 2  输出：2
 * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 *
 * 输入：nums = [1, 2, 3, 4, 5], k = 1  输出：4
 * 解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 *
 * 输入：nums = [1, 3, 1, 5, 4], k = 0  输出：1
 * 解释：数组中只有一个 0-diff 数对，(1, 1)。
 *
 * 输入：nums = [1,2,4,4,3,3,0,9,2,3], k = 3  输出：2
 *
 * 输入：nums = [-1,-2,-3], k = 1  输出：2
 *
 * @author Moonlight
 */
public class FindPairs {

    public static void main(String[] args) {
        int[] a = {3, 1, 4, 1, 5}, b = {1, 2, 3, 4, 5}, c = {1, 3, 1, 5, 4},
              d = {1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, e = {-1, -2, -3};
        System.out.println(findPairs(a, 2) + ", " + bigOn(a, 2));
        System.out.println(findPairs(b, 1) + ", " + bigOn(b, 1));
        System.out.println(findPairs(c, 0) + ", " + bigOn(c, 0));
        System.out.println(findPairs(d, 3) + ", " + bigOn(d, 3));
        System.out.println(findPairs(e, 1) + ", " + bigOn(e, 1));
    }

    public static int bigOn(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> ans = new HashSet<>(), set = new HashSet<>();
        for (int num : nums) {
            int dif = num - k;
            if (set.contains(dif)) {
                ans.add(num);
            }
            set.add(num);
        }
        return ans.size();
    }

    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - k > nums[i]) {
                    break;
                } else if (nums[j] - k == nums[i]) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}