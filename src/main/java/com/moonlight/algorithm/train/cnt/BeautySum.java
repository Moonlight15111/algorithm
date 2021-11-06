package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode-cn.com/problems/sum-of-beauty-of-all-substrings/
 *
 * 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 *   比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
 * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
 *
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 *
 * 输入：s = "aabcb"  输出：5
 * 解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。
 *
 * 输入：s = "aabcbaa"  输出：17
 *
 * @ClassName BeautySum
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/11/6 12:36
 * @Version V1.0
 **/
public class BeautySum {

    public static void main(String[] args) {
        System.out.println(beautySum("aabcb"));
        System.out.println(beautySum("aabcbaa"));
    }

    public static int beautySum(String s) {
        int len = s.length(), ans = 0, min, max;
        char[] chars = s.toCharArray();
        int[] cnt;
        for (int i = 0; i < len - 2; i++) {
            cnt = new int[26];
            cnt[chars[i] - 'a']++;
            cnt[chars[i + 1] - 'a']++;
            for (int j = i + 2; j < len; j++) {
                cnt[chars[j] - 'a']++;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0) {
                        min = Math.min(min, cnt[k]);
                        max = Math.max(max, cnt[k]);
                    }
                }
                ans += max - min;
            }
        }
        return ans;
    }

}