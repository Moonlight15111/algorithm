import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shortest-distance-to-a-character
 *
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 *
 * 输入：s = "loveleetcode", c = "e"
 * 输出：[3,2,1,0,1,0,0,1,2,2,1,0]
 * 解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
 * 距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
 * 距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
 * 对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
 * 距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
 *
 * 输入：s = "aaab", c = "b"
 * 输出：[3,2,1,0]
 *
 */
public class ShortestToChar {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bigOnSeq("loveleetcode", 'e')));
        System.out.println(Arrays.toString(bigOnSeq("aaab", 'b')));

        System.out.println(Arrays.toString(bigOn("loveleetcode", 'e')));
        System.out.println(Arrays.toString(bigOn("aaab", 'b')));
    }

    public static int[] bigOn(String s, char c) {
        int len = s.length();
        int[] ans = new int[len];
        int p = Integer.MAX_VALUE;
        // 记录上一个 c 出现的位置
        // 对于两侧的字符，就使用从左往右扫一次，然后再从右往左扫一次
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                p = i;
            }
            ans[i] = Math.abs(i - p);
        }

        p = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0 ; i--) {
            if (s.charAt(i) == c) {
                p = i;
            }
            ans[i] = Math.min(ans[i], Math.abs(i - p));
        }

        return ans;
    }

    public static int[] bigOnSeq(String s, char c) {
        int len = s.length();
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                ans[i] = 0;
                continue;
            }
            int r = Integer.MAX_VALUE, l = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                if (s.charAt(j) == c) {
                    r = j;
                    break;
                }
            }
            for (int j = i; j >= 0; j--) {
                if (s.charAt(j) == c) {
                    l = j;
                    break;
                }
            }
            ans[i] = Math.min(Math.abs(l - i), Math.abs(r - i));
        }

        return ans;
    }

}
