package com.moonlight.algorithm.train.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 *
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 *
 * 输入：root = [1,null,3,2,4,null,5,6]   输出：3
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：5
 *
 * @author Moonlight
 * @date 2021/5/8 11:46
 */
public class MaxDepthOfNAryTree {

    public static void main(String[] args) {
        Node root = new Node(1);

        Node n3 = new Node(3);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        List<Node> n3c = new ArrayList<>();
        n3c.add(n5);
        n3c.add(n6);
        n3.children = n3c;

        Node n2 = new Node(2);
        Node n4 = new Node(4);

        List<Node> rc = new ArrayList<>();
        rc.add(n3);
        rc.add(n2);
        rc.add(n4);

        root.children = rc;

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null) {
            return 1;
        }
        int ans = 0;
        for (Node c : root.children) {
            ans = Math.max(ans, maxDepth(c));
        }
        return ans + 1;
    }

}
