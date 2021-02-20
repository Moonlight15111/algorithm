package com.moonlight.algorithm.train.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/3sum/
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。 注意：答案中不可以包含重复的三元组。
 *
 * 输入：nums = [-1,0,1,2,-1,-4]   输出：[[-1,-1,2],[-1,0,1]]
 *
 * 输入：nums = []   输出：[]
 *
 * 输入：nums = [0]  输出：[]
 *
 * @author Moonlight
 * @date 2021/2/20 11:27
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(arr);
        for (List<Integer> list : lists) {
            for (int n : list) {
                System.out.print(n + ", ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        // 1.先排序
        Arrays.sort(nums);
        // 2.1.如果第 i 个位置的数 > 0，那么直接返回就好了，因为排序后i后面的数字不可能出现小于0的情况
        // 2.2.如果第 i 个位置的数和第i - 1个位置的数相等，那么就跳过，怕出现重复解的情况
        // 2.3.leftPtr = i + 1      rightPtr = length - 1
        // 2.3.1.如果 nums[i] + nums[leftPtr] + nums[rightPtr] = 0, 说明这是一个有效解，存入res
        // 2.3.2.如果 nums[i] + nums[leftPtr] + nums[rightPtr] > 0, 说明rightPtr太大了，需要左移
        // 2.3.3.如果 nums[i] + nums[leftPtr] + nums[rightPtr] < 0, 说明leftPtr太小了，leftPtr需要右移
        List<Integer> tmp;
        for (int i = 0, length = nums.length, leftPtr, rightPtr, sum; i < length; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            leftPtr = i + 1;
            rightPtr = length - 1;
            while (leftPtr < rightPtr) {
                sum = nums[i] + nums[leftPtr] + nums[rightPtr];
                if (sum == 0) {
                    tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[leftPtr]);
                    tmp.add(nums[rightPtr]);
                    res.add(tmp);
                    while (leftPtr < rightPtr && nums[leftPtr + 1] == nums[leftPtr]) {
                        ++leftPtr;
                    }
                    while (leftPtr < rightPtr && nums[rightPtr - 1] == nums[rightPtr]) {
                        --rightPtr;
                    }
                    leftPtr++;
                    rightPtr--;
                } else if (sum > 0) {
                    rightPtr--;
                } else {
                    leftPtr++;
                }
            }
        }

        return res;
    }

}
