package com.moonlight.algorithm.train.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/
 * <p>
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。
 * （如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 * 给出遍历输出 S，还原树并返回其根节点 root。
 * <p>
 * 输入："1-2--3--4-5--6--7"  输出：[1,2,5,3,4,6,7]
 * <p>
 * 输入："1-2--3---4-5--6---7"  输出：[1,2,5,3,null,6,null,4,null,7]
 * <p>
 * 输入："1-401--349---90--88"  输出：[1,401,null,349,88,90]
 *
 * @ClassName RecoverFromPreorder
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/3 11:26
 * @Version V1.0
 **/
public class RecoverFromPreorder {

    public static void main(String[] args) {
        TreeNode a = recoverFromPreorder("1-2--3--4-5--6--7");
        System.out.println(p(a));

        TreeNode b = recoverFromPreorder("1-2--3---4-5--6---7");
        System.out.println(p(b));

        TreeNode c = recoverFromPreorder("1-401--349---90--88");
        System.out.println(p(c));
    }

    public static String p(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode c = root;
        q.add(c);
        StringBuilder ans = new StringBuilder();
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                c = q.poll();
                if (c != null) {
                    ans.append(c.val).append(", ");
                    if (c.left != null) {
                        q.add(c.left);
                    }
                    if (c.right != null) {
                        q.add(c.right);
                    }
                }
            }
        }
        return ans.toString();
    }

    public static TreeNode recoverFromPreorder(String traversal) {
        if (traversal == null || traversal.length() == 0) {
            return null;
        }
        if (traversal.length() == 1) {
            return new TreeNode(Integer.parseInt(traversal));
        }
        Stack<TreeNode> stack = new Stack<>();

        int idx = 0, len = traversal.length();
        while (idx < len) {
            // 当前层数
            int level = 0;
            while (idx < len && traversal.charAt(idx) == '-') {
                idx++;
                level++;
            }
            // 获取节点值
            int start = idx;
            while (idx < len && traversal.charAt(idx) != '-') {
                idx++;
            }
            int val = Integer.parseInt(traversal.substring(start, idx));

            TreeNode root = new TreeNode(val);
            // 如果当前层数与树取到的深度一致，说明是正在找左右子树或根节点
            if (level == stack.size()) {
                if (!stack.isEmpty()) {
                    // 题目保证： 如果节点只有一个子节点，那么保证该子节点为左子节点。
                    stack.peek().left = root;
                }
            } else {
                // 如果当前层数与树取到的深度不一致，说明前面已经有其他节点进去了，那么就将其他节点全部弹出
                while (level != stack.size()) {
                    stack.pop();
                }
                stack.peek().right = root;
            }
            stack.add(root);
        }

        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.pop();
    }

}
