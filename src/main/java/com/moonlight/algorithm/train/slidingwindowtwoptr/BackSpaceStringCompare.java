package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Objects;
import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/backspace-string-compare/
 * <p>
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。
 * # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 输入：S = "ab#c", T = "ad#c"   输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * <p>
 * 输入：S = "ab##", T = "c#d#"   输出：true
 * 解释：S 和 T 都会变成 “”。
 * <p>
 * 输入：S = "a##c", T = "#a#c"   输出：true
 * 解释：S 和 T 都会变成 “c”。
 * <p>
 * 输入：S = "a#c", T = "b"    输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 * @author Moonlight
 * @date 2021/3/4 14:14
 */
public class BackSpaceStringCompare {

    public static void main(String[] args) {
        System.out.println(backspaceCompareStack("ab#c", "ad#c") + ", " + backspaceCompareTwoPtr("ab#c", "ad#c"));
        System.out.println(backspaceCompareStack("ab##", "c#d#") + ", " + backspaceCompareTwoPtr("ab##", "c#d#"));
        System.out.println(backspaceCompareStack("a##c", "#a#c") + ", " + backspaceCompareTwoPtr("a##c", "#a#c"));
        System.out.println(backspaceCompareStack("a#c", "") + ", " + backspaceCompareTwoPtr("a#c", ""));
        System.out.println(backspaceCompareStack("xywrrmp", "xywrrmu#p") + ", " + backspaceCompareTwoPtr("xywrrmp", "xywrrmu#p"));
    }

    public static boolean backspaceCompareTwoPtr(String S, String T) {
        int sPtr = S.length() - 1, sBackSpace = 0, tPtr = T.length() - 1, tBackSpace = 0;
        // 双指针，从后往前遍历
        // 遇到 # 就多往前走一步, 逐个匹配每个字符是否一致
        while (sPtr >= 0 || tPtr >= 0) {
            while (sPtr >= 0) {
                if (S.charAt(sPtr) == '#') {
                    sBackSpace++;
                    sPtr--;
                } else if (sBackSpace > 0) {
                    sBackSpace--;
                    sPtr--;
                } else {
                    break;
                }
            }
            while (tPtr >= 0) {
                if (T.charAt(tPtr) == '#') {
                    tBackSpace++;
                    tPtr--;
                } else if (tBackSpace > 0) {
                    tBackSpace--;
                    tPtr--;
                } else {
                    break;
                }
            }
            // 1.字符不匹配  2.一方已经遍历完了，但是另一方还有字符待匹配
            if ((sPtr >= 0 && tPtr >= 0 && S.charAt(sPtr) != T.charAt(tPtr)) || ((sPtr >= 0 && tPtr < 0) || (sPtr < 0 && tPtr >= 0))) {
                return false;
            }
            sPtr--;
            tPtr--;
        }
        return true;
    }

    public static boolean backspaceCompareStack(String S, String T) {
        Stack<Character> stackS = new Stack<>(), stackT = new Stack<>();

        for (Character c : S.toCharArray()) {
            if (c == '#' && !stackS.isEmpty()) {
                stackS.pop();
            } else if (c != '#') {
                stackS.push(c);
            }
        }

        for (Character c : T.toCharArray()) {
            if (c == '#' && !stackT.isEmpty()) {
                stackT.pop();
            } else if (c != '#') {
                stackT.push(c);
            }
        }

        if (stackS.size() == stackT.size()) {
            while (!stackS.isEmpty() && !stackT.isEmpty()) {
                if (!Objects.equals(stackS.pop(), stackT.pop())) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

}
