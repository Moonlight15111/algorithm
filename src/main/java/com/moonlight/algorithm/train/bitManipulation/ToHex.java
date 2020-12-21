package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/submissions/
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * 输入:  26
 * 输出: "1a"
 * 输入: -1
 * 输出: "ffffffff"
 * @author Moonlight
 * @date 2020/12/21 17:35
 */
public class ToHex {

    public static void main(String[] args) {
        System.out.println(toHex(26));
        System.out.println(toHex(-1));
        System.out.println(toHex222(26));
        System.out.println(toHex222(-1));
    }

    public static String toHex222(int num) {
        if (num == 0) {
            return "0";
        }

        String[] hexs = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

        StringBuilder res = new StringBuilder("");

        int x;
        while (num != 0) {
            x = num & 0x0000000f;
            res.append(hexs[x]);
            num >>>= 4;
        }

        return res.reverse().toString();
    }

    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        String[] hexs = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

        String res = hexs[((num & 0xf0000000) >>> 28)];
        res += hexs[((num & 0x0f000000) >>> 24)];
        res += hexs[((num & 0x00f00000) >>> 20)];
        res += hexs[((num & 0x000f0000) >>> 16)];
        res += hexs[((num & 0x0000f000) >>> 12)];
        res += hexs[((num & 0x00000f00) >>> 8)];
        res += hexs[((num & 0x000000f0) >>> 4)];
        res += hexs[(num & 0x0000000f)];

        return res;
    }

}
