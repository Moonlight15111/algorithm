package com.moonlight.algorithm.train.tree;

import java.util.HashMap;
import java.util.Map;
/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。你可以假设树中没有重复的元素。
 *
 * 输入:  前序遍历 preorder = [3,9,20,15,7]    中序遍历 inorder = [9,3,15,20,7]
 * 输出:      3
 *          / \
 *         9  20
 *           /  \
 *          15   7
 *
 * @author Moonlight
 * @date 2021/3/29 9:18
 */
public class BuildTreeFromPreorderAndInorder {

    public static TreeNode buildTree1231(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length, 0, inorder.length, map);
    }

    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                                    int inStart, int inEnd,
                                     Map<Integer, Integer> map) {
        if (preStart == preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootInOrderIndex = map.get(root.val);
        int leftLength = rootInOrderIndex - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + leftLength + 1, inStart, rootInOrderIndex, map);
        root.right = buildTree(preorder, preStart + leftLength + 1, preEnd, rootInOrderIndex + 1, inEnd, map);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // 先序遍历: [根节点, {左子树先序的结果}, {右子树先序的结果}]  中序遍历: [{左子树中序的结果}, 根节点, {右子树中序的结果}]
        // 先找出根节点，然后根据先序遍历、中序遍历的特性，build出左右子树
        // timeout
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart == preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);

        int rootInOrderIndex = 0;
        for (int i = 0; i < inEnd; i++) {
            if (inorder[i] == root.val) {
                rootInOrderIndex = i;
                break;
            }
        }

        int leftLength = rootInOrderIndex - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + leftLength + 1, inorder, inStart, rootInOrderIndex);
        root.right = buildTree(preorder, preStart + leftLength + 1, preEnd, inorder, rootInOrderIndex + 1, inEnd);
        return root;
    }

}