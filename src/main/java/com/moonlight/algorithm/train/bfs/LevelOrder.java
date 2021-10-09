package com.moonlight.algorithm.train.bfs;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 *
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *  [3,9,20,15,7]
 *
 */
public class LevelOrder {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(3);
        r.left = new TreeNode(9);
        r.right = new TreeNode(20);
        r.right.left = new TreeNode(15);
        r.right.right = new TreeNode(7);

        System.out.println(Arrays.toString(levelOrder(r)));
    }

    public static int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        if (root.left == null && root.right == null) {
            return new int[]{root.val};
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode c = root;
        q.add(c);
        while (!q.isEmpty()) {
            c = q.poll();
            list.add(c.val);
            if (c.left != null) {
                q.add(c.left);
            }
            if (c.right != null) {
                q.add(c.right);
            }
        }
        int s = list.size();
        int[] ans = new int[s];
        for (int i = 0; i < s; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

}
