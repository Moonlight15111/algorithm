package com.moonlight.algorithm.train.tree;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * https://leetcode-cn.com/problems/serialize-and-deserialize-bst/
 *
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，
 * 或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。
 * 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * 编码的字符串应尽可能紧凑。
 *
 * 输入：root = [2,1,3]   输出：[2,1,3]
 *
 * 输入：root = []   输出：[]
 *
 * @author Moonlight
 * @date 2021/7/15 14:50
 */
public class SerializeAndDeserializeBst {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);

        String serialize = serialize(root);
        System.out.println("serialize = " + serialize);

        TreeNode res = deserialize(serialize);
        System.out.println("deserialize = " + serialize(res));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root.val + "";
        }
        StringBuilder ans = new StringBuilder();

        pre(root, ans);

        return ans.deleteCharAt(ans.length() - 1).toString();
    }

    private static void pre(TreeNode root, StringBuilder ans) {
        if (root == null) {
            ans.append("#,");
            return;
        }
        ans.append(root.val).append(",");
        pre(root.left, ans);
        pre(root.right, ans);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || Objects.equals(data, "")) {
            return null;
        }
        String[] split = data.split(",");

        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(split));
        return deserialize(queue);
    }

    private static TreeNode deserialize(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String val = queue.poll();
        if (Objects.equals(val, "#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }

}
