package com.moonlight.algorithm.train.tree;

/**
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 *
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 * 输出: "1(2(4))(3)"
 * 解释: 原本将是“1(2(4)())(3())”，在你省略所有不必要的空括号对之后，它将是“1(2(4))(3)”。
 *
 * 输入: 二叉树: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 * 输出: "1(2()(4))(3)"
 * 解释: 和第一个示例相似，除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 *
 * @ClassName Tree2Str
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/9 13:04
 * @Version V1.0
 **/
public class Tree2Str {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);

        System.out.println(tree2str(root));
    }

    public static String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return "" + root.val;
        }
        if (root.right == null) {
            return root.val + "(" + tree2str(root.left) + ")";
        }
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }

}
