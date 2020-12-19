package com.moonlight.algorithm.train.bitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/letter-case-permutation/submissions/
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 * 输入：S = "12345"
 * 输出：["12345"]
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 * @author Moonlight
 * @date 2020/12/19 14:08
 */
public class LetterCasePermutation {

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
        System.out.println(letterCasePermutation("3z4"));
        System.out.println(letterCasePermutation("12345"));
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        // 1. A - Z => 65-90  a - z => 97-122
        backtrack(0, s.toCharArray(), result);

        return result;
    }

    private static void backtrack(int i, char[] source, List<String> res) {
        if (i == source.length) {
            res.add(new String(source));
            return;
        }

        backtrack(i + 1, source, res);

        if (source[i] >= 65 && source[i] <= 90) {
            source[i] += 32;
            backtrack(i + 1, source, res);
        } else if (source[i] >= 97 && source[i] <= 122) {
            source[i] -= 32;
            backtrack(i + 1, source, res);
        }
    }

}
