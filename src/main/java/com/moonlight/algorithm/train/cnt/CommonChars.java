package com.moonlight.algorithm.train.cnt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-common-characters/
 *
 * 给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），
 * 并以数组形式返回。你可以按 任意顺序 返回答案。
 *
 * 输入：words = ["bella","label","roller"]  输出：["e","l","l"]
 *
 * 输入：words = ["cool","lock","cook"] 输出：["c","o"]
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] 由小写英文字母组成
 *
 * @ClassName CommonChars
 * @Description: TODO
 * @Author Moonlight
 * @Date 2022/1/3 11:37
 * @Version V1.0
 **/
public class CommonChars {

    public static void main(String[] args) {
        String[] a = {"bella", "label", "roller"}, b = {"cool", "lock", "cook"};
        System.out.println(commonChars(a));
        System.out.println(commonChars(b));
    }

    public static List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        if (words.length > 0) {
            int[] minCnt = new int[26], cnt;
            Arrays.fill(minCnt, Integer.MAX_VALUE);
            for (String w : words) {
                cnt = new int[26];
                for (char c : w.toCharArray()) {
                    cnt[c - 'a']++;
                }
                for (int i = 0; i < 26; i++) {
                    minCnt[i] = Math.min(cnt[i], minCnt[i]);
                }
            }
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < minCnt[i]; j++) {
                    ans.add(String.valueOf((char)(i + 'a')));
                }
            }
        }
        return ans;
    }

}
