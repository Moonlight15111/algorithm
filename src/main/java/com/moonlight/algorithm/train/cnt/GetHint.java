package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode-cn.com/problems/bulls-and-cows/
 *
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 *
 * 你写出一个秘密数字，并请朋友猜这个数字是多少。
 * 朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了（称为“Bulls”, 公牛），
 * 有多少位属于数字猜对了但是位置不对（称为“Cows”, 奶牛）。
 * 朋友根据提示继续猜，直到猜出秘密数字。
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用 B 表示奶牛。
 *    xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
 *    yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。
 *
 * 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
 *
 * 输入: secret = "1807", guess = "7810"  输出: "1A3B"
 *
 * 输入: secret = "1123", guess = "0111"  输出: "1A1B"
 *
 * @author Moonlight
 */
public class GetHint {

    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
    }

    public static String getHint(String secret, String guess) {
        int[] cnt = new int[10];
        int len = secret.length(), b = 0, c = 0;
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                b++;
            }
            cnt[secret.charAt(i) - '0']++;
        }
        for (int i = 0; i < len; i++) {
            int g = guess.charAt(i) - '0';
            if (cnt[g] > 0) {
                cnt[g]--;
                c++;
            }
        }
        return b + "A" + (c - b) + "B";
    }

}