package com.moonlight.algorithm.train.subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/russian-doll-envelopes/
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 说明:  不允许旋转信封。
 * <p>
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]   输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * @author Moonlight
 * @date 2021/3/4 9:25
 */
public class RussianDollEnvelopes {

    public static void main(String[] args) {
        int[][] a = new int[4][2];
        a[0] = new int[]{5, 4};
        a[1] = new int[]{6, 4};
        a[2] = new int[]{6, 7};
        a[3] = new int[]{2, 3};

        System.out.println(maxEnvelopes(a));

        int[][] b = new int[1][2];
        b[0] = new int[] {1, 1};

        System.out.println(maxEnvelopes(b));

        int[][] c = new int[8][2];
        c[0] = new int[] {2, 100};
        c[1] = new int[] {3, 200};
        c[2] = new int[] {4, 300};
        c[3] = new int[] {5, 500};
        c[4] = new int[] {5, 400};
        c[5] = new int[] {5, 250};
        c[6] = new int[] {6, 370};
        c[7] = new int[] {7, 380};

        System.out.println(maxEnvelopes(c));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        // a b 两个信封如果要套则： a[0] < b[0] && a[1] < b[1]
        // 固定住宽度,在高度上取最长递增子序列
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int res = 0;

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        for (int i = 0, length = envelopes.length; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

}
