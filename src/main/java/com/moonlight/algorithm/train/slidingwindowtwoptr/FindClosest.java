package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/find-closest-lcci/
 *
 * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
 * 如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 *
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 *
 * @author Moonlight
 * @date 2021/3/4 17:21
 */
public class FindClosest {

    public static void main(String[] args) {
        String[] a = {"I","am","a","student","from","a","university","in","a","city"};
        System.out.println(findClosest(a, "a", "student"));
    }

    public static int findClosest(String[] words, String word1, String word2) {
        // 逐个遍历单次,并分别记录下word1、word2的所在位置，然后不断更新两个指针，取最小差值
        int res = Integer.MAX_VALUE, word1Index = Integer.MAX_VALUE, word2Index = Integer.MAX_VALUE;
        for (int i = 0, len = words.length; i < len; i++) {
            if (words[i].equals(word1)) {
                word1Index = i;
            }
            if (words[i].equals(word2)) {
                word2Index = i;
            }
            if (word1Index == Integer.MAX_VALUE || word2Index == Integer.MAX_VALUE) {
                continue;
            }
            res = Math.min(res, Math.abs(word2Index - word1Index));

            if (res == 1) {
                return 1;
            }
        }
        return res;
    }

}
