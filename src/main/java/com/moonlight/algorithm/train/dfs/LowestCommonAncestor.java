package com.moonlight.algorithm.train.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * @ClassName LowestCommonAncestor
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/3 11:05
 * @Version V1.0
 **/
public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(3);

        r.left = new TreeNode(5);
        r.left.left = new TreeNode(6);
        r.left.right = new TreeNode(2);
        r.left.right.left = new TreeNode(7);
        r.left.right.right = new TreeNode(4);

        r.right = new TreeNode(1);
        r.right.left = new TreeNode(0);
        r.right.right = new TreeNode(8);

        System.out.println(lowestCommonAncestor(r, r.left, r.right).val + ", " + lowestCommonAncestor222(r, r.left, r.right).val);
        System.out.println(lowestCommonAncestor(r, r.left, r.left.right.right).val + ", " + lowestCommonAncestor222(r, r.left, r.left.right.right).val);
    }

    public static TreeNode lowestCommonAncestor222(TreeNode root, TreeNode p, TreeNode q) {
        // 如果根节点为空直接返回null
        // 第一个找到的节点为p说明p比q深度小,位于q上方,直接返回p
        // 第一个找到的节点为q说明q比p深度小,位于p上方,直接返回q
        if (root == null || root == p || root == q) {
            return root;
        }
        // 如果left和right都不为空说明两个节点分居在根节点两侧,直接返回根节点
        // 如果左边递归为空说明两个节点都在右边,且right节点一定是p,q的根节点,直接返回right节点
        // 如果右递归为空说明两个节点都在左边,且left节点一定是p,q的根节点,直接返回left节点
        TreeNode l = lowestCommonAncestor222(root.left, p, q);
        TreeNode r = lowestCommonAncestor222(root.right, p, q);
        return l == null ? r : (r == null ? l : root);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        Map<TreeNode, TreeNode> m = new HashMap<>();
        findParent(root, m);
        Set<TreeNode> set = new HashSet<>();

        TreeNode c = p;
        set.add(c);
        while (m.get(c) != null) {
            set.add(m.get(c));
            c = m.get(c);
        }

        c = q;
        while (!set.contains(c)) {
            c = m.get(c);
        }
        return c;
    }

    private static void findParent(TreeNode root, Map<TreeNode, TreeNode> m) {
        if (root.left != null) {
            m.put(root.left, root);
            findParent(root.left, m);
        }
        if (root.right != null) {
            m.put(root.right, root);
            findParent(root.right, m);
        }
    }

}
