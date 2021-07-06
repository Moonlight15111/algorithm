package com.moonlight.algorithm.train.string;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *    A -> 1
 *    B -> 2
 *    C -> 3
 *    ...
 *    Z -> 26
 *    AA -> 27
 *    AB -> 28
 *    ...
 *
 * 输入: "A"   输出: 1
 *
 * 输入: "AB"  输出: 28
 *
 * 输入: "ZY"  输出: 701
 *
 * @author Moonlight
 * @date 2021/7/6 17:33
 */
public class TitleToNumber {

    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
    }

    public static int titleToNumber(String columnTitle) {
        int ans = 0;
        char[] chars = columnTitle.toCharArray();
        for (int i = 0, num; i < chars.length; i++) {
            num = chars[i] - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }

}
