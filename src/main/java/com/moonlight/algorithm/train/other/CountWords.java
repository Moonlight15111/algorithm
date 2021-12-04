package com.moonlight.algorithm.train.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/count-common-words-with-one-occurrence/
 *
 * 给你两个字符串数组 words1 和 words2 ，请你返回在两个字符串数组中 都恰好出现一次 的字符串的数目。
 *
 * 1 <= words1.length, words2.length <= 1000
 * 1 <= words1[i].length, words2[j].length <= 30
 * words1[i] 和 words2[j] 都只包含小写英文字母。
 *
 * 输入：words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]  输出：2
 * 解释：
 * - "leetcode" 在两个数组中都恰好出现一次，计入答案。
 * - "amazing" 在两个数组中都恰好出现一次，计入答案。
 * - "is" 在两个数组中都出现过，但在 words1 中出现了 2 次，不计入答案。
 * - "as" 在 words1 中出现了一次，但是在 words2 中没有出现过，不计入答案。
 * 所以，有 2 个字符串在两个数组中都恰好出现了一次。
 *
 * 输入：words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]  输出：0
 * 解释：没有字符串在两个数组中都恰好出现一次。
 *
 * 输入：words1 = ["a","ab"], words2 = ["a","a","a","ab"]  输出：1
 * 解释：唯一在两个数组中都出现一次的字符串是 "ab" 。
 *
 * @ClassName CountWords
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/12/4 13:23
 * @Version V1.0
 **/
public class CountWords {

    public static void main(String[] args) {
        String[] a = {"leetcode", "is", "amazing", "as", "is"},
                 b = {"amazing", "leetcode", "is"},
                 c = {"b", "bb", "bbb"},
                 d = {"a", "aa", "aaa"},
                 e = {"a", "ab"},
                 f = {"a", "a", "a", "ab"};
        System.out.println(countWords(a, b));
        System.out.println(countWords(c, d));
        System.out.println(countWords(e, f));
    }

    public static int countWords(String[] words1, String[] words2) {
        Map<String, Integer> wa = new HashMap<>(), wb = new HashMap<>();
        Set<String> keys = new HashSet<>();

        for (String w : words1) {
            keys.add(w);
            wa.put(w, wa.getOrDefault(w, 0) + 1);
        }

        for (String w : words2) {
            keys.add(w);
            wb.put(w, wb.getOrDefault(w, 0) + 1);
        }

        int ans = 0;
        for (String k : keys) {
            if (wa.getOrDefault(k, 0) == 1 && wb.getOrDefault(k, 0) == 1) {
                ans++;
            }
        }
        return ans;
    }

}
