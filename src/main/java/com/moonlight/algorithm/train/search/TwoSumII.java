package com.moonlight.algorithm.train.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，
 * 所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 输入：numbers = [2,7,11,15], target = 9    输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 输入：numbers = [2,3,4], target = 6   输出：[1,3]
 *
 * 输入：numbers = [-1,0], target = -1   输出：[1,2]
 *
 * @ClassName TwoSumII
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/2 23:29
 * @Version V1.0
 **/
public class TwoSumII {

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15}, b = {2, 3, 4}, c = {-1, 0};
        System.out.println(Arrays.toString(twoSum(a, 9)));
        System.out.println(Arrays.toString(twoSum(b, 6)));
        System.out.println(Arrays.toString(twoSum(c, -1)));

        System.out.println(Arrays.toString(twoSum123(a, 9)));
        System.out.println(Arrays.toString(twoSum123(b, 6)));
        System.out.println(Arrays.toString(twoSum123(c, -1)));
    }

    public static int[] twoSum123(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int sum = numbers[left] + numbers[right];
        while (sum != target) {
            if (sum < target) {
                left++;
            } else {
                right--;
            }
            sum = numbers[left] + numbers[right];
        }
        return new int[]{left + 1, right + 1};
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            } else {
                map.put(numbers[i], i);
            }
        }
        return new int[]{-1, -1};
    }

}
