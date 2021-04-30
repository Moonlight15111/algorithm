package com.moonlight.algorithm.train.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 输入: [4,3,2,7,8,2,3,1]   输出: [5,6]
 *
 * @author Moonlight
 * @date 2021/4/30 12:45
 */
public class FindDisappearedNumbers {

    public static void main(String[] args) {
        int[] a = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(helpArr(a) + ", " + withoutHelpArr(a));
    }

    public static List<Integer> withoutHelpArr(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        // 遍历数组，将每个数字交换到它 - 1 的位置上
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1) {
                i++;
                continue;
            }
            int index = nums[i] - 1;
            if (nums[i] == nums[index]) {
                i++;
                continue;
            }
            int t = nums[index];
            nums[index] = nums[i];
            nums[i] = t;
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                ans.add(j + 1);
            }
        }
        return ans;
    }

    public static List<Integer> helpArr(int[] nums) {
        int n = nums.length;
        int[] help = new int[n + 1];
        for (int num : nums) {
            help[num]++;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (help[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
    }

}