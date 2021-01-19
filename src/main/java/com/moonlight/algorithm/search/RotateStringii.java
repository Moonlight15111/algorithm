package com.moonlight.algorithm.search;

/**
 * 给定两个字符串, A 和 B。
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。
 * 请判断A和B是否互为旋转词
 *
 * 输入: A = 'abcde' B = 'deabc'  输出：true
 *
 * @ClassName RotateString
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/19 21:34
 * @Version V1.0
 **/
public class RotateStringii {

    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "deabc"));
        System.out.println(rotateString("aaa", "a"));
    }

    public static boolean rotateString(String A, String B) {
        if (A == null || A.length() == 0 || B == null || B.length() == 0 || A.length() != B.length()) {
            return false;
        }
        String str = A + A;
        int[] next = getNextArray(B.toCharArray());
        int strLen = str.length(), bLen = B.length(), a = 0, b = 0;
        while (a < strLen && b < bLen) {
            if (str.charAt(a) == B.charAt(b)) {
                a++;
                b++;
            } else if (next[b] != -1) {
                b = next[b];
            } else {
                a++;
            }
        }
        return b == bLen;
    }

    private static int[] getNextArray(char[] toCharArray) {
        int length = toCharArray.length;
        if (length == 1) {
            return new int[]{-1};
        }
        int[] res = new int[length];
        res[0] = -1;
        res[1] = 0;
        int i = 2;
        int cur = 0;
        while (i < length) {
            if (toCharArray[i - 1] == toCharArray[cur]) {
                res[i++] = ++cur;
            } else if (cur > 0) {
                cur = res[cur];
            } else {
                res[i++] = 0;
            }
        }
        return res;
    }

}
