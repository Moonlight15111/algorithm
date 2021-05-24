package com.moonlight.algorithm.train.contest.weeklycontest242;

/**
 * 给你一个二进制字符串 s 。如果字符串中由 1 组成的 最长 连续子字符串 严格长于 由 0 组成的 最长 连续子字符串，返回 true ；否则，返回 false 。
 * 例如，s = "110100010" 中，由 1 组成的最长连续子字符串的长度是 2 ，由 0 组成的最长连续子字符串的长度是 3
 * 注意，如果字符串中不存在 0 ，此时认为由 0 组成的最长连续子字符串的长度是 0 。字符串中不存在 1 的情况也适用此规则。
 *
 * 输入：s = "1101"   输出：true
 * 解释：由 1 组成的最长连续子字符串的长度是 2："1101"
 *       由 0 组成的最长连续子字符串的长度是 1："1101"
 *       由 1 组成的子字符串更长，故返回 true 。
 *
 * 输入：s = "111000"  输出：false
 * 解释：由 1 组成的最长连续子字符串的长度是 3："111000"
 *       由 0 组成的最长连续子字符串的长度是 3："111000"
 *       由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
 *
 * 输入：s = "110100010"   输出：false
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 2："110100010"
 * 由 0 组成的最长连续子字符串的长度是 3："110100010"
 * 由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
 *
 * @ClassName CheckZeroOnes
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/23 10:31
 * @Version V1.0
 **/
public class CheckZeroOnes {

    public static void main(String[] args) {
        System.out.println(checkZeroOnes("1101"));
        System.out.println(checkZeroOnes("111000"));
        System.out.println(checkZeroOnes("110100010"));
        System.out.println(checkZeroOnes("110100010"));
    }

    public static boolean checkZeroOnes(String s) {
        int cntO = 0, cntZ = 0, maxO = 0, maxZ = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '1') {
                cntO++;
                maxZ = Math.max(maxZ, cntZ);
                cntZ = 0;
            } else {
                cntZ++;
                maxO = Math.max(maxO, cntO);
                cntO = 0;
            }
        }
        maxZ = Math.max(maxZ, cntZ);
        maxO = Math.max(maxO, cntO);
        return maxO > maxZ;
    }

}
