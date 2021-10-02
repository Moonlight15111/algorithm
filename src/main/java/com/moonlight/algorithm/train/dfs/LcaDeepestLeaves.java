package com.moonlight.algorithm.train.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves/
 *
 * 给你一个有根节点的二叉树，找到它最深的叶节点的最近公共祖先。
 * 回想一下：
 *   叶节点 是二叉树中没有子节点的节点
 *   树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
 *   如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4]  输出：[2,7,4]
 * 解释：
 * 我们返回值为 2 的节点，在图中用黄色标记。
 * 在图中用蓝色标记的是树的最深的节点。
 * 注意，节点 6、0 和 8 也是叶节点，但是它们的深度是 2 ，而节点 7 和 4 的深度是 3 。
 *
 * 输入：root = [1]
 * 输出：[1]
 * 解释：根节点是树中最深的节点，它是它本身的最近公共祖先。
 *
 * 输入：root = [0,1,3,null,2]
 * 输出：[2]
 * 解释：树中最深的叶节点是 2 ，最近公共祖先是它自己。
 *
 * @ClassName LcaDeepestLeaves
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/2 11:05
 * @Version V1.0
 **/
public class LcaDeepestLeaves {

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

        System.out.println(lcaDeepestLeaves(r).val);
    }

    static Map<TreeNode, Integer> m = new HashMap<>();
    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        int l = m.containsKey(root.left) ? m.get(root.left) : depth(root.left), r = m.containsKey(root.right) ? m.get(root.right) :  depth(root.right);
        if (l == r) {
            return root;
        } else if (l > r) {
            return lcaDeepestLeaves(root.left);
        }
        return lcaDeepestLeaves(root.right);
    }

    private static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = depth(node.left), r = depth(node.right);
        int max = Math.max(l, r) + 1;
        m.put(node, max);
        return max;
    }


}
