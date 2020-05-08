package com.moonlight.algorithm.tree;

/**
 * @ClassName BinaryTreeMaxDistance
 * @Description: 求整颗二叉树的最大距离。
 *               设节点A到节点B的距离即为树的最大距离，
 *               可知存在A到B经过根节点root和A到B不经过根节点root两种情况
 *               A到B不经过根节点root：即A和B都是在一颗子树上，则最大距离为左树最大距离和右树最大距离中两者较大的
 *               A到B经过根节点root：即A和B不在一颗子树上，则最大距离为左树高度 + 右树高度
 *               由上，最大距离应为 Max((左树最大距离和右树最大距离中两者较大的), (左树高度 + 右树高度))
 * @Author Moonlight
 * @Date 2020/5/8 22:48
 * @Version V1.0
 **/
public class BinaryTreeMaxDistance {

    public static void main (String[] args) {
        System.out.println(maxDistance(Node.getTree()));
    }

    public static int maxDistance(Node root){
        return findMaxDistance(root).maxDistance;
    }

    private static Info findMaxDistance(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = findMaxDistance(root.left);
        Info rightInfo = findMaxDistance(root.right);
        int maxDistance = Math.max(Math.max(leftInfo.maxDistance, rightInfo.maxDistance), (leftInfo.height + rightInfo.height + 1));

        return new Info(maxDistance, (Math.max(leftInfo.height, rightInfo.height)) + 1);
    }

    static class Info{
        private int maxDistance, height;
        public Info (int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }
}
