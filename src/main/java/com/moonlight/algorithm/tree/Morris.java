package com.moonlight.algorithm.tree;

import com.moonlight.algorithm.train.list.TreeNode;

/**
 * @ClassName Morris
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/28 21:24
 * @Version V1.0
 **/
public class Morris {
    // 当前节点记为cur, 一开始cur来到树的根节点
    // 1.如果cur无左树，cur移动到右树上
    // 2.如果cur有左树，找到左树最右节点，记为mostRight
    //   2.1.如果mostRight的右孩子为空，则将mostRight的右孩子指向cur，cur向左移动
    //   2.2.如果mostRight的右孩子指向cur，则将mostRight的右孩子指回空，cur向右移动
    // 3.如果cur为空，停止整个流程

    public static void morris(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                TreeNode mostRight = cur.left.right == null ? cur.left : cur.left.right;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                }
                if (mostRight.right == cur) {
                    mostRight.right = null;
                    cur =  cur.right;
                }
            }
        }
    }

    public static void morrisOpt(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root, mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
//                    System.out.println(cur.val); // 先序
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
//                    printEdge(cur.left); // 后序
                }
            }

//            else {  // 先序
//                System.out.println(cur.val);
//            }

            // System.out.println(cur.val); // 中序
            cur =  cur.right;
        }
//        printEdge(root); // 后序
    }

    private static void printEdge(TreeNode left) {
        TreeNode tail = reverseEdge(left);
        TreeNode cur = tail;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    private static TreeNode reverseEdge(TreeNode tail) {
        TreeNode prev = null;
        TreeNode next;
        while (tail != null) {
            next = tail.right;

            tail.right = prev;

            prev = tail;

            tail = next;
        }
        return prev;
    }

}
