package com.moonlight.algorithm.train.other;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/
 *
 * 给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
 * 注意:
 *   输入只包含小写英文字母。
 *   输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
 *   输入字符串的长度小于 50,000。
 *
 * 输入: "owoztneoer"  输出: "012" (zeroonetwo)
 *
 * 输入: "fviefuro"    输出: "45" (fourfive)
 *
 *
 * @ClassName ReconstructOriginalDigits
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/26 20:27
 * @Version V1.0
 **/
public class ReconstructOriginalDigits {

    public static void main(String[] args) {
        System.out.println(originalDigits("owoztneoer"));
        System.out.println(originalDigits("fviefuro"));
    }

    public static String originalDigits(String s) {
        // 找规律: 字母 z 只在数字 0 出现
        // 字母 w 只在数字 2 出现  u 只在 4 出现  x 只在 6 出现。
        //  g 只在 8 出现
        //  h 只在 3 8 出现
        //  f 只在 4 5 出现
        //  s 只在 7 6 出现
        //  i 在 9 5 6 8 出现
        //  n 在 1 7 出现一次 9 出现两次

        char[] count = new char[26 + (int)'a'];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int[] num = new int[10];
        num[0] = count['z'];
        num[2] = count['w'];
        num[4] = count['u'];
        num[6] = count['x'];
        num[8] = count['g'];
        num[3] = count['h'] - num[8];
        num[5] = count['f'] - num[4];
        num[7] = count['s'] - num[6];
        num[9] = count['i'] - num[5] - num[6] - num[8];
        num[1] = count['n'] - num[7] - num[9] - num[9];
        
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < num[i]; j++) {
                ans.append(i);
            }
        }
        
        return ans.toString();
    }

}
