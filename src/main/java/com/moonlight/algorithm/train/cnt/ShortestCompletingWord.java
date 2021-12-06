package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode-cn.com/problems/shortest-completing-word/
 *
 * 给定一个字符串牌照 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。
 * 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为 补全词 。
 * 在所有完整词中，最短的单词我们称之为 最短补全词 。
 * 单词在匹配牌照中的字母时要：
 *    忽略牌照中的数字和空格。
 *    不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
 *    如果某个字母在牌照中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
 * 例如：licensePlate = "aBc 12c"，那么它由字母 'a'、'b' （忽略大写）和两个 'c' 。
 * 可能的 补全词 是 "abccdef"、"caaacab" 以及 "cbca" 。
 * 题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取单词列表中最靠前的一个。
 *
 * 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * 输出："steps"
 * 说明：最短补全词应该包括 "s"、"p"、"s" 以及 "t"。在匹配过程中我们忽略牌照中的大小写。
 * "step" 包含 "t"、"p"，但只包含一个 "s"，所以它不符合条件。
 * "steps" 包含 "t"、"p" 和两个 "s"。
 * "stripe" 缺一个 "s"。
 * "stepple" 缺一个 "s"。
 * 因此，"steps" 是唯一一个包含所有字母的单词，也是本样例的答案。
 *
 * 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * 输出："pest"
 *
 * 输入：licensePlate = "Ah71752", words = ["suggest","letter","of","husband","easy","education","drug","prevent","writer","old"]
 * 输出："husband"
 *
 * 输入：licensePlate = "OgEu755", words = ["enough","these","play","wide","wonder","box","arrive","money","tax","thus"]
 * 输出："enough"
 *
 * 输入：licensePlate = "iMSlpe4", words = ["claim","consumer","student","camera","public","never","wonder","simple","thought","use"]
 * 输出："simple"
 *
 * @author Moonlight
 */
public class ShortestCompletingWord {

    public static void main(String[] args) {
        String[] a = {"step", "steps", "stripe", "stepple"},
                 b = {"looks", "pest", "stew", "show"},
                 c = {"suggest","letter","of","husband","easy","education","drug","prevent","writer","old"},
                 d = {"enough","these","play","wide","wonder","box","arrive","money","tax","thus"},
                 e = {"claim","consumer","student","camera","public","never","wonder","simple","thought","use"};

        System.out.println(shortestCompletingWord("1s3 PSt", a));
        System.out.println(shortestCompletingWord("1s3 456", b));
        System.out.println(shortestCompletingWord("Ah71752", c));
        System.out.println(shortestCompletingWord("OgEu755", d));
        System.out.println(shortestCompletingWord("iMSlpe4", e));
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        int[] plate = new int[26], temp;
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                plate[c - 'a']++;
            }
        }
        String ans = "";
        for (String s : words) {
            temp = new int[26];
            for (char c : s.toCharArray()) {
                temp[c - 'a']++;
            }
            boolean comp = true;
            for (int i = 0; i < 26; i++) {
                if (plate[i] > temp[i]) {
                    comp = false;
                    break;
                }
            }
            if ((s.length() < ans.length() || ans.length() == 0) && comp) {
                ans = s;
            }
        }
        return ans;
    }

}
