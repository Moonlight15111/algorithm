package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.HashMap;
import java.util.Map;
/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/degree-of-an-array/
 *
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 输入：[1, 2, 2, 3, 1]       输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 *
 * 输入：[1,2,2,3,1,4,2]       输出：6
 *
 * @author Moonlight
 * @date 2021/2/20 10:10
 */
public class FindShortestSubArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(arr));

//        int[] arrrrr = {1, 2, 2, 3, 1, 4, 2};
//        System.out.println(findShortestSubArray(arrrrr));
    }

    public static int findShortestSubArray(int[] nums) {
        // 1.先找到最大度值
        Map<Integer, Integer> record = new HashMap<>();
        int maxDegree = 0;
        for (int n : nums) {
            record.put(n, record.getOrDefault(n, 0) + 1);
            maxDegree = Math.max(maxDegree, record.get(n));
        }
        // 2.重新算一次度值，滑动窗口找最短连续子数组
        int leftPtr = 0, rightPtr = 0, length = nums.length, res = Integer.MAX_VALUE;

        record.clear();

        while (leftPtr < length && rightPtr < length) {
            record.put(nums[rightPtr], record.getOrDefault(nums[rightPtr], 0) + 1);

            rightPtr++;
            while (record.get(nums[rightPtr - 1]) == maxDegree) {
                record.put(nums[leftPtr], record.get(nums[leftPtr]) - 1);

                res = Math.min(res, rightPtr - leftPtr);
                leftPtr++;
            }
        }
        return res;
    }

}