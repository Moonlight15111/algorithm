package com.moonlight.algorithm.train.string;

import java.util.*;
/**
 * 原题：https://leetcode-cn.com/problems/summary-ranges/
 * 给定一个无重复元素的有序整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，
 * 并且不存在属于某个范围但不属于nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *     "a->b" ，如果 a != b       "a" ，如果 a == b
 *
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 * @ClassName SummaryRanges
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/10 11:16
 * @Version V1.0
 **/
public class SummaryRanges {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 5, 7};
        for (String s : summaryRanges(arr)) {
            System.out.print(s + "  ");
        }
        System.out.println();
        int[] arr2 = {0, 2, 3, 4, 6, 8, 9};
        for (String s : summaryRanges(arr2)) {
            System.out.print(s + "  ");
        }
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int curIndex = 0, oldIndex = 0; curIndex < nums.length; curIndex++) {
            if (curIndex + 1 >= nums.length || nums[curIndex] + 1 != nums[curIndex + 1]) {
                if (oldIndex == curIndex) {
                    res.add("" + nums[curIndex]);
                } else {
                    res.add(nums[oldIndex] + "->" + nums[curIndex]);
                }
                oldIndex = curIndex + 1;
            }
        }
        return res;
    }

}
