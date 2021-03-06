package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode-cn.com/problems/find-lucky-integer-in-an-array/
 * <p>
 * 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 * 如果数组中存在多个幸运数，只需返回 最大 的那个。
 * 如果数组中不含幸运数，则返回 -1 。
 * <p>
 * 1 <= arr.length <= 500
 * 1 <= arr[i] <= 500
 * <p>
 * 输入：arr = [2,2,3,4]  输出：2
 * 解释：数组中唯一的幸运数是 2 ，因为数值 2 的出现频次也是 2 。
 * <p>
 * 输入：arr = [1,2,2,3,3,3]  输出：3
 * 解释：1、2 以及 3 都是幸运数，只需要返回其中最大的 3 。
 * <p>
 * 输入：arr = [2,2,2,3,3]  输出：-1
 * 解释：数组中不存在幸运数。
 * <p>
 * 输入：arr = [5]  输出：-1
 * <p>
 * 输入：arr = [7,7,7,7,7,7,7]  输出：7
 *
 * @author Moonlight
 */
public class FindLucky {

    public static void main(String[] args) {
        int[] a = {2, 2, 3, 4}, b = {1, 2, 2, 3, 3, 3}, c = {2, 2, 2, 3, 3}, d = {5}, e = {7, 7, 7, 7, 7, 7, 7};
        System.out.println(findLucky(a));
        System.out.println(findLucky(b));
        System.out.println(findLucky(c));
        System.out.println(findLucky(d));
        System.out.println(findLucky(e));
    }

    public static int findLucky(int[] arr) {
        int[] cnt = new int[501];
        for (int n : arr) {
            cnt[n]++;
        }
        int ans = -1;
        for (int i = 1; i < 501; i++) {
            if (cnt[i] == i) {
                ans = Math.max(ans, i);
            }
        }
        return ans;
    }

}
