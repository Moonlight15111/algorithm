package com.moonlight.algorithm.train.greedy;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
     你需要按照以下要求，帮助老师给这些孩子分发糖果：
         1.每个孩子至少分配到 1 个糖果。
         2.相邻的孩子中，评分高的孩子必须获得更多的糖果。
     那么这样下来，老师至少需要准备多少颗糖果呢？
     来源：力扣（LeetCode）
     原题：https://leetcode-cn.com/problems/candy〉
 *
 * @author Moonlight
 * @date 2020/8/4 12:55
 */
public class CandyDispatch {

    public static void main (String[] args) {
        // candy count: 5
        int[] candy1 = {1,0,2};
        // candy count: 4
        int[] candy2 = {1,2,2};
        // candy count: 11    1  2  3  2  1  2
        int[] candy3 = {1, 2, 3, 3, 0, 1};
        // candy count: 13   1 2 3 1 3 2 1
        int[] candy4 = {1, 2, 87, 87, 87, 2, 1};

        System.out.println(candyDispatch(candy1));
        System.out.println(candyDispatch(candy2));
        System.out.println(candyDispatch(candy3));
        System.out.println(candyDispatch(candy4));
    }

    private static int candyDispatch(int[] ratings) {
        int count = 0, ratingsLength = ratings.length;

        int[] left = new int[ratingsLength], right = new int[ratingsLength];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        // 先从左往右扫一次,此时扫描的结果必然是：如果第i位置的数比它左邻居大,那么它就可以比它左邻居多分一颗糖
        for (int i = 1; i < ratingsLength; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        // 再从右往左扫一次,同上
        for (int i = ratingsLength - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        // 取最大值
        for (int i = 0; i < ratingsLength; i++) {
            count += Math.max(left[i], right[i]);
        }

        return count;
    }

}
