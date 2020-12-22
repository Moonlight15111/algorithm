package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/reverse-bits-lcci/
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 * 输入: num = 1775(110111011112)
 * 输出: 8
 * 输入: num = 7(01112)
 * 输出: 4
 * @author Moonlight
 * @date 2020/12/22 14:54
 */
public class ReverseBitsLongest {

    public static void main(String[] args) {
        System.out.println(reverseBitsLongest(1775));
        System.out.println(reverseBitsLongest(7));
        System.out.println(reverseBitsLongest(2147482622));
        System.out.println(reverseBitsLongest(-1));
    }

    public static int reverseBitsLongest(int num) {
        int pre = 0, cur = 0, maxLen = 0;
        // 判断每一位是否为 1
        // 以前的 + 现在的 + 1 次改变机会 其实就是 0 两边有多少个 1
        for (int i = 0; i < 32; i++) {
            if ((num & 1) != 0) {
                cur++;
            } else {
                pre = cur;
                cur = 0;
            }
            maxLen = Math.max(maxLen, pre + cur + 1);
            num >>= 1;
        }
        return maxLen > 32 ? 32 : maxLen;
    }

}
