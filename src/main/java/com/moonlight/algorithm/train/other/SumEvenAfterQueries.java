package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries/
 *
 * 给出一个整数数组 A 和一个查询数组 queries。
 * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 *
 * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 输出：[8,6,2,4]
 * 解释：
 *     开始时，数组为 [1,2,3,4]。
 *     将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 *     将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 *     将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 *     将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 * @author Moonlight
 */
public class SumEvenAfterQueries {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{
                {1, 0}, {-3, 1}, {-4, 0}, {2, 3}
        })));
    }

    public static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        // 先把偶数都加一起，在查询的时候根据具体的情况
        // 判断 queries[i][1] 位置上的数字是否为偶数，为偶数则代表之前已经加过一遍了，应当减一次
        int sum = 0;
        for (int i : nums) {
            if ((i & 1) == 0) {
                sum += i;
            }
        }
        int i = 0;
        for (int[] q : queries) {
            int val = q[0], idx = q[1];
            if ((nums[idx] & 1) == 0) {
                sum -= nums[idx];
            }
            nums[idx] += val;
            if ((nums[idx] & 1) == 0) {
                sum += nums[idx];
            }
            ans[i++] = sum;
        }
        return ans;
    }

}
