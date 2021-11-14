package com.moonlight.algorithm.train.dfs;

/**
 * https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor/
 *
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 *
 * 树中的节点数在 2 到 5000 之间。
 * 0 <= Node.val <= 105
 *
 * 输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]  输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 *
 * 输入：root = [1,null,2,null,0,3]  输出：3
 *
 * @ClassName MaxAncestorDiff
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/11/14 13:42
 * @Version V1.0
 **/
public class MaxAncestorDiff {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(8);
        r.left = new TreeNode(3);
        r.left.left = new TreeNode(1);
        r.left.right = new TreeNode(6);
        r.left.right.left = new TreeNode(4);
        r.left.right.right = new TreeNode(7);

        r.right = new TreeNode(10);
        r.right.right = new TreeNode(14);
        r.right.right.left = new TreeNode(13);


        System.out.println(maxAncestorDiff(r));
    }

    static int ans = Integer.MIN_VALUE;
    public static int maxAncestorDiff(TreeNode root) {
        if (root == null || (root.left == null && root.right == null) ) {
            return 0;
        }
        dfs(root, root.val, root.val);
        return ans;
    }

    private static void dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }

        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        if (root.left == null && root.right == null) {
            ans = Math.max(ans, Math.abs(max - min));
        }

        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }

}
