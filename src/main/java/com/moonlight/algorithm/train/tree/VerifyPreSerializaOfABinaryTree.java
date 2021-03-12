package com.moonlight.algorithm.train.tree;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
 *
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。
 * 如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"  输出: true
 *
 * 输入: "1,#"   输出: false
 *
 * 输入: "9,#,#,1"   输出: false
 *
 * @author Moonlight
 * @date 2021/3/12 9:24
 */
public class VerifyPreSerializaOfABinaryTree {

    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(isValidSerialization("1,#"));
        System.out.println(isValidSerialization("9,#,#,1"));
        System.out.println(isValidSerialization("#"));
        System.out.println(isValidSerialization("#,#,3,5,#"));
    }

    public static boolean isValidSerialization(String preorder) {
        int nulCount = 0;
        String[] split = preorder.split(",");
        for (int len = split.length, i = len - 1; i >= 0 ; i--) {
            if ("#".equals(split[i])) {
                nulCount++;
            } else if (nulCount < 2) {
                return false;
            } else {
                nulCount--;
            }
        }
        return nulCount == 1;
    }

}
