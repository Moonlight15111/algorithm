package com.moonlight.algorithm.train.string;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 *
 * 输入:  bits = [1, 0, 0]     输出: True
 * 解释: 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 *
 * 输入:  bits = [1, 1, 1, 0]    输出: False
 * 解释:  唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
 *
 * @author Moonlight
 * @date 2021/1/18 11:57
 */
public class IsOneBitCharacter {

    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(isOneBitCharacter(new int[]{1, 0, 1, 0}));
        System.out.println(isOneBitCharacter(new int[]{1, 1, 0}));
    }

    public static boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) {
            return false;
        }
        if (bits.length == 1) {
            return bits[0] == 0;
        }
        // 从输入的数据可以发现，当倒数第二位为1且它前面连续的1的个数为奇数时，整个串最后一个字符必不是一比特字符
        int numOneCount = 0;
        int i = bits.length - 2;
        while (i >= 0 && bits[i] == 1) {
            i--;
            numOneCount++;
        }
        return numOneCount % 2 == 0;
    }

}
