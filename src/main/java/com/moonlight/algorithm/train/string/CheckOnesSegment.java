package com.moonlight.algorithm.train.string;

/**
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 *
 * 如果 s 最多包含 一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。
 *
 * 输入：s = "1001"
 * 输出：false
 * 解释：字符串中的 1 没有形成一个连续字段。
 *
 * 输入：s = "110"
 * 输出：true
 *
 * @ClassName CheckOnesSegment
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/7 11:09
 * @Version V1.0
 **/
public class CheckOnesSegment {

    public static void main(String[] args) {
        System.out.println(checkOnesSegment("1001"));
        System.out.println(checkOnesSegment("110"));
    }

    public static boolean checkOnesSegment(String s) {
        if (!s.contains("0")) {
            return true;
        }
        boolean findZero = false;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                findZero = true;
            }
            if (findZero && c == '1') {
                return false;
            }
        }

        return true;
    }

}
