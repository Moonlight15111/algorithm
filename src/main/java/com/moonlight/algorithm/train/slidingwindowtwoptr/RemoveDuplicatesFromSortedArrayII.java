package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 你不需要考虑数组中超出新长度后面的元素。
 *
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @ClassName RemoveDuplicatesFromsortedArrayII
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/25 22:39
 * @Version V1.0
 **/
public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3}, b = {0, 0, 1, 1, 1, 1, 2, 3, 3};
//        System.out.println(removeDuplicates(a));
//        System.out.println(removeDuplicates(b));
        System.out.println(removeDuplicates123(a));
        System.out.println(removeDuplicates123(b));
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    public static int removeDuplicates123(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }

        int count = 1, slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                count++;
            } else {
                count = 1;
            }
            if (count < 3) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        // 统计每个数字出现的次数，对于出现次数大于两次的，直接用后面的数字覆盖掉
        int count = 1, len = nums.length, index = 1;
        while (index < len) {
            if (nums[index - 1] == nums[index]) {
                count++;
            } else {
                count = 1;
            }
            if (count > 2) {
                for (int j = index + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                len--;
                index--;
            }
            index++;
        }
        return len;
    }

}
