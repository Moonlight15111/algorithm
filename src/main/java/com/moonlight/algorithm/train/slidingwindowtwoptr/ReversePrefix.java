package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * https://leetcode-cn.com/problems/reverse-prefix-of-word/
 *
 * 给你一个下标从 0 开始的字符串 word 和一个字符 ch 。找出 ch 第一次出现的下标 i ，反转 word 中从下标 0 开始、
 * 直到下标 i 结束（含下标 i ）的那段字符。如果 word 中不存在字符 ch ，则无需进行任何操作。
 * 例如，如果 word = "abcdefd" 且 ch = "d" ，那么你应该 反转 从下标 0 开始、直到下标 3 结束（含下标 3 ）。结果字符串将会是 "dcbaefd" 。
 * 返回 结果字符串 。
 *
 * 输入：word = "abcdefd", ch = "d"  输出："dcbaefd"
 * 解释："d" 第一次出现在下标 3 。
 * 反转从下标 0 到下标 3（含下标 3）的这段字符，结果字符串是 "dcbaefd" 。
 *
 * 输入：word = "xyxzxe", ch = "z"  输出："zxyxxe"
 * 解释："z" 第一次也是唯一一次出现是在下标 3 。
 * 反转从下标 0 到下标 3（含下标 3）的这段字符，结果字符串是 "zxyxxe" 。
 *
 * 输入：word = "abcd", ch = "z"  输出："abcd"
 * 解释："z" 不存在于 word 中。
 * 无需执行反转操作，结果字符串是 "abcd" 。
 *
 * 1 <= word.length <= 250
 * word 由小写英文字母组成
 * ch 是一个小写英文字母
 *
 * @ClassName ReversePrefix
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/10 12:30
 * @Version V1.0
 **/
public class ReversePrefix {

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
        System.out.println(reversePrefix("xyxzxe", 'z'));
        System.out.println(reversePrefix("abcd", 'z'));
    }

    public static String reversePrefix(String word, char ch) {
        String t = String.valueOf(ch);
        if (!word.contains(t)) {
            return word;
        }
        StringBuilder ans = new StringBuilder();
        String a = word.substring(0, word.indexOf(t) + 1);
        for (int i = a.length() - 1; i >= 0; i--) {
            ans.append(a.charAt(i));
        }
        ans.append(word.substring(word.indexOf(t) + 1));
        return ans.toString();
    }

}
