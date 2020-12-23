package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/utf-8-validation/
 * 给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。
 * 注意:
 * 输入是整数数组。只有每个整数的最低 8 个有效位用来存储数据。这意味着每个整数只表示 1 字节的数据。
 *
 * data = [197, 130, 1], 表示 8 位的序列: 11000101 10000010 00000001.
 * 返回 true 。 这是有效的 utf-8 编码，为一个2字节字符，跟着一个1字节字符。
 *
 * data = [235, 140, 4], 表示 8 位的序列: 11101011 10001100 00000100.
 * 返回 false 。前 3 位都是 1 ，第 4 位为 0 表示它是一个3字节字符。
 * 下一个字节是开头为 10 的延续字节，这是正确的。
 * 但第二个延续字节不以 10 开头，所以是不符合规则的。
 * @author Moonlight
 * @date 2020/12/23 14:48
 */
public class ValidUtf8 {

    public static void main(String[] args) {
        int[] arr = {197, 130, 1};
        System.out.println(validUtf8(arr));

        int[] arr222 = {235, 140, 4};
        System.out.println(validUtf8(arr222));

        int[] arr33 = {255};
        System.out.println(validUtf8(arr33));

        int[] arr55 = {250, 145, 145, 145, 145};
        System.out.println(validUtf8(arr55));

        int[] arr66 = {228, 189, 160, 229, 165, 189, 13, 10};
        System.out.println(validUtf8(arr66));
    }

    public static boolean validUtf8(int[] data) {
        int i = 0, len = data.length;
        while (i < len) {
            int mark = 0x80, utf8CharCount = 0;

            // 当前这一组UTF8有多少字节
            while ((mark & data[i]) != 0) {
                mark >>= 1;
                utf8CharCount++;
            }
            i++;

            // 当前这一组UTF8字节数量最多能取到哪里
            int k = i + utf8CharCount - 1;
            // utf8: == 0 || (> 1 && <= 4)
            if (utf8CharCount == 1 || utf8CharCount > 4 || k > len) {
                return false;
            }

            while (i < k) {
                if ((data[i] & 0x80) == 0 || (data[i] & 0x40) != 0) {
                    return false;
                }
                i ++;
            }
        }
        return true;
    }

}
