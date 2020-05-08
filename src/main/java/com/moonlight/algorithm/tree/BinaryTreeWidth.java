package com.moonlight.algorithm.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @ClassName BinaryTreeWidth
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/7 20:34
 * @Version V1.0
 **/
public class BinaryTreeWidth {

    public static void main (String[] args) {
        WidthTraversal(Node.getTree());
        System.out.println("           ");

        System.out.println(maxWidth(Node.getTree()));
        System.out.println("           ");

        System.out.println(maxWidthLowSpace(Node.getTree()));
        System.out.println("           ");

    }


    public static void WidthTraversal(Node root){
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.println("node val：" + root.val);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
    }

    public static int maxWidth(Node root){
        if (root == null) {
            return 0;
        }
        // 用于遍历树
        Queue<Node> queue = new LinkedList<>();
        // 用于记录节点及节点所在的层
        Map<Node, Integer> nodeLevelMap = new HashMap<>();
        // curNodeLevel：当前节点所在的层，只有当这一层所有的节点都遍历完了，才进行结算
        // curLevel：当前所在的层    max：记录节点最多的层有多少节点    curLevelNodeCount：当前层节点个数统计，当整层都遍历完了，就置为 1
        int curNodeLevel = 0, curLevel = 1, max = 0, curLevelNodeCount = 0;

        nodeLevelMap.put(root, 1);
        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.poll();
            curNodeLevel = nodeLevelMap.get(root);
            if (root.left != null) {
                queue.add(root.left);
                nodeLevelMap.put(root.left, curNodeLevel + 1);
            }
            if (root.right != null) {
                queue.add(root.right);
                nodeLevelMap.put(root.right, curNodeLevel + 1);
            }

            if (curNodeLevel == curLevel) {
                curLevelNodeCount++;
            } else {
                curLevel++;
                max = Math.max(max, curLevelNodeCount);
                curLevelNodeCount = 1;
            }
        }
        // 在循环中，只有当整层都遍历完毕，且后面还有层时，才会更新max，所以此处需要再更新一次max
        max = Math.max(max, curLevelNodeCount);
        return max;
    }

    /**
     * @Author Moonlight
     * @Description 用一个变量记录当前层的最右节点curLevelEnd，一个变量记录下一层的最右节点nextLevelEnd，
     *              记录每层的节点数curLevelNodeCounts，遍历完整层后根据curLevelNodeCounts更新max，
     *              并重置curLevelNodeCounts为0，将curLevelEnd指向nextLevelEnd
     * @Date 2020/5/7 21:38
     * @Param
     * @Exception
     * @return
     * @version
     **/
    public static int maxWidthLowSpace(Node root){
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        Node curLevelEnd = root, nextLevelEnd = null;
        int max = 0, curLevelNodeCounts = 0;

        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.left != null) {
                queue.add(root.left);
                nextLevelEnd = root.left;
            }
            if (root.right != null) {
                queue.add(root.right);
                nextLevelEnd = root.right;
            }
            curLevelNodeCounts++;
            if (root == curLevelEnd) {
                max = Math.max(max, curLevelNodeCounts);
                curLevelEnd = nextLevelEnd;
                curLevelNodeCounts = 0;
            }
        }
        return max;
    }

}
