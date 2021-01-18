package com.moonlight.algorithm.search;

/**
 * 在字符串S中是否有子串包含字符串M的，如果有返回该子串开头的位置
 * @ClassName KMP
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/18 21:37
 * @Version V1.0
 **/
public class KMP {

    public static void main(String[] args) {
        System.out.println(getIndexOf("aabbcck", "bbc"));
    }

    public static int getIndexOf(String s, String m) {
        if (s == null || s.length() == 0 || m == null || m.length() == 0 || s.length() < m.length()) {
            return -1;
        }
        // 准备一个数组next,承载match字符串第 k 个位置的指标P
        // 指标P是指: 从第 0 个字符到第 k - 1 个字符，前缀和后缀相等的最长长度是多少
        // 注意此处的前缀和后缀都只能取 0 到 k - 2之间，不能取到 k - 1
        // 对 s 和 m 进行匹配，当 s 到 x 位置，m 到 y 位置时，如果s(x) != m(y)，则 m 从next[y]处重新进行匹配
        // 如果next[y] == -1 则说明 m 已经回到了开头的位置，此时必须换 x 向前进了
        char[] sChars = s.toCharArray();
        char[] mChars = m.toCharArray();
        int x = 0, y = 0;
        int[] next = getNextArray(mChars);
        while (x < s.length() && y < m.length()) {
            if (sChars[x] == mChars[y]) {
                x++;
                y++;
            } else if (next[y] == -1) {
                x++;
            } else {
                y = next[y];
            }
        }
        return y == mChars.length ? x - y : -1;
    }

    private static int[] getNextArray(char[] m) {
        if (m.length == 1) {
            return new int[]{-1};
        }
        // 根据定义来的固定值： 0 号下标为 -1，1 号 下标为0
        // cur: 指 i - 1 位置的指标，也指下一次跳转的位置
        // 当 m 来到 i 下标时，如果 i - 1 位置的值和 cur(i - 1的指标)位置相等，则下标 i 的指标 为 i - 1 的指标 + 1
        // 如果不等且cur还能往前跳，那么cur就跳转到指标的指标所在处
        // 假设 i - 1 的指标为 7，下标为 7 的位置的指标为 3，如果 m[i - 1] == m[7]，则 i 的指标为 7 + 1
        // 如果 m[i - 1] != m[7] 且 m[i - 1] == m[3]，则 i 的指标为 3 + 1
        int[] res = new int[m.length];
        res[0] = -1;
        res[1] = 0;
        int i = 2;
        int cur = 0;
        while (i < m.length) {
            if (m[i - 1] == m[cur]) {
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
