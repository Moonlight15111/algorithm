package com.moonlight.algorithm.train.string;

/**
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * 例如:
 *   A -> 1
 *   B -> 2
 *   C -> 3
 *   ...
 *   Z -> 26
 *   AA -> 27
 *   AB -> 28
 *   ...
 *
 * 输入：columnNumber = 1   输出："A"
 *
 * 输入：columnNumber = 28  输出："AB"
 *
 * 输入：columnNumber = 701  输出："ZY"
 *
 * 输入：columnNumber = 2147483647   输出："FXSHRXW"
 *
 * https://leetcode-cn.com/problems/excel-sheet-column-title/
 * @author Moonlight
 * @date 2021/7/6 17:01
 */
public class ConvertToTitle {

    public static void main(String[] args) {
        // 65 <==> 1  90 <==> 26
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(2147483647));
    }

    public static String convertToTitle(int columnNumber) {
        if (columnNumber <= 26) {
            return String.valueOf(getChar(--columnNumber));
        }
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0) {
            ans.append(getChar((--columnNumber) % 26));
            columnNumber /= 26;
        }
        return ans.reverse().toString();
    }

    private static char getChar(int columnNumber) {
        return (char)(columnNumber + 'A');
    }

}
