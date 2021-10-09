package com.moonlight.algorithm.train.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *  [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class LevelOrderII {

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
        List<Integer> list;
        int s;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode c = root;

        q.add(c);
        while (!q.isEmpty()) {
            s = q.size();
            list = new ArrayList<>();
            for (int i = 0; i < s; i++) {
                c = q.poll();
                list.add(c.val);
                if (c.left != null) {
                    q.add(c.left);
                }
                if (c.right != null) {
                    q.add(c.right);
                }
            }
            ans.add(list);
        }

        return ans;
    }

}
