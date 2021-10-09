package com.moonlight.algorithm.train.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 *
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */
public class LevelOrderIII {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(3);
        r.left = new TreeNode(9);
        r.right = new TreeNode(20);
        r.right.left = new TreeNode(15);
        r.right.right = new TreeNode(7);

        List<List<Integer>> lists = levelOrder(r);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

        System.out.println("  ");

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        lists = levelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            ans.add(list);
            return ans;
        }
        LinkedList<Integer> list;
        int s, l = 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode c = root;

        q.add(c);
        while (!q.isEmpty()) {
            s = q.size();
            list = new LinkedList<>();
            for (int i = 0; i < s; i++) {
                c = q.poll();
                if ((l & 1) == 1) {
                    list.addFirst(c.val);
                } else {
                    list.addLast(c.val);
                }
                if (c.left != null) {
                    q.add(c.left);
                }
                if (c.right != null) {
                    q.add(c.right);
                }
            }
            l++;
            ans.add(list);
        }
        return ans;
    }

}
