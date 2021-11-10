package com.moonlight.algorithm.train.dfs;

/**
 * https://leetcode-cn.com/problems/delete-leaves-with-a-given-value/
 *
 * 给你一棵以 root 为根的二叉树和一个整数 target ，请你删除所有值为 target 的 叶子节点 。
 * 注意，一旦删除值为 target 的叶子节点，它的父节点就可能变成叶子节点；
 * 如果新叶子节点的值恰好也是 target ，那么这个节点也应该被删除。
 * 也就是说，你需要重复此过程直到不能继续删除。
 *
 * 输入：root = [1,2,3,2,null,2,4], target = 2  输出：[1,null,3,null,4]
 * 解释：上面左边的图中，绿色节点为叶子节点，且它们的值与 target 相同（同为 2 ），它们会被删除，得到中间的图。
 *      有一个新的节点变成了叶子节点且它的值与 target 相同，所以将再次进行删除，从而得到最右边的图。
 *
 * 输入：root = [1,3,3,3,2], target = 3  输出：[1,3,null,null,2]
 *
 * 输入：root = [1,2,null,2,null,2], target = 2  输出：[1]
 * 解释：每一步都删除一个绿色的叶子节点（值为 2）。
 *
 * 输入：root = [1,1,1], target = 1  输出：[]
 *
 * 输入：root = [1,2,3], target = 1  输出：[1,2,3]
 *
 * @author Moonlight
 */
public class RemoveLeafNodes {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.left.left = new TreeNode(2);
        r.right = new TreeNode(3);
        r.right.left = new TreeNode(2);
        r.right.right = new TreeNode(4);

        TreeNode node = removeLeafNodes(r, 2);
        StringBuilder path = new StringBuilder();
        pre(node, path);
        System.out.println(path.toString());
    }

    private static void pre(TreeNode root, StringBuilder path) {
        if (root == null) {
            path.append("#, ");
            return;
        }
        path.append(root.val).append(", ");
        pre(root.left, path);
        pre(root.right, path);
    }

    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }

}
