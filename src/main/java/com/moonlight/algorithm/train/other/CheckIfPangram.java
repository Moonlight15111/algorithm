package com.moonlight.algorithm.train.other;

/**
 * https://leetcode-cn.com/contest/weekly-contest-237/problems/check-if-the-sentence-is-pangram/
 *
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 * 如果是，返回 true ；否则，返回 false 。
 *
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"  输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 *
 * 输入：sentence = "leetcode"  输出：false
 *
 * @ClassName CheckIfPangram
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/18 10:35
 * @Version V1.0
 **/
public class CheckIfPangram {

    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(checkIfPangram("leetcode"));
    }

    public static boolean checkIfPangram(String sentence) {
        int[] help = new int[26];
        for (char c : sentence.toCharArray()) {
            help[c - 'a']++;
        }
        for (int n : help) {
            if (n == 0) {
                return false;
            }
        }
        return true;
    }

}
