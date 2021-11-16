package com.moonlight.algorithm.train.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/
 *
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。
 * 如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * 返回二叉树的 垂序遍历 序列。
 *
 * 输入：root = [3,9,20,null,null,15,7]  输出：[[9],[3,15],[20],[7]]
 * 解释：
 * 列 -1 ：只有结点 9 在此列中。
 * 列  0 ：只有结点 3 和 15 在此列中，按从上到下顺序。
 * 列  1 ：只有结点 20 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 *
 * 输入：root = [1,2,3,4,5,6,7]  输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 列 -2 ：只有结点 4 在此列中。
 * 列 -1 ：只有结点 2 在此列中。
 * 列  0 ：结点 1 、5 和 6 都在此列中。
 *           1 在上面，所以它出现在前面。
 *           5 和 6 位置都是 (2, 0) ，所以按值从小到大排序，5 在 6 的前面。
 * 列  1 ：只有结点 3 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 *
 * 输入：root = [1,2,3,4,6,5,7]  输出：[[4],[2],[1,5,6],[3],[7]]
 *
 * @author Moonlight
 */
public class VerticalTraversal {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(3);
        r.left = new TreeNode(9);
        r.right = new TreeNode(20);
        r.right.left = new TreeNode(15);
        r.right.right = new TreeNode(7);

        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(2);
        b.left.left = new TreeNode(4);
        b.left.right = new TreeNode(5);
        b.right = new TreeNode(3);
        b.right.left = new TreeNode(6);
        b.right.right = new TreeNode(7);

        List<List<Integer>> lists = verticalTraversal(r);

        for (List<Integer> list : lists) {
            System.out.print(list + ", ");
        }

        System.out.println();

        lists = verticalTraversal(b);

        for (List<Integer> list : lists) {
            System.out.print(list + ", ");
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        PriorityQueue<Node> nodes = new PriorityQueue<>((a, b) -> {
            if (a.c != b.c) {
                return a.c - b.c;
            }
            if (a.r != b.r) {
                return a.r - b.r;
            }
            return a.v - b.v;
        });

        dfs(root, 0, 0, nodes);

        List<Integer> list;
        while (!nodes.isEmpty()) {
            list = new ArrayList<>();
            Node peek = nodes.peek();
            while (!nodes.isEmpty() && peek.c == nodes.peek().c) {
                list.add(nodes.poll().v);
            }
            ans.add(list);
        }

        return ans;
    }

    private static void dfs(TreeNode root, int r, int c, PriorityQueue<Node> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(new Node(r, c, root.val));
        dfs(root.left, r + 1, c - 1, nodes);
        dfs(root.right, r + 1, c + 1, nodes);
    }

    private static class Node {
        int r, c, v;
        public Node (int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }

}
