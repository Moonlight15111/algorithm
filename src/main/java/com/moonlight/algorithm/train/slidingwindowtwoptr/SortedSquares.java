import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * 作者: Moonlight
 * 创建时间: 2021-09-16 12:24
 */
public class SortedSquares {

    public static void main(String[] args) {
        int[] a = {-4, -1, 0, 3, 10}, b = {-7, -3, 2, 3, 11};

        System.out.println(Arrays.toString(bigOnlogn(a)));
        System.out.println(Arrays.toString(bigOnlogn(b)));

        System.out.println(Arrays.toString(bigOn(a)));
        System.out.println(Arrays.toString(bigOn(b)));
    }

    public static int[] bigOn(int[] nums) {
        // 最大的数字必然分布在数组两端
        int[] ans = new int[nums.length];
        for (int i = 0, j = nums.length - 1, ai = nums.length - 1; i <= j ;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[ai] = nums[i] * nums[i];
                i++;
            } else {
                ans[ai] = nums[j] * nums[j];
                j--;
            }
            ai--;
        }

        return ans;
    }

    public static int[] bigOnlogn(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

}
