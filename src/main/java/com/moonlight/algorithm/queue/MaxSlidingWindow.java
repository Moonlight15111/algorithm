package com.moonlight.algorithm.queue;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
   返回滑动窗口中的最大值。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 *   滑动窗口的位置                最大值
 *    ---------------               -----
 *    [1  3  -1] -3  5  3  6  7       3
 *    1 [3  -1  -3] 5  3  6  7       3
 *    1  3 [-1  -3  5] 3  6  7       5
 *    1  3  -1 [-3  5  3] 6  7       5
 *   1  3  -1  -3 [5  3  6] 7       6
 *   1  3  -1  -3  5 [3  6  7]      7
 * @author Moonlight
 * @date 2020/11/20 12:04
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return null;
        }
        int length = nums.length, index = 0;
        int [] res = new int[length - k + 1];
        // 双端队列，存储数组数据下标
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            // 保证队列中数组位置的数值按从大到小排序，最小的放在最右端
            while (!list.isEmpty() && nums[i] >= nums[list.peekLast()]) {
                list.pollLast();
            }
            list.addLast(i);
            // 队首储存的下标应该在滑动窗口的范围内
            // 如：当窗口长度为3，i为4时，滑动窗口最左的范围至多只能到 下标为 1 的位置
            if (list.peekFirst() == i - k) {
                list.pollFirst();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            // 如：当窗口长度为3时，只有下标 >= 2，才能说明窗口已经初始化并进行滑动了
            if (i >= k - 1) {
                res[index++] = nums[list.peekFirst()];
            }
        }

        return res;
    }

}
