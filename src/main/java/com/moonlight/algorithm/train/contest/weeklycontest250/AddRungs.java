package com.moonlight.algorithm.train.contest.weeklycontest250;

/**
 * 给你一个 严格递增 的整数数组 rungs ，用于表示梯子上每一台阶的 高度 。
 * 当前你正站在高度为 0 的地板上，并打算爬到最后一个台阶。
 * 另给你一个整数 dist 。每次移动中，你可以到达下一个距离你当前位置（地板或台阶）不超过 dist 高度的台阶。
 * 当然，你也可以在任何正 整数 高度处插入尚不存在的新台阶。
 * 返回爬到最后一阶时必须添加到梯子上的 最少 台阶数。
 * <p>
 * 输入：rungs = [1,3,5,10], dist = 2   输出：2
 * 解释：
 * 现在无法到达最后一阶。
 * 在高度为 7 和 8 的位置增设新的台阶，以爬上梯子。
 * 梯子在高度为 [1,3,5,7,8,10] 的位置上有台阶。
 * <p>
 * 输入：rungs = [3,6,8,10], dist = 3  输出：0
 * 解释：这个梯子无需增设新台阶也可以爬上去。
 * <p>
 * 输入：rungs = [3,4,6,7], dist = 2   输出：1
 * 解释：
 * 现在无法从地板到达梯子的第一阶。
 * 在高度为 1 的位置增设新的台阶，以爬上梯子。
 * 梯子在高度为 [1,3,4,6,7] 的位置上有台阶。
 * <p>
 * 输入：rungs = [5], dist = 10  输出：0
 * 解释：这个梯子无需增设新台阶也可以爬上去。
 *
 * @ClassName AddRungs
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/7/18 10:46
 * @Version V1.0
 **/
public class AddRungs {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 10}, b = {3, 6, 8, 10}, c = {3, 4, 6, 7}, d = {5};
        System.out.println(addRungs(a, 2));
        System.out.println(addRungs(b, 3));
        System.out.println(addRungs(c, 2));
        System.out.println(addRungs(d, 10));
    }

    public static int addRungs(int[] rungs, int dist) {
        int ans = 0, cur = 0;
        for (int r : rungs) {
            if (r - cur > dist) {
                ans += (r - cur - 1) / dist;
            }
            cur = r;
        }
        return ans;
    }

}
