package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-element/
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *      你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，
 *      而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 *
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *       注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 *
 * @ClassName RemoveElement
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/14 16:12
 * @Version V1.0
 **/
public class RemoveElement {

    public static void main(String[] args) {
        int[] a = {3, 2, 2, 3}, b = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(a, 3));
        System.out.println(Arrays.toString(a));
        System.out.println(removeElement(b, 2));
        System.out.println(Arrays.toString(b));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] != val) {
                nums[res++] = nums[i];
            }
        }
        return res;
    }

}
