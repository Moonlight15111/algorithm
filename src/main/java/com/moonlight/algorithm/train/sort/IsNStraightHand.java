package com.moonlight.algorithm.train.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/hand-of-straights/
 * <p>
 * 爱丽丝有一手（hand）由整数数组给定的牌。 
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 * 如果她可以完成分组就返回 true，否则返回 false。
 *
 * 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3  输出：true
 * 解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 *
 * 输入：hand = [1,2,3,4,5], W = 4  输出：false
 * 解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 *
 * @author Moonlight
 */
public class IsNStraightHand {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 6, 2, 3, 4, 7, 8}, b = {1, 2, 3, 4, 5};
        System.out.println(isNStraightHand(a, 3));
        System.out.println(isNStraightHand(b, 4));
    }
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand == null || hand.length == 0 || hand.length % groupSize != 0) {
            return false;
        }
        if (groupSize == 1) {
            return true;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : hand) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int cnt = 0;
        for (int n : hand) {
            // 这个牌型已经用完了,不用再试了
            if (map.get(n) <= 0) {
                continue;
            }
            map.put(n, map.get(n) - 1);
            for (int i = 1; i < groupSize; i++) {
                // 如果没有下一个数,那肯定就凑不齐了,直接返回就好
                if (map.getOrDefault(n + i, 0) <= 0) {
                    return false;
                }
                map.put(n + i, map.get(n + i) - 1);
            }
            cnt++;
        }
        return cnt == hand.length / groupSize;
    }

}