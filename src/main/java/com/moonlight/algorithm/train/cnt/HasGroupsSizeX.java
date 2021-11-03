package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
 *
 * 给定一副牌，每张牌上都写着一个整数。
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *   每组都有 X 张牌。
 *   组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 *
 * 输入：[1,2,3,4,4,3,2,1]  输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 *
 * 输入：[1,1,1,2,2,2,3,3]  输出：false
 * 解释：没有满足要求的分组。
 *
 * 输入：[1]  输出：false
 *
 * 输入：[1,1]  输出：true
 *
 * 输入：[1,1,2,2,2,2]  输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 *
 * @author Moonlight
 */
public class HasGroupsSizeX {

    public  static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 4, 3, 2, 1}, b = {1, 1, 1, 2, 2, 2, 3, 3}, c = {1}, d = {1, 1}, e = {1, 1, 2, 2, 2, 2};
        System.out.println(hasGroupsSizeX(a));
        System.out.println(hasGroupsSizeX(b));
        System.out.println(hasGroupsSizeX(c));
        System.out.println(hasGroupsSizeX(d));
        System.out.println(hasGroupsSizeX(e));
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        int max = 0;
        for (int n : deck) {
            max = Math.max(n, max);
        }

        int[] cnt = new int[max + 1];
        for (int n : deck) {
            cnt[n]++;
        }

        int ans = 0;
        for (int n : cnt) {
            if (n > 0) {
                ans = gys(n, ans);
            }
        }
        return ans >= 2;
    }

    private static int gys(int n, int ans) {
        return ans == 0 ? n : gys(ans, n % ans);
    }

}