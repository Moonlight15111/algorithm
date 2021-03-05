package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/bag-of-tokens/
 *
 * 你的初始 能量 为 P，初始 分数 为 0，只有一包令牌 tokens 。其中 tokens[i] 是第 i 个令牌的值（下标从 0 开始）。
 * 令牌可能的两种使用方法如下：
 *   如果你至少有 token[i] 点 能量 ，可以将令牌 i 置为正面朝上，失去 token[i] 点 能量 ，并得到 1 分 。
 *   如果我们至少有 1 分 ，可以将令牌 i 置为反面朝上，获得 token[i] 点 能量 ，并失去 1 分 。
 * 每个令牌 最多 只能使用一次，使用 顺序不限 ，不需 使用所有令牌。
 * 在使用任意数量的令牌后，返回我们可以得到的最大分数 。
 *
 * 输入：tokens = [100], P = 50  输出：0  解释：无法使用唯一的令牌，因为能量和分数都太少了。
 *
 * 输入：tokens = [100,200], P = 150   输出：1  解释：令牌 0 正面朝上，能量变为 50，分数变为 1 。不必使用令牌 1 ，因为你无法使用它来提高分数。
 *
 * 输入：tokens = [100,200,300,400], P = 200  输出：2
 * 解释：按下面顺序使用令牌可以得到 2 分：
 *   1. 令牌 0 正面朝上，能量变为 100 ，分数变为 1
 *   2. 令牌 3 正面朝下，能量变为 500 ，分数变为 0
 *   3. 令牌 1 正面朝上，能量变为 300 ，分数变为 1
 *   4. 令牌 2 正面朝上，能量变为 0 ，分数变为 2
 *
 * @author Moonlight
 * @date 2021/3/5 10:39
 */
public class BagOfTokens {

    public static void main(String[] args) {
        int[] a = {100}, b = {100, 200}, c = {100, 200, 300, 400};
        System.out.println(bagOfTokensScore(a, 50));
        System.out.println(bagOfTokensScore(b, 150));
        System.out.println(bagOfTokensScore(c, 200));
    }

    public static int bagOfTokensScore(int[] tokens, int P) {
        // 令牌正面朝上的时候，就去找能量最小的令牌
        // 令牌反面朝上的时候，就去找能量最大的令牌
        // 只要能量够，就一直让令牌正面朝上，能量不够了，就看分数够不够，分数够就让令牌反面朝上
        Arrays.sort(tokens);

        if (tokens.length == 0 || P < tokens[0]) {
            return 0;
        }
        int sum = 0;
        for (int t : tokens) {
            sum += t;
        }
        if (P >= sum) {
            return tokens.length;
        }

        int leftPtr = 0, rightPtr = tokens.length - 1, res = 0, score = 0;
        while (score >= 0 && leftPtr <= rightPtr) {
            if (P >= tokens[leftPtr]) {
                P -=tokens[leftPtr];
                score++;
                leftPtr++;
            } else {
                P += tokens[rightPtr];
                score--;
                rightPtr--;
            }
            res = Math.max(res, score);
        }
        return res;
    }

}
