package com.moonlight.algorithm.train.dfs;

/**
 * https://leetcode-cn.com/problems/distribute-coins-in-binary-tree/
 *
 * 给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。
 * 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。
 * (移动可以是从父结点到子结点，或者从子结点移动到父结点。)。
 * 返回使每个结点上只有一枚硬币所需的移动次数。
 *
 * 输入：[3,0,0]  输出：2
 * 解释：从树的根结点开始，我们将一枚硬币移到它的左子结点上，一枚硬币移到它的右子结点上。
 *
 * 输入：[0,3,0]  输出：3
 * 解释：从根结点的左子结点开始，我们将两枚硬币移到根结点上 [移动两次]。然后，我们把一枚硬币从根结点移到右子结点上。
 *
 * 输入：[1,0,2]  输出：2
 *
 * 输入：[1,0,0,null,3]  输出：4
 *
 * @author Moonlight
 */
public class DistributeCoins {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        a.left = new TreeNode(0);
        a.right = new TreeNode(0);

        TreeNode b = new TreeNode(0);
        b.left = new TreeNode(3);
        b.right = new TreeNode(0);

        TreeNode c = new TreeNode(1);
        c.left = new TreeNode(0);
        c.left.right = new TreeNode(3);
        c.right = new TreeNode(0);

        System.out.println(distributeCoins(a));
        System.out.println(distributeCoins(b));
        System.out.println(distributeCoins(c));
    }

    static int ans = 0;
    public static int distributeCoins(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ans = 0;
        dfs(root);
        return ans;
    }

    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        int left = needCoin(root.left);
        int right = needCoin(root.right);

        ans += Math.abs(left) + Math.abs(right);

        dfs(root.left);
        dfs(root.right);
    }

    private static int needCoin(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return needCoin(root.left) + needCoin(root.right) + (root.val - 1);
    }

}
