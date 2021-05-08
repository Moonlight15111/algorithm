package com.moonlight.algorithm.train.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8   输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4   输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 * @author Moonlight
 * @date 2021/5/8 17:20
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println(lowestCommonAncestor(root, root.left, root.right).val);
        System.out.println(lowestCommonAncestor(root, root.left, root.left.right).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        findParent(root, parent);

        Set<TreeNode> set = new HashSet<>();
        TreeNode cur = p;
        set.add(cur);
        while (parent.get(cur) != null) {
            cur = parent.get(cur);
            set.add(cur);
        }

        cur = q;
        while (!set.contains(cur)) {
            cur = parent.get(cur);
        }

        return cur;
    }

    private static void findParent(TreeNode root, Map<TreeNode, TreeNode> parent) {
        if (root.left != null) {
            parent.put(root.left, root);
            findParent(root.left, parent);
        }
        if (root.right != null) {
            parent.put(root.right, root);
            findParent(root.right, parent);
        }
    }

}
