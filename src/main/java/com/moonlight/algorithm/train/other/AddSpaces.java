package com.moonlight.algorithm.train.other;

/**
 * https://leetcode-cn.com/problems/adding-spaces-to-a-string/
 *
 * 给你一个下标从 0 开始的字符串 s ，以及一个下标从 0 开始的整数数组 spaces 。
 * 数组 spaces 描述原字符串中需要添加空格的下标。每个空格都应该插入到给定索引处的字符值 之前 。
 * 例如，s = "EnjoyYourCoffee" 且 spaces = [5, 9] ，那么我们需要在 'Y' 和 'C' 之前添加空格，
 * 这两个字符分别位于下标 5 和下标 9 。因此，最终得到 "Enjoy Your Coffee" 。
 * 请你添加空格，并返回修改后的字符串。
 *
 * 输入：s = "LeetcodeHelpsMeLearn", spaces = [8,13,15]
 * 输出："Leetcode Helps Me Learn"
 * 解释：下标 8、13 和 15 对应 "LeetcodeHelpsMeLearn" 中加粗斜体字符。
 *       接着在这些字符前添加空格。
 *
 * 输入：s = "icodeinpython", spaces = [1,5,7,9]
 * 输出："i code in py thon"
 * 解释：下标 1、5、7 和 9 对应 "icodeinpython" 中加粗斜体字符。
 *       接着在这些字符前添加空格。
 *
 * 输入：s = "spacing", spaces = [0,1,2,3,4,5,6]
 * 输出：" s p a c i n g"
 * 解释：字符串的第一个字符前可以添加空格。
 *
 * @author Moonlight
 */
public class AddSpaces {

    public static void main(String[] args) {
        System.out.println(addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13, 15}));
        System.out.println(addSpaces("icodeinpython", new int[]{1, 5, 7, 9}));
        System.out.println(addSpaces("spacing", new int[]{0, 1, 2, 3, 4, 5, 6}));
    }

    public static String addSpaces(String s, int[] spaces) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0, j = 0; i < s.length(); i++) {
            if (j < spaces.length && i == spaces[j]) {
                ans.append(" ");
                j++;
            }
            ans.append(s.charAt(i));
        }

        return ans.toString();
    }

}
