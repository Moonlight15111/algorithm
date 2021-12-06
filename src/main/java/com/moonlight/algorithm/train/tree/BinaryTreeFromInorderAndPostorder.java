package com.moonlight.algorithm.train.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意: 你可以假设树中没有重复的元素。
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author Moonlight
 */
public class BinaryTreeFromInorderAndPostorder {

    public static void main(String[] args) {
        TreeNode node = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        StringBuilder sb = new StringBuilder();
        print(node, sb);
        System.out.println(sb);
    }

    private static void print(TreeNode root, StringBuilder sb) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            sb.append(poll.val).append(", ");
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }

    static Map<Integer, Integer> map = new HashMap<>();
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRootIdx = map.get(root.val);
        int inLeftSize = inRootIdx - inStart;
        root.left = build(inorder, inStart, inRootIdx - 1, postorder, postStart,postStart + inLeftSize - 1);
        root.right = build(inorder, inRootIdx + 1, inEnd, postorder, postStart + inLeftSize, postEnd - 1);
        return root;
    }

}
