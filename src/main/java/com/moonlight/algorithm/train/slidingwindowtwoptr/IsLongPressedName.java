package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/long-pressed-name/
 * <p>
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，
 * 按键可能会被长按，而字符可能被输入 1 次或多次。
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），
 * 那么就返回 True。
 * <p>
 * 输入：name = "alex", typed = "aaleex"        输出：true       解释：'alex' 中的 'a' 和 'e' 被长按。
 * <p>
 * 输入：name = "saeed", typed = "ssaaedd"      输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * <p>
 * 输入：name = "leelee", typed = "lleeelee"    输出：true
 * <p>
 * 输入：name = "laiden", typed = "laiden"      输出：true
 *
 * @author Moonlight
 * @date 2021/3/4 15:38
 */
public class IsLongPressedName {

    public static void main(String[] args) {
        System.out.println(isLongPressedNameStack("alex", "aaleex") + ", " + isLongPressedNameTwoPtr("alex", "aaleex"));
        System.out.println(isLongPressedNameStack("saeed", "ssaaedd") + ", " + isLongPressedNameTwoPtr("saeed", "ssaaedd"));
        System.out.println(isLongPressedNameStack("leelee", "lleeelee") + ", " + isLongPressedNameTwoPtr("leelee", "lleeelee"));
        System.out.println(isLongPressedNameStack("laiden", "laiden") + ", " + isLongPressedNameTwoPtr("laiden", "laiden"));
        System.out.println(isLongPressedNameStack("laalsd", "laalsdl") + ", " + isLongPressedNameTwoPtr("laalsd", "laalsdl"));
    }

    public static boolean isLongPressedNameTwoPtr(String name, String typed) {
        if (typed.length() < name.length()) {
            return false;
        }
        if (name.equals(typed)) {
            return true;
        }
        // 双指针, 对于某个字符name 和 typed一致，就一起往前走
        // 不一致但是typedPtr的前一个字符和typedPtr一致，那么说明有长键入的，typedPtr往前走
        // 否则就return false
        // 到最后name、typed都被遍历完了，那么就要return true
        int namePtr = 0, typedPtr = 0;

        while (typedPtr < typed.length()) {
            if (namePtr < name.length() && name.charAt(namePtr) == typed.charAt(typedPtr)) {
                namePtr++;
                typedPtr++;
            } else if (typedPtr > 0 && typed.charAt(typedPtr - 1) == typed.charAt(typedPtr)) {
                typedPtr++;
            } else {
                return false;
            }
        }

        return namePtr == name.length() && typedPtr == typed.length();
    }

    public static boolean isLongPressedNameStack(String name, String typed) {
        if (typed.length() < name.length()) {
            return false;
        }
        if (name.equals(typed)) {
            return true;
        }
        // 导到两个栈里面
        // 对于某个字符 x typed栈中先弹出，直到不等于字符x为止，并记录弹了k次，然后name栈中也进行弹出，弹到不相等或k为0为止
        // 本质上就是一个字符一个字符的匹配，匹配过了就弹出
        Stack<Character> nameStack = new Stack<>(), typedStack = new Stack<>();

        for (Character c : name.toCharArray()) {
            nameStack.add(c);
        }

        for (Character c : typed.toCharArray()) {
            typedStack.add(c);
        }

        while (!nameStack.isEmpty() && !typedStack.isEmpty()) {
            if (!nameStack.peek().equals(typedStack.peek())) {
                return false;
            }
            int i = 0;
            while (!nameStack.isEmpty() && !typedStack.isEmpty() && typedStack.peek().equals(nameStack.peek())) {
                i++;
                typedStack.pop();
            }
            Character pop = nameStack.pop();
            i -= 1;
            while (!nameStack.isEmpty() && nameStack.peek().equals(pop) && i > 0) {
                nameStack.pop();
                i--;
            }
        }

        return nameStack.isEmpty() && typedStack.isEmpty();
    }

}
