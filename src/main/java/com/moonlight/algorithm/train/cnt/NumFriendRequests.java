package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode-cn.com/problems/friends-of-appropriate-ages/
 *
 * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
 *
 * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
 *    1. age[y] <= 0.5 * age[x] + 7
 *    2. age[y] > age[x]
 *    3. age[y] > 100 && age[x] < 100
 * 否则，x 将会向 y 发送一条好友请求。
 * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
 * 返回在该社交媒体网站上产生的好友请求总数。
 *
 * 输入：ages = [16,16]  输出：2
 * 解释：2 人互发好友请求。
 *
 * 输入：ages = [16,17,18]  输出：2
 * 解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
 *
 * 输入：ages = [20,30,100,110,120]  输出：3
 * 解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
 *
 * @author Moonlight
 */
public class NumFriendRequests {

    public static void main(String[] args) {
        System.out.println(numFriendRequests(new int[]{16, 16}));
        System.out.println(numFriendRequests(new int[]{16, 17, 18}));
        System.out.println(numFriendRequests(new int[]{20, 30, 100, 110, 120}));
    }

    public static int numFriendRequests(int[] ages) {
        int[] cnt = new int[121], preSum = new int[121];
        for (int a : ages) {
            cnt[a]++;
        }
        for (int i = 1; i < 121; i++) {
            preSum[i] = preSum[i - 1] + cnt[i];
        }
        int ans = 0;
        for (int a : ages) {
            ans += Math.max(0, preSum[a] - preSum[a / 2 + 7] - 1);
        }
        return ans;
    }

}
