package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode-cn.com/problems/find-the-town-judge/
 *
 * 小镇里有 n 个人，按从 1 到 n 的顺序编号。传言称，这些人中有一个暗地里是小镇法官。
 * 如果小镇法官真的存在，那么：
 *    小镇法官不会信任任何人。
 *    每个人（除了小镇法官）都信任这位小镇法官。
 *    只有一个人同时满足属性 1 和属性 2 。
 * 给你一个数组 trust ，其中 trust[i] = [ai, bi] 表示编号为 ai 的人信任编号为 bi 的人。
 * 如果小镇法官存在并且可以确定他的身份，请返回该法官的编号；否则，返回 -1 。
 *
 * 输入：n = 2, trust = [[1,2]]  输出：2
 *
 * 输入：n = 3, trust = [[1,3],[2,3]]  输出：3
 *
 * 输入：n = 3, trust = [[1,3],[2,3],[3,1]]  输出：-1
 *
 * @author Moonlight
 */
public class FindJudge {

    public static void main(String[] args) {
        int[][] a = {
                {1, 2}
        }, b = {
                {1, 3}, {2, 3}
        }, c = {
                {1, 3}, {2, 3}, {3, 1}
        };
        System.out.println(findJudge(2, a));
        System.out.println(findJudge(3, b));
        System.out.println(findJudge(3, c));
    }

    public static int findJudge(int n, int[][] trust) {
        int[] cnt = new int[n + 1];
        for (int[] t : trust) {
            cnt[t[0]]--;
            cnt[t[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

}
