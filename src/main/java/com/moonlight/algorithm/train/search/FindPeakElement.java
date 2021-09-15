/**
 * 功能描述:
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 * https://leetcode-cn.com/problems/find-peak-element
 *
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 *
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 *
 * 作者: Moonlight<bzeng@ibingli.com>
 * 创建时间: 2021-09-15 12:23
 */
public class FindPeakElement {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1}, b = {1, 2, 1, 3, 5, 6, 4}, c = {1}, d = {1, 2};
        // 2
        System.out.println(findPeakElement(a));
        // 1 5
        System.out.println(findPeakElement(b));
        // 0
        System.out.println(findPeakElement(c));
        // 1
        System.out.println(findPeakElement(d));
    }

    public static int findPeakElement(int[] nums) {
//        return bigOn(nums);
        return logN(nums);
    }

    public static int logN(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    public static int bigOn(int[] nums) {
        for (int i = 1, len = nums.length; i < len; i++) {
            if (nums[i - 1] < nums[i]) {
                if ((i < len - 1 && nums[i + 1] < nums[i]) || i + 1 == len) {
                    return i;
                }
            }
        }
        return 0;
    }

}
