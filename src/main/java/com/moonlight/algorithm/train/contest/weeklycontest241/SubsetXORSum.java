package com.moonlight.algorithm.train.contest.weeklycontest241;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个数组的 异或总和 定义为数组中所有元素按位 XOR 的结果；如果数组为 空 ，则异或总和为 0 。
 * 例如，数组 [2,5,6] 的 异或总和 为 2 XOR 5 XOR 6 = 1 。
 * 给你一个数组 nums ，请你求出 nums 中每个 子集 的 异或总和 ，计算并返回这些值相加之 和 。
 * 注意：在本题中，元素 相同 的不同子集应 多次 计数。
 * 数组 a 是数组 b 的一个 子集 的前提条件是：从 b 删除几个（也可能不删除）元素能够得到 a 。
 *
 * 输入：nums = [1,3]  输出：6
 * 解释：[1,3] 共有 4 个子集：
 * - 空子集的异或总和是 0 。
 * - [1] 的异或总和为 1 。
 * - [3] 的异或总和为 3 。
 * - [1,3] 的异或总和为 1 XOR 3 = 2 。
 * 0 + 1 + 3 + 2 = 6
 *
 * 输入：nums = [5,1,6]  输出：28
 * 解释：[5,1,6] 共有 8 个子集：
 * - 空子集的异或总和是 0 。
 * - [5] 的异或总和为 5 。
 * - [1] 的异或总和为 1 。
 * - [6] 的异或总和为 6 。
 * - [5,1] 的异或总和为 5 XOR 1 = 4 。
 * - [5,6] 的异或总和为 5 XOR 6 = 3 。
 * - [1,6] 的异或总和为 1 XOR 6 = 7 。
 * - [5,1,6] 的异或总和为 5 XOR 1 XOR 6 = 2 。
 * 0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28
 *
 * 输入：nums = [3,4,5,6,7,8]  输出：480
 * 解释：每个子集的全部异或总和值之和为 480 。
 *
 * @ClassName SubsetXORSum
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/16 10:39
 * @Version V1.0
 **/
public class SubsetXORSum {

    public static void main(String[] args) {
        int[] a = {1, 3}, b = {5, 1, 6}, c = {3, 4, 5, 6, 7, 8};
        System.out.println(subsetXORSum(a));
        System.out.println(subsetXORSum(b));
        System.out.println(subsetXORSum(c));
    }

    public static int subsetXORSum(int[] nums) {
        int ans = 0;

        List<Integer> sub = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), sub);

        for (int n : sub) {
            ans +=  n;
        }

        return ans;
    }

    private static void backtrack(int i, int[] nums, List<Integer> path, List<Integer> sub) {
        int xor = 0;
        for (int n : path) {
            xor ^= n;
        }
        sub.add(xor);
        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            backtrack(j + 1, nums, path, sub);
            path.remove(path.size() - 1);
        }
    }

}
