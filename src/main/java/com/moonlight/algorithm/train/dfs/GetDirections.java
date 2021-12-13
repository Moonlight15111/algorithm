package com.moonlight.algorithm.train.dfs;

/**
 * https://leetcode-cn.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
 *
 * 给你一棵 二叉树 的根节点 root ，这棵二叉树总共有 n 个节点。每个节点的值为 1 到 n 中的一个整数，且互不相同。
 * 给你一个整数 startValue ，表示起点节点 s 的值，和另一个不同的整数 destValue ，表示终点节点 t 的值。
 * 请找到从节点 s 到节点 t 的 最短路径 ，并以字符串的形式返回每一步的方向。每一步用 大写 字母 'L' ，'R' 和 'U' 分别表示一种方向：
 *   'L' 表示从一个节点前往它的 左孩子 节点。
 *   'R' 表示从一个节点前往它的 右孩子 节点。
 *   'U' 表示从一个节点前往它的 父 节点。
 * 请你返回从 s 到 t 最短路径 每一步的方向。
 *
 * 输入：root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6  输出："UURL"
 * 解释：最短路径为：3 → 1 → 5 → 2 → 6
 *
 * 输入：root = [2,1], startValue = 2, destValue = 1  输出："L"
 * 解释：最短路径为：2 → 1 。
 *
 * @author Moonlight
 */
public class GetDirections {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        a.left = new TreeNode(1);
        a.left.left = new TreeNode(3);
        a.right = new TreeNode(2);
        a.right.left = new TreeNode(6);
        a.right.right = new TreeNode(4);

        TreeNode b = new TreeNode(2);
        b.left = new TreeNode(1);

        System.out.println(getDirections(a, 3, 6));

        System.out.println(getDirections(b, 2, 1));
    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode parent = dfs(root, startValue, destValue);
        StringBuilder start = new StringBuilder(), dest = new StringBuilder(), ans = new StringBuilder();
        findStartPath(parent, startValue, start, ans);
        findDestPath(parent, destValue, dest, ans);
        return ans.toString();
    }

    private static void findDestPath(TreeNode node, int val, StringBuilder path, StringBuilder ans) {
        if (node == null) {
            return;
        }
        if (node.val == val) {
            ans.append(path.toString());
            return;
        }
        path.append("L");
        findDestPath(node.left, val, path, ans);
        path.deleteCharAt(path.length() - 1);

        path.append("R");
        findDestPath(node.right, val, path, ans);
        path.deleteCharAt(path.length() - 1);
    }

    private static void findStartPath(TreeNode node, int val, StringBuilder path, StringBuilder ans) {
        if (node == null) {
            return;
        }
        if (node.val == val) {
            ans.append(path.toString());
            return;
        }
        path.append("U");
        findStartPath(node.left, val, path, ans);
        path.deleteCharAt(path.length() - 1);

        path.append("U");
        findStartPath(node.right, val, path, ans);
        path.deleteCharAt(path.length() - 1);
    }

    private static TreeNode dfs(TreeNode root, int startValue, int destValue) {
        if (root == null || root.val == startValue || root.val == destValue) {
            return root;
        }
        TreeNode left = dfs(root.left, startValue, destValue);
        TreeNode right = dfs(root.right, startValue, destValue);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

}
