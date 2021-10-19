package com.moonlight.algorithm.train.recursion;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 *
 * 输入: [1,6,3,2,5]  输出: false
 *
 * 输入: [1,3,2,6,5]  输出: true
 *
 */
public class VerifyPostorder {

    public static void main(String[] args) {
        int[] a = {1, 6, 3, 2, 5}, b = {1, 3, 2, 6, 5};
        System.out.println(verifyPostorder(a));
        System.out.println(verifyPostorder(b));
    }

    public static boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    private static boolean verify(int[] postorder, int s, int e) {
        if (s >= e) {
            return true;
        }
        int l = 0;
        while (postorder[l] < postorder[e]) {
            l++;
        }
        int r = l;
        for (int i = r; i < e; i++) {
            if (postorder[i] < postorder[e]) {
                return false;
            }
        }
        return verify(postorder, s, r - 1) && verify(postorder, r, e - 1);
    }
}