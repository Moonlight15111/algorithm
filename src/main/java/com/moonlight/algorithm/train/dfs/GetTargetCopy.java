package com.moonlight.algorithm.train.dfs;

/**
 * https://leetcode-cn.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 *
 * 给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original 中的目标节点 target。
 * 其中，克隆树 cloned 是原始树 original 的一个 副本 。
 * 请找出在树 cloned 中，与 target 相同 的节点，
 * 并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）。
 * 注意：
 *   你 不能 对两棵二叉树，以及 target 节点进行更改。
 *   只能 返回对克隆树 cloned 中已有的节点的引用。
 * 进阶：如果树中允许出现值相同的节点，你将如何解答？
 *
 * 输入: tree = [7,4,3,null,null,6,19], target = 3  输出: 3
 * 解释: 上图画出了树 original 和 cloned。target 节点在树 original 中，用绿色标记。答案是树 cloned 中的黄颜色的节点（其他示例类似）。
 *
 * 输入: tree = [7], target =  7  输出: 7
 *
 * 输入: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4  输出: 4
 *
 * 输入: tree = [1,2,3,4,5,6,7,8,9,10], target = 5  输出: 5
 *
 * 树中节点的数量范围为 [1, 10^4] 。
 * 同一棵树中，没有值相同的节点。
 * target 节点是树 original 中的一个节点，并且不会是 null
 *
 * @author Moonlight
 */
public class GetTargetCopy {


    public static void main(String[] args) {
        TreeNode a = new TreeNode(7);
        a.left = new TreeNode(4);
        a.right = new TreeNode(3);
        a.right.left = new TreeNode(6);
        a.right.right = new TreeNode(19);

        TreeNode b = new TreeNode(7);
        b.left = new TreeNode(4);
        b.right = new TreeNode(3);
        b.right.left = new TreeNode(6);
        b.right.right = new TreeNode(19);


        System.out.println(getTargetCopy(a, b, a.right).val);
    }

    static TreeNode ans;
    public static TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (target == null) {
            return null;
        }
        dfs(cloned, target);
        return ans;
    }

    private static void dfs(TreeNode cloned, TreeNode target) {
        if (cloned == null) {
            return;
        }
        if (cloned.val == target.val) {
            ans = cloned;
            return;
        }
        dfs(cloned.left, target);
        dfs(cloned.right, target);
    }

}
