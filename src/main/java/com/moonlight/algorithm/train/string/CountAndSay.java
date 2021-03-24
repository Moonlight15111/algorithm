package com.moonlight.algorithm.train.string;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/count-and-say/
 *
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 *   countAndSay(1) = "1"
 *   countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 *
 *   1.     1
 *   2.     11
 *   3.     21
 *   4.     1211
 *   5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 *
 * 输入：n = 4
 * 输出："1211"
 * 解释：
 * countAndSay(1) = "1"
 * countAndSay(2) = 读 "1" = 一 个 1 = "11"
 * countAndSay(3) = 读 "11" = 二 个 1 = "21"
 * countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
 *
 * @author Moonlight
 * @date 2021/3/24 18:21
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        // 当前的结果依赖于上一层的结果
        // 1 个 1 =》 1 - 0 + "1"   2个1 => 2 - 0 + "1"  1个2 => 2 - 1 + "2"
        String prev = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();
        int i = 0;
        for (int j = 1; j < prev.length(); j++) {
            if (prev.charAt(j) != prev.charAt(i)) {
                res.append(j - i).append(prev.charAt(i));
                i = j;
            }
        }
        return res.append(prev.length() - i).append(prev.charAt(i)).toString();
    }

}
