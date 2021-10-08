package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * https://leetcode-cn.com/problems/merge-strings-alternately/
 *
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。
 * 如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * 返回 合并后的字符串 。
 *
 * 输入：word1 = "abc", word2 = "pqr"
 * 输出："apbqcr"
 * 解释：字符串合并情况如下所示：
 * word1：  a   b   c
 * word2：    p   q   r
 * 合并后：  a p b q c r
 *
 * 输入：word1 = "ab", word2 = "pqrs"
 * 输出："apbqrs"
 * 解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
 * word1：  a   b
 * word2：    p   q   r   s
 * 合并后：  a p b q   r   s
 *
 * @ClassName MergeAlternately
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/8 21:45
 * @Version V1.0
 **/
public class MergeAlternately {

    public static void main(String[] args){
        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));
        System.out.println(mergeAlternately("abcd", "pq"));
    }

    public static String mergeAlternately(String word1, String word2) {
        int n = word1.length(), m = word2.length(), idx = 0;
        char[] nChars = word1.toCharArray(), mChars = word2.toCharArray(), ans = new char[n + m];

        for (int i = 0; i < n || i < m; i++) {
            if (i < n) {
                ans[idx++] = nChars[i];
            }
            if (i < m) {
                ans[idx++] = mChars[i];
            }
        }

        return new String(ans);
    }

}
