package com.moonlight.algorithm.train.tree;

import java.util.*;

/**
 * 找出二叉树中根节点到最小叶子节点的路径
 * -1 表示没有节点
 * 节点值不会重复
 * @author Moonlight
 */
public class BuildTree {

    public static void main(String[] args) {
        int[] a = {5, 6, 7, -1, -1, 2, 9};
        System.out.println(buildTree(a));
    }

    public static List<Integer> buildTree(int[] arr) {
        TreeNode root = build(arr, 1);

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        findParent(root, parent);

        TreeNode minLeaf = findMinLeaf(root);
        List<Integer> list = new ArrayList<>();
        if (minLeaf == null) {
            return list;
        }
        list.add(minLeaf.val);
        while (minLeaf != null && parent.containsKey(minLeaf)) {
            minLeaf = parent.get(minLeaf);
            if (minLeaf != null) {
                list.add(minLeaf.val);
            }
        }
        return list;
    }

    private static TreeNode findMinLeaf(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = findMinLeaf(root.left);
        TreeNode right = findMinLeaf(root.right);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return left.val > right.val ? right : left;
    }

    private static void findParent(TreeNode root, Map<TreeNode, TreeNode> parent) {
        if (root.left != null) {
            parent.put(root.left, root);
            findParent(root.left, parent);
        }
        if (root.right != null) {
            parent.put(root.right, root);
            findParent(root.right, parent);
        }
    }

    public static TreeNode build(int[] arr, int idx) {
        if (idx < 0 || idx - 1 >= arr.length || arr[idx - 1] == -1) {
            return null;
        }
        TreeNode root = new TreeNode(arr[idx - 1]);
        root.left = build(arr, (2 * idx));
        root.right = build(arr, (2 * idx) + 1);
        return root;
    }

    public static void print(TreeNode root, StringBuilder sb) {
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

}