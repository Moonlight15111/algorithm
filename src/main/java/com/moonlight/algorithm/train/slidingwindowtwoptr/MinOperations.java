package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * https://leetcode-cn.com/problems/minimum-operations-to-reduce-x-to-zero/
 *
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，
 * 然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 *
 * 输入：nums = [1,1,4,2,3], x = 5  输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 *
 * 输入：nums = [5,6,7,8,9], x = 4  输出：-1
 *
 * 输入：nums = [3,2,20,1,1,3], x = 10  输出：5
 * 解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 *
 */
public class MinOperations {

    public static void main(String[] args) {
        int[] a ={1, 1, 4, 2, 3}, b = {5, 6, 7, 8, 9}, c = {3, 2, 20, 1, 1, 3}, d = {1, 1};
        System.out.println(recursion(a, 5));
        System.out.println(recursion(b, 4));
        System.out.println(recursion(c, 10));
        System.out.println(recursion(d, 3));
    }

    public static int recursion(int[] nums, int x) {
        // time out
        return recursion(0, nums.length - 1, 0, nums, x);
    }

    private static int recursion(int l, int r, int a, int[] nums, int x) {
        if (x == 0) {
            return a;
        }
        if (l > r || x < 0) {
            return -1;
        }
        int left = recursion(l + 1, r, a + 1, nums, x - nums[l]);
        int right = recursion(l, r - 1, a + 1, nums, x - nums[r]);
        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }
        return Math.min(left, right);
    }

}
