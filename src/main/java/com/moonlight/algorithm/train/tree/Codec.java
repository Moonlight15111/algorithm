package com.moonlight.algorithm.train.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * @author Moonlight
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        pre(root, ans);
        return ans.toString();
    }

    private void pre(TreeNode root, StringBuilder ans) {
        if (root == null) {
            ans.append("#,");
            return;
        }
        ans.append(root.val).append(",");
        pre(root.left, ans);
        pre(root.right, ans);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        final String[] split = data.split(",");
        if (split.length == 0 || split[0] == null || "#".equals(split[0])) {
            return null;
        }
        Queue<String> q = new LinkedList<>();
        for (String s : split) {
            if (s != null && !"".equals(s)) {
                q.add(s);
            }
        }
        return deserialize(q);
    }

    private TreeNode deserialize(Queue<String> queue) {
        String val = queue.poll();
        if ("#".equals(val)) {
            return null;
        }
        TreeNode r = new TreeNode(Integer.parseInt(val));
        r.left = deserialize(queue);
        r.right = deserialize(queue);
        return r;
    }

}
