package com.moonlight.algorithm.train.couldnotworkout;

import java.util.Arrays;

/**
 * 麻将的游戏规则中，共有两种方式凑成「一组牌」：
 *   顺子：三张牌面数字连续的麻将，例如 [4,5,6]
 *   刻子：三张牌面数字相同的麻将，例如 [10,10,10]
 * 给定若干数字作为麻将牌的数值（记作一维数组 tiles），请返回所给 tiles 最多可组成的牌组数。
 * 注意：凑成牌组时，每张牌仅能使用一次。
 *
 * 输入：tiles = [2,2,2,3,4]  输出：1
 * 解释：最多可以组合出 [2,2,2] 或者 [2,3,4] 其中一组牌。
 *
 * 输入：tiles = [2,2,2,3,4,1,3] 输出：2
 * 解释：最多可以组合出 [1,2,3] 与 [2,3,4] 两组牌。
 *
 * @author Moonlight
 * @date 2021/4/10 16:02
 */
public class MaxGroupNumber {

    public static void main(String[] args) {
        // 1    2   3
        int[] a = {2, 2, 2, 3, 4}, b = {2, 2, 2, 3, 4, 1, 3}, c = {1, 1, 2, 2, 2, 3, 3, 3, 4};
//        System.out.println(maxGroupNumber(a));
//        System.out.println(maxGroupNumber(b));
        System.out.println(maxGroupNumber(c));
    }

    public static int maxGroupNumber(int[] tiles) {
        if (tiles.length < 3) {
            return 0;
        }
        int res = 0;
        Arrays.sort(tiles);
        boolean[] visited = new boolean[tiles.length];
        for (int i = 0, j, k; i < tiles.length; i++) {

        }
        return res;
    }


}
