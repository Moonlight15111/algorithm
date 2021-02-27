package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 原题：https://leetcode-cn.com/problems/4sum/
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 targe
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等
 * 找出所有满足条件且不重复的四元组。答案中不可以包含重复的四元组。
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * @ClassName FourSum
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/2/27 16:34
 * @Version V1.0
 **/
public class FourSum {

    public static void main(String[] args) {
//        int[] arr = {-2, -1, -1, 1, 1, 2, 2};
        int[] arr = {0, 0, 0, 0};
        List<List<Integer>> lists = fourSum(arr, 0);
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }

        int[] x = {-3,-2,-1,0,0,1,2,3};
        List<List<Integer>> ls = fourSum(x, 0);
        for (List<Integer> list : ls) {
            for (int i : list) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // 和三数之和差不多的思路，
        // 排好序以后，每次固定一个数，去找另外三个数字
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);

        int aPtr, bPtr, cPtr, dPtr, length = nums.length, sum;
        for (int i = 0; i <= length - 4; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            aPtr = i;
            bPtr = i + 1;
            while (bPtr <= length - 3) {
                // 去重
                if (bPtr > i + 1 && nums[bPtr] == nums[bPtr - 1]) {
                    bPtr++;
                    continue;
                }
                cPtr = bPtr + 1;
                dPtr = length - 1;

                while (cPtr < dPtr) {
                    sum = nums[aPtr] + nums[bPtr] + nums[cPtr] + nums[dPtr];

                    if (sum == target) {
                        res.add(Arrays.asList(nums[aPtr], nums[bPtr], nums[cPtr], nums[dPtr]));

                        // 去重
                        while (cPtr < dPtr && nums[cPtr] == nums[++cPtr]);
                        while (cPtr < dPtr && nums[dPtr] == nums[--dPtr]);
                    } else if (sum < target) {
                        cPtr++;
                    } else {
                        dPtr--;
                    }
                }

                bPtr++;
            }
        }

        return res;
    }

}
