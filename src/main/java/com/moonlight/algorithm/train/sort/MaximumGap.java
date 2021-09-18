import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-gap/
 *
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 *
 * 输入: [3,6,9,1]  输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 *
 * 输入: [10]   输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 *
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 *
 */
public class MaximumGap {

    public static void main(String[] args) {
        int[] a = {3, 6, 9, 1}, b = {10};
        System.out.println(sort(a));
        System.out.println(sort(b));
    }

    public static int maximumGap(int[] nums) {
        // 桶排序或者基数排序，不过这两种排序方式基本上不怎么用，自己也不是很懂，抄一遍别人的代码又没啥意思，就懒得实现了
        return -1;
    }

    public static int sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE, len = nums.length;
        for (int i = 1; i < len; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }

}
