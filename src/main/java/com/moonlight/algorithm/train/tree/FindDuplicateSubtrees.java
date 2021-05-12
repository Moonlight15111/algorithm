package com.moonlight.algorithm.train.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/
 *
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 *
 * 下面是两个重复的子树：
 *    2
 *   /
 *  4
 * 和   4
 *
 * @author Moonlight
 * @date 2021/5/12 12:49
 */
public class FindDuplicateSubtrees {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);

        List<TreeNode> duplicateSubtrees = findDuplicateSubtrees(root);
        for (TreeNode treeNode : duplicateSubtrees) {
            System.out.println(treeNode.val);
        }
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        dfs(root, ans, map);

        return ans;
    }

    private static String dfs(TreeNode root, List<TreeNode> ans, Map<String, Integer> map) {
        if (root == null) {
            return "#";
        }
        String k = root.val + "," + dfs(root.left, ans, map) + "," + dfs(root.right, ans, map);

        map.put(k, map.getOrDefault(k, 0) + 1);

        if (map.get(k) != null && map.get(k) == 2) {
            ans.add(root);
        }

        return k;
    }

}