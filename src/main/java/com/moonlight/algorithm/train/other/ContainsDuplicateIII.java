package com.moonlight.algorithm.train.other;

import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 *
 * 在整数数组 nums 中，是否存在两个下标 i 和 j，
 * 使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t，
 * 且满足 i 和 j 的差的绝对值也小于等于 ķ 。
 * 如果存在则返回 true，不存在返回 false。
 *
 * 输入: nums = [1,2,3,1], k = 3, t = 0   输出: true
 *
 * 输入: nums = [1,0,1,1], k = 1, t = 2   输出: true
 *
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3  输出: false
 *
 * @ClassName ContainsDuplicateIII
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/5 11:47
 * @Version V1.0
 **/
public class ContainsDuplicateIII {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1}, b = {1, 0, 1, 1},
                c = {1, 5, 9, 1, 5, 9}, d = {-2147483648, 2147483647}, e = {2147483640, 2147483641};
        // true
        System.out.println(containsNearbyAlmostDuplicate1231(a, 3, 0));
        // true
        System.out.println(containsNearbyAlmostDuplicate1231(b, 1, 2));
        // false
        System.out.println(containsNearbyAlmostDuplicate1231(c, 2, 3));
        // false
        System.out.println(containsNearbyAlmostDuplicate1231(d, 1, 1));
        // true
        System.out.println(containsNearbyAlmostDuplicate1231(e, 1, 100));
    }

    public static boolean containsNearbyAlmostDuplicate1231(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // ceiling: 返回 treeSet 中大于等于 e 的元素中最小的元素，如果没有大于等于 e 的元素就返回 null
            Long ceiling = treeSet.ceiling((long)nums[i]);
            if (ceiling != null && ceiling <= nums[i] + t) {
                return true;
            }
            // floor: 返回 treeSet 中小于等于 e 的元素中最大的元素，如果没有小于等于 e 的元素就返回 null
            Long floor = treeSet.floor((long)nums[i]);
            if (floor != null && nums[i] <= floor + t) {
                return true;
            }
            treeSet.add((long)nums[i]);
            if (treeSet.size() > k) {
                treeSet.remove((long)nums[i - k]);
            }
        }
        return false;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // timeout
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs((long)nums[j] - (long)nums[i]) <= t && Math.abs(j - i) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

}