package com.moonlight.algorithm.train.search;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 * <p>
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 输入：nums = [2,0,2,1,1,0]   输出：[0,0,1,1,2,2]
 * <p>
 * 输入：nums = [2,0,1]    输出：[0,1,2]
 * <p>
 * 输入：nums = [0]   输出：[0]
 * <p>
 * 输入：nums = [1]   输出：[1]
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 *
 * @ClassName SortColors
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/25 21:42
 * @Version V1.0
 **/
public class SortColors {

    public static void main(String[] args) {
        int[] a = {2, 0, 2, 1, 1, 0}, b = {0, 0, 1, 1, 2, 2}, c = {0}, d = {1};
//        sortColors(a);
//        sortColors(b);
//        sortColors(c);
//        sortColors(d);
        sortColors12313(a);
        sortColors12313(b);
        sortColors12313(c);
        sortColors12313(d);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));
    }

    public static void sortColors12313(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] == 0) {
                nums[blue++] = 2;
                nums[white++] = 1;
                nums[red++] = 0;
            } else if (nums[i] == 1) {
                nums[blue++] = 2;
                nums[white++] = 1;
            } else {
                nums[blue++] = 2;
            }
        }
    }

    public static void sortColors(int[] nums) {
        int red = 0, blue = nums.length - 1;
        for (int i = 0; i <= blue; i++) {
            if (nums[i] == 0) {
               nums[i] = nums[red];
               nums[red++] = 0;
            }
            if (nums[i] == 2) {
                nums[i] = nums[blue];
                nums[blue--] = 2;
                if (nums[i] != 1) {
                    i--;
                }
            }
        }
    }

}
