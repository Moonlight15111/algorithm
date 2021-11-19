package com.moonlight.algorithm.train.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-elements-in-a-contaminated-binary-tree/
 *
 * 给出一个满足下述规则的二叉树：
 *    root.val == 0
 *    如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
 *    如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
 * 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
 * 请你先还原二叉树，然后实现 FindElements 类：
 *    FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
 *    bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
 *
 * 输入：
 * ["FindElements","find","find","find"]
 * [[[-1,-1,-1,-1,-1]],[1],[3],[5]]
 * 输出：
 * [null,true,true,false]
 * 解释：
 * FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
 * findElements.find(1); // return True
 * findElements.find(3); // return True
 * findElements.find(5); // return False
 *
 * @author Moonlight
 */
public class FindElements {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(-1);
        r.left = new TreeNode(-1);
        r.left.left = new TreeNode(-1);
        r.left.right = new TreeNode(-1);
        r.right = new TreeNode(-1);

        FindElements findElements = new FindElements(r);
        // return True
        System.out.println(findElements.find(1));
        // return True
        System.out.println(findElements.find(3));
        // return False
        System.out.println(findElements.find(5));
    }

    List<Integer> valList;
    public FindElements(TreeNode root) {
        valList = new ArrayList<>();
        root.val = 0;
        dfs(root);
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        valList.add(root.val);
        if (root.left != null) {
            root.left.val = 2 * root.val + 1;
        }
        if (root.right != null) {
            root.right.val = 2 * root.val + 2;
        }
        dfs(root.left);
        dfs(root.right);
    }

    public boolean find(int target) {
        return valList.contains(target);
    }

}
