package com.moonlight.algorithm.train.contest.biweeklycontest55;

/**
 * 给你一个下标从 0 开始的整数数组 nums ，如果 恰好 删除 一个 元素后，数组 严格递增 ，那么请你返回 true ，否则返回 false 。
 * 如果数组本身已经是严格递增的，请你也返回 true 。
 * 数组 nums 是 严格递增 的定义为：对于任意下标的 1 <= i < nums.length 都满足 nums[i - 1] < nums[i] 。
 *
 * 输入：nums = [1,2,10,5,7]
 * 输出：true
 * 解释：从 nums 中删除下标 2 处的 10 ，得到 [1,2,5,7] 。
 * [1,2,5,7] 是严格递增的，所以返回 true 。
 *
 * 输入：nums = [2,3,1,2]
 * 输出：false
 * 解释：
 * [3,1,2] 是删除下标 0 处元素后得到的结果。
 * [2,1,2] 是删除下标 1 处元素后得到的结果。
 * [2,3,2] 是删除下标 2 处元素后得到的结果。
 * [2,3,1] 是删除下标 3 处元素后得到的结果。
 * 没有任何结果数组是严格递增的，所以返回 false 。
 *
 * 输入：nums = [1,1,1]
 * 输出：false
 * 解释：删除任意元素后的结果都是 [1,1] 。
 * [1,1] 不是严格递增的，所以返回 false 。
 *
 * 输入：nums = [1,2,3]
 * 输出：true
 * 解释：[1,2,3] 已经是严格递增的，所以返回 true 。
 *
 * @ClassName CanBeIncreasing
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/6/26 22:37
 * @Version V1.0
 **/
public class CanBeIncreasing {

    public static void main(String[] args) {
        int[] a = {1, 2, 10, 5, 7}, b = {2, 3, 1, 2}, c = {1, 1, 1}, d = {1, 2, 3}, e = {105, 924, 32, 968};
        System.out.println(canBeIncreasing(a));
        System.out.println(canBeIncreasing(b));
        System.out.println(canBeIncreasing(c));
        System.out.println(canBeIncreasing(d));
        System.out.println(canBeIncreasing(e));
    }

    public static boolean canBeIncreasing(int[] nums) {
        int n = nums.length;
        boolean find;
        for(int i = 0, last; i < n; i++) {
            last = -1;
            find = true;
            for(int j = 0; j < n; j++) {
                if( j == i ){
                    continue;
                }
                if (last >= nums[j]) {
                    find = false;
                }
                last = nums[j];
            }
            if (find) {
                return true;
            }
        }
        return false;
    }

}
