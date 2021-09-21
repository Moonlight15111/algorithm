package com.moonlight.algorithm.train.backtrack;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/stickers-to-spell-word/
 * <p>
 * 我们给出了 N 种不同类型的贴纸。每个贴纸上都有一个小写的英文单词。
 * 你希望从自己的贴纸集合中裁剪单个字母并重新排列它们，从而拼写出给定的目标字符串 target。
 * 如果你愿意的话，你可以不止一次地使用每一张贴纸，而且每一张贴纸的数量都是无限的。
 * 拼出目标 target 所需的最小贴纸数量是多少？如果任务不可能，则返回 -1。
 * <p>
 * ["with", "example", "science"], "thehat"
 * 3
 * 我们可以使用 2 个 "with" 贴纸，和 1 个 "example" 贴纸。
 * 把贴纸上的字母剪下来并重新排列后，就可以形成目标 “thehat“ 了。
 * 此外，这是形成目标字符串所需的最小贴纸数量。
 * 示例 2：
 * <p>
 * ["notice", "possible"], "basicbasic"
 * -1
 * 我们不能通过剪切给定贴纸的字母来形成目标“basicbasic”。
 * <p>
 * stickers 长度范围是 [1, 50]。
 * stickers 由小写英文单词组成（不带撇号）。
 * target 的长度在 [1, 15] 范围内，由小写字母组成。
 * 在所有的测试案例中，所有的单词都是从 1000 个最常见的美国英语单词中随机选取的，目标是两个随机单词的串联。
 * 时间限制可能比平时更具挑战性。预计 50 个贴纸的测试案例平均可在35ms内解决。
 *
 * @ClassName MinStickers
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/9/21 11:03
 * @Version V1.0
 **/
public class MinStickers {

    public static void main(String[] args) {
        String[] a = {"with", "example", "science"}, b = {"notice", "possible"};
        System.out.println(minStickers(a, "thehat"));
        System.out.println(minStickers(b, "basicbasic"));
    }



    public static int minStickers(String[] stickers, String target) {
        int len = stickers.length;
        int[][] sCnt = new int[len][26];
        for (int i = 0; i < len; i++) {
            char[] chars = stickers[i].toCharArray();
            for (char c : chars) {
                sCnt[i][c - 'a']++;
            }
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("", 0);
        int ans = cache(sCnt, target, map);
        return ans == Integer.MAX_VALUE ? -1 : ans;
        // still timeout
//        int ans = wordCnt(sCnt, target);
//        return ans == Integer.MAX_VALUE ? -1 : ans;
        // timeout
//        int ans = min(stickers, target);
//        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static int cache(int[][] stickers, String target, Map<String, Integer> map) {
//        if (target.length() == 0) {
//            return 0;
//        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        int[] cnt = new int[26];
        for (char c : target.toCharArray()) {
            cnt[c - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int[] scnt : stickers) {
            if (scnt[target.charAt(0) - 'a'] > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    if (cnt[i] > 0) {
                        int n = cnt[i] - scnt[i];
                        for (int j = 0; j < n; j++) {
                            sb.append((char)(i + 'a'));
                        }
                    }
                }
                String rest = sb.toString();
                min = Math.min(min, cache(stickers, rest, map));
            }
        }
        int ans = min + (min == Integer.MAX_VALUE ? 0 : 1);
        map.put(target, ans);
        return ans;
    }

    private static int wordCnt(int[][] stickers, String target) {
        // still timeout
        if (target.length() == 0) {
            return 0;
        }
        int[] cnt = new int[26];
        for (char c : target.toCharArray()) {
            cnt[c - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int[] scnt : stickers) {
            if (scnt[target.charAt(0) - 'a'] > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    if (cnt[i] > 0) {
                        int n = cnt[i] - scnt[i];
                        for (int j = 0; j < n; j++) {
                            sb.append((char)(i + 'a'));
                        }
                    }
                }
                String rest = sb.toString();
                min = Math.min(min, wordCnt(stickers, rest));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    private static int min(String[] stickers, String target) {
        if (target.length() == 0) {
            return 0;
        }
        int r = Integer.MAX_VALUE;
        for (String s : stickers) {
            String rest = findRest(s, target);
            if (rest.length() != target.length()) {
                r = Math.min(r, min(stickers, rest));
            }
        }
        // + 1 是因为第一张贴纸其实还没有算到结果里面去
        return r + (r == Integer.MAX_VALUE ? 0 : 1);
    }

    private static String findRest(String stick, String target) {
        char[] s = stick.toCharArray(), t = target.toCharArray();
        int[] cnt = new int[26];
        for (char c : t) {
            cnt[c - 'a']++;
        }
        for (char c : s) {
            cnt[c - 'a']--;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                for (int j = 0; j < cnt[i]; j++) {
                    ans.append((char) (i + 'a'));
                }
            }
        }
        return ans.toString();
    }


}
