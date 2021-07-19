package com.moonlight.algorithm.train.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 〈功能简述〉<br>
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 *    结点左子树中所含结点的值小于等于当前结点的值
 *    结点右子树中所含结点的值大于等于当前结点的值
 *    左子树和右子树都是二叉搜索树
 *
 * 输入: [1,null,2,2]
 *     1
 *      \
 *       2
 *      /
 *     2
 * 输出: 2
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * @author Moonlight
 * @date 2021/7/16 10:50
 */
public class FindMode {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(2);
        TreeNode root = new TreeNode(0);

        System.out.println(Arrays.toString(findMode(root)));
    }

    public static int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        pre(root, map);

        int[] max = new int[]{0};
        for (Integer key : map.keySet()) {
            max[0] = Math.max(max[0], map.get(key));
        }
        List<Integer> collect = map.keySet().stream().filter(key -> map.get(key) >= max[0]).collect(Collectors.toList());
        int[] ans = new int[collect.size()];
        for (int i = 0; i < collect.size(); i++) {
            ans[i] = collect.get(i);
        }
        return ans;
    }

    private static void pre(TreeNode root, Map<Integer, Integer> map) {
        if (root != null) {
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            pre(root.left, map);
            pre(root.right, map);
        }
    }

}
