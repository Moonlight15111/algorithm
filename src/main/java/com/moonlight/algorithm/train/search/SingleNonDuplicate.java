package com.moonlight.algorithm.train.search;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 *
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 输入: [1,1,2,3,3,4,4,8,8]   输出: 2
 *
 * 输入: [3,3,7,7,10,11,11]    输出: 10
 *
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 *
 * @author Moonlight
 * @date 2021/5/8 10:09
 */
public class SingleNonDuplicate {

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 3, 4, 4, 8, 8}, b = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(bigOn(a) + ", " + bigLogN(a));
        System.out.println(bigOn(b) + ", " + bigLogN(b));
    }

    public static int bigLogN(int[] nums) {
        int l = 0, r = nums.length - 1, m;

        while (l <= r) {
            m = l + ((r - l) >>> 1);
            if (nums[m + 1] != nums[m] && nums[m - 1] != nums[m]) {
                return nums[m];
            }
            if (nums[m - 1] == nums[m]) {
                m--;
                if ((m - l) % 2 == 0) {
                    l = m + 2;
                } else {
                    r = m - 1;
                }
            } else if (nums[m + 1] == nums[m]) {
                m++;
                if ((r - m) % 2 == 0) {
                    r = m - 2;
                } else {
                    l = m + 1;
                }
            }
        }

        return nums[l];
    }

    public static int bigOn(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            ans ^= n;
        }
        return ans;
    }

}
