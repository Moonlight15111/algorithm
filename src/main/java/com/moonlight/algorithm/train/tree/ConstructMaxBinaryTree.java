package com.moonlight.algorithm.train.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 *
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *   1. 二叉树的根是数组 nums 中的最大元素。
 *   2. 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 *   3. 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 *
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 *     - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 *         - 空数组，无子节点。
 *         - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 *             - 空数组，无子节点。
 *             - 只有一个元素，所以子节点是一个值为 1 的节点。
 *     - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 *         - 只有一个元素，所以子节点是一个值为 0 的节点。
 *         - 空数组，无子节点。
 *
 * 输入：nums = [3,2,1]  输出：[3,null,2,null,1]
 *
 * @ClassName ConstructMaxBinaryTree
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/14 22:06
 * @Version V1.0
 **/
public class ConstructMaxBinaryTree {

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 6, 0, 5}, b = {3, 2, 1};
        TreeNode treeNode = constructMaximumBinaryTree(a);
        print(treeNode);

        System.out.println("---------------------");

        TreeNode tree = constructMaximumBinaryTree(b);
        print(tree);
    }

    private static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.print(poll.val + ", ");

            if (poll.left != null) {
                queue.add(poll.left);
            } else {
                System.out.print("null, ");
            }

            if (poll.right != null) {
                queue.add(poll.right);
            } else {
                System.out.print("null, ");
            }
        }

    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int maxIndex = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);

        int[] left = new int[maxIndex], right = new int[nums.length - maxIndex - 1];
        if (left.length > 0) {
            System.arraycopy(nums, 0, left, 0, maxIndex);
        }
        if (maxIndex < nums.length - 1) {
            System.arraycopy(nums, maxIndex + 1, right, 0, nums.length - maxIndex - 1);
        }
        root.left = constructMaximumBinaryTree(left);
        root.right = constructMaximumBinaryTree(right);

        return root;
    }

}
