package com.moonlight.algorithm.train.bitManipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/repeated-dna-sequences/
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 * @author Moonlight
 * @date 2020/12/22 11:23
 */
public class FindRepeatedDnaSequences {

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));

        System.out.println(findRepeatedDnaSequences2222("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(findRepeatedDnaSequences2222("AAAAAAAAAAA"));
    }

    public static List<String> findRepeatedDnaSequences2222(String s) {
        Set<String> result = new HashSet<>();
        Set<String> hashSet = new HashSet<>();

        // 用两个HashSet来承载子串 出现多余一次的扔到result Set里面去
        String t;
        for (int i = 0, length = s.length(); i <= length - 10; i++) {
            t = s.substring(i, i + 10);
            if (hashSet.contains(t)) {
                result.add(t);
            } else {
                hashSet.add(t);
            }
        }

        return new ArrayList<>(result);
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();

        // 直接两个for循环，暴力破解   但是会超时
        for (int i = 0, length = s.length(); i <= length - 10; i++) {
            for (int j = i + 1; j <= length - 10; j++) {
                if (s.substring(i, i + 10).equals(s.substring(j, j + 10))) {
                    result.add(s.substring(i, i + 10));
                }
            }
        }

        return new ArrayList<>(result);
    }

}
