package com.moonlight.algorithm.train.other;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/repeated-dna-sequences/
 *
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"  输出：["AAAAACCCCC","CCCCCAAAAA"]
 *
 * 输入：s = "AAAAAAAAAAAAA"  输出：["AAAAAAAAAA"]
 *
 * @ClassName FindRepeatedDnaSequences
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/8 21:28
 * @Version V1.0
 **/
public class FindRepeatedDnaSequences {

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() <= 10) {
            return ans;
        }
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, 10 + i);
            m.put(substring, m.getOrDefault(substring, 0) + 1);
            if (m.get(substring) == 2) {
                ans.add(substring);
            }
        }

        return ans;
    }
}
