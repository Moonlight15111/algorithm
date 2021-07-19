package com.moonlight.algorithm.train.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 〈功能简述〉<br>
 * https://leetcode-cn.com/problems/print-binary-tree/
 *
 * 在一个 m * n 的二维字符串数组中输出二叉树，并遵守以下规则：
 *   1.行数 m 应当等于给定二叉树的高度。
 *   2.列数 n 应当总是奇数。
 *   3.根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。
 *     根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。
 *     你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。
 *     即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。
 *     然而，如果两个子树都为空则不需要为它们留出任何空间。
 *   4.每个未使用的空间应包含一个空的字符串""。
 *   5.使用相同的规则输出子树。
 *
 * 输入:
 *    1
 *   /
 *  2
 * 输出:  [["", "1", ""],
 *         ["2", "", ""]]
 *
 * 输入:
 *        1
 *       / \
 *      2   3
 *      \
 *       4
 * 输出:
 *   [["", "", "", "1", "", "", ""],
 *    ["", "2", "", "", "", "3", ""],
 *    ["", "", "4", "", "", "", ""]]
 *
 * @author Moonlight
 * @date 2021/7/19 16:45
 */
public class PrintTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        List<List<String>> listList = printTree(root);
        for (List<String> list : listList){
            System.out.println(list);
        }
    }

    public static List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();
        // 先算出数的高度，通过高度推每层的元素个数: (2 的 H 次幂) - 1
        // dfs填充每一层的数据，填充时通过类似二分的方式算出要填充的位置
        int h = h(root);
        int n = (int) (Math.pow(2, h) - 1);

        for (int i = 0; i < h; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add("");
            }
            ans.add(list);
        }

        dfs(root, ans, 1, 0, n - 1);

        return ans;
    }

    private static void dfs(TreeNode root, List<List<String>> ans, int dept, int l, int r) {
        if (root == null) {
            return;
        }
        int mid = (r + l) / 2;
        ans.get(dept - 1).set(mid, root.val + "");
        dfs(root.left, ans, dept + 1, l, mid - 1);
        dfs(root.right, ans, dept + 1, mid + 1, r);
    }

    private static int h(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(h(root.left), h(root.right));
    }

}
