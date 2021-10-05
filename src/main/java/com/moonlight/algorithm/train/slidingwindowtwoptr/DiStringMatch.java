package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/di-string-match/
 *
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 *     如果 S[i] == "I"，那么 A[i] < A[i+1]
 *     如果 S[i] == "D"，那么 A[i] > A[i+1]
 *
 * 输入："IDID"  输出：[0,4,1,3,2]
 *
 * 输入："III"   输出：[0,1,2,3]
 *
 * 输入："DDI"   输出：[3,2,0,1]
 *
 * @ClassName DiStringMatch
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/5 12:05
 * @Version V1.0
 **/
public class DiStringMatch {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch("IDID")));
        System.out.println(Arrays.toString(diStringMatch("III")));
        System.out.println(Arrays.toString(diStringMatch("DDI")));
    }

    public static int[] diStringMatch(String s) {
        int len = s.length(), l = 0, r = len;
        int[] ans = new int[len + 1];
        char[] chars = s.toCharArray();

        for (int i = 0; i < len; i++) {
            if (chars[i] == 'D') {
                ans[i] = r--;
            } else {
                ans[i] = l++;
            }
        }
        ans[len] = l;
        return ans;
    }

}
