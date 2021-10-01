package com.moonlight.algorithm.train.dfs;

/**
 * https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 *
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * 修剪树不应该改变保留在树中的元素的相对结构（即，如果没有被移除，原有的父代子代关系都应当保留）。 可以证明，存在唯一的答案。
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 *
 * 输入：root = [1,0,2], low = 1, high = 2   输出：[1,null,2]
 *
 * 输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3   输出：[3,2,null,1]
 *
 * 输入：root = [1], low = 1, high = 2  输出：[1]
 *
 * 输入：root = [1,null,2], low = 1, high = 3  输出：[1,null,2]
 *
 * 输入：root = [1,null,2], low = 2, high = 4  输出：[2]
 *
 * @ClassName TrimBST
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/1 14:19
 * @Version V1.0
 **/
public class TrimBST {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(3);
        r.left = new TreeNode(0);
        r.left.right = new TreeNode(2);
        r.left.right.left = new TreeNode(1);
        r.right = new TreeNode(4);

        TreeNode node = trimBST(r, 1, 3);
        StringBuilder sb = new StringBuilder();
        p(node, sb);
        System.out.println(sb.toString());
    }

    private static void p(TreeNode node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.val).append(", ");
            p(node.left, sb);
            p(node.right, sb);
        }
    }

    public static TreeNode trimBST(TreeNode root, int low, int high) {
        // bst: left < root < right
        // root < low 则 left < low
        // root > high 则 right > high
        if (root == null) {
            return null;
        } else if (root.val < low) {
            root = trimBST(root.right, low, high);
        } else if (root.val > high) {
            root = trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }


}
