package com.moonlight.algorithm.train.dfs;

/**
 * https://leetcode-cn.com/problems/count-good-nodes-in-binary-tree/
 *
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 *
 * 输入：root = [3,1,4,3,null,1,5]  输出：4
 * 解释：根节点 (3) 永远是个好节点。
 *      节点 4 -> (3,4) 是路径中的最大值。
 *      节点 5 -> (3,4,5) 是路径中的最大值。
 *      节点 3 -> (3,1,3) 是路径中的最大值。
 *
 * 输入：root = [3,3,null,4,2]  输出：3
 * 解释：节点 2 -> (3, 3, 2) 不是好节点，因为 "3" 比它大。
 *
 * 输入：root = [1]  输出：1
 * 解释：根节点是好节点。
 *
 * @author Moonlight
 */
public class GoodNodes {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3), b = new TreeNode(3), c = new TreeNode(1);

        a.left = new TreeNode(1);
        a.left.left = new TreeNode(3);
        a.right = new TreeNode(4);
        a.right.left = new TreeNode(1);
        a.right.right = new TreeNode(5);

        b.left = new TreeNode(3);
        b.left.left = new TreeNode(4);
        b.left.right = new TreeNode(2);

        System.out.println(goodNodes(a));
        System.out.println(goodNodes(b));
        System.out.println(goodNodes(c));
    }

    public static int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return dfs(root, root.val);
    }

    private static int dfs(TreeNode root, int parent) {
        if (root == null) {
            return 0;
        }
        int cnt = 0;
        if (root.val >= parent) {
            parent = root.val;
            cnt += 1;
        }
        return dfs(root.left, parent) + dfs(root.right, parent) + cnt;
    }

}
