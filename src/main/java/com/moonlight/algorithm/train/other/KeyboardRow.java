package com.moonlight.algorithm.train.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/keyboard-row/
 *
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 *
 * 美式键盘 中：
 *    第一行由字符 "qwertyuiop" 组成。
 *    第二行由字符 "asdfghjkl" 组成。
 *    第三行由字符 "zxcvbnm" 组成。
 *
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 *
 * 输入：words = ["omk"]
 * 输出：[]
 *
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 *
 * @ClassName KeyboardRow
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/3 17:48
 * @Version V1.0
 **/
public class KeyboardRow {

    public static void main(String[] args) {
        String[] a = {"Hello", "Alaska", "Dad", "Peace"}, b = {"omk"}, c = {"adsdf","sfd"};
        System.out.println(Arrays.toString(findWords(a)));
        System.out.println(Arrays.toString(findWords(b)));
        System.out.println(Arrays.toString(findWords(c)));
    }

    public static String[] findWords(String[] words) {
        String[] lines = new String[] {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> ans = new ArrayList<>();
        for (String w : words) {
            for (String l : lines) {
                if (l.indexOf(w.toLowerCase().charAt(0)) > -1 && check(w.toLowerCase(), l)) {
                    ans.add(w);
                    break;
                }
            }
        }
        return ans.toArray(new String[ans.size()]);
    }

    private static boolean check(String w, String l) {
        for (int i = 1; i < w.length(); i++) {
            if (l.indexOf(w.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }

}
