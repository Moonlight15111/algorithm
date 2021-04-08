package com.moonlight.algorithm.train.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/
 *
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 输入: [3,2,3,null,3,null,1]  输出: 7
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 *
 * 输入: [3,4,5,1,3,null,1]  输出: 9
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 * @ClassName HouseRobberIII
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/7 21:22
 * @Version V1.0
 **/
public class HouseRobberIII {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        System.out.println(rob(root));

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(4);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(1);

        System.out.println(rob(treeNode));

        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(1);
        node.left.left = new TreeNode(2);
        node.left.left.left = new TreeNode(3);

        System.out.println(rob(node));
    }

    public static int dp(TreeNode root) {
        return 0;
    }

    public static int rob12312(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Map<TreeNode, Integer> map = new HashMap<>();

        int sum = root.val;
        if (root.left != null) {
            sum += rob12312(root.left.left, map) + rob12312(root.left.right, map);
        }
        if (root.right != null) {
            sum += rob12312(root.right.left, map) + rob12312(root.right.right, map);
        }

        return Math.max(sum, rob12312(root.left, map) + rob12312(root.right, map));
    }

    public static int rob12312(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int sum = root.val;
        if (root.left != null) {
            sum += rob12312(root.left.left, map) + rob12312(root.left.right, map);
        }
        if (root.right != null) {
            sum += rob12312(root.right.left, map) + rob12312(root.right.right, map);
        }
        int max = Math.max(sum, rob12312(root.left, map) + rob12312(root.right, map));
        map.put(root, max);
        return max;
    }

    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        // timeout
        // Math.max(爷爷的钱 + 孙子的钱, 儿子的钱)
        int sum = root.val;
        if (root.left != null) {
            sum += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            sum += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(sum, rob(root.left) + rob(root.right));
    }

}
