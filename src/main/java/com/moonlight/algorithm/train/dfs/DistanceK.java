package com.moonlight.algorithm.train.dfs;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
 * <p>
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2  输出：[7,4,1]
 * 解释：所求结点为与目标结点（值为 5）距离为 2 的结点，值分别为 7，4，以及 1
 *
 * @ClassName DistanceK
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/2 10:07
 * @Version V1.0
 **/
public class DistanceK {

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

        System.out.println(distanceK(r,  r.left, 2));
    }

    static List<Integer> ans = new ArrayList<>();
    static Map<TreeNode, TreeNode> m = new HashMap<>();

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        dfs(root);
        dfs(target, null, 0, K);
        return ans;
    }

    private static void dfs(TreeNode cur, TreeNode prev, int d, int k) {
        if (cur == null) {
            return;
        }
        if (d == k) {
            ans.add(cur.val);
            return;
        }
        if (m.get(cur) != prev) {
            dfs(m.get(cur), cur, d + 1, k);
        }
        if (cur.left != prev) {
            dfs(cur.left, cur, d + 1, k);
        }
        if (cur.right != prev) {
            dfs(cur.right, cur, d + 1, k);
        }
    }

    private static void dfs(TreeNode root) {
        if (root.left != null) {
            m.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            m.put(root.right, root);
            dfs(root.right);
        }
    }


}
