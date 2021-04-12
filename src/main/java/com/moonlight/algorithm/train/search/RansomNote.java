package com.moonlight.algorithm.train.search;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * <p>
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，
 * 组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * 输入：ransomNote = "a", magazine = "b"   输出：false
 * <p>
 * 输入：ransomNote = "aa", magazine = "ab"  输出：false
 * <p>
 * 输入：ransomNote = "aa", magazine = "aab" 输出：true
 *
 * @author Moonlight
 * @date 2021/4/12 13:21
 */
public class RansomNote {

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] help = new int[26];
        for (char c : magazine.toCharArray()) {
            help[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            help[c - 'a']--;
            if (help[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
