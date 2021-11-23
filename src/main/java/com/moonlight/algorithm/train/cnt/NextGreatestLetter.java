package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 *
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。
 * 另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * 在比较时，字母是依序循环出现的。举个例子：
 *   如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 *
 * letters长度范围在[2, 10000]区间内。
 * letters 仅由小写字母组成，最少包含两个不同的字母。
 * 目标字母target 是一个小写字母。
 *
 * 输入:  letters = ["c", "f", "j"]  target = "a"  输出: "c"
 *
 * 输入:  letters = ["c", "f", "j"]  target = "c"  输出: "f"
 *
 * 输入:  letters = ["c", "f", "j"]  target = "d"  输出: "f"
 *
 * 输入:  letters = ["c", "f", "j"]  target = "g"  输出: "j"
 *
 * 输入:  letters = ["c", "f", "j"]  target = "j"  输出: "c"
 *
 * 输入:  letters = ["c", "f", "j"]  target = "k"  输出: "c"
 *
 * @author Moonlight
 */
public class NextGreatestLetter {

    public static void main(String[] args) {
        char[] c = {'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(c, 'a') + ", " + search(c, 'a'));
        System.out.println(nextGreatestLetter(c, 'c') + ", " + search(c, 'c'));
        System.out.println(nextGreatestLetter(c, 'd') + ", " + search(c, 'd'));
        System.out.println(nextGreatestLetter(c, 'g') + ", " + search(c, 'g'));
        System.out.println(nextGreatestLetter(c, 'j') + ", " + search(c, 'j'));
        System.out.println(nextGreatestLetter(c, 'k') + ", " + search(c, 'k'));
    }

    public static char search(char[] letters, char target) {
        int left = 0, right = letters.length, mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return letters[left % letters.length];
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int[] cnt = new int[26];
        for (char c : letters) {
            cnt[c - 'a']++;
        }

        while (true) {
            target++;
            if (target > 'z') {
                target = 'a';
            }
            if (cnt[target - 'a'] > 0) {
                return target;
            }
        }
    }

}