package com.moonlight.algorithm.tree;

/**
 * @ClassName BinaryTreeSuccessorNode
 * @Description: 找后继，前驱类似
 * @Author Moonlight
 * @Date 2020/5/8 21:29
 * @Version V1.0
 **/
public class BinaryTreeSuccessorNode {

    public static void main(String[] args){
        System.out.println(findSuccessorNode(Node.getTreeHaveParentNode().right).val);
    }

    public static Node findSuccessorNode(Node any){
        if (any == null) {
            return null;
        }
        // 对于左孩子而言，它的父节点就是后继节点
        // 对于右孩子而言，当当前节点有右子树时，那么当前节点的后继节点一定在它的右子树上，即为右子树的最左边
        // 当当前结点没有右子树，那么就依次往上找，找到当前节点是它的父亲节点的左孩子的时候，那么这个父亲节点就是当前节点的后继节点
        Node successorNode = null;
        if (any.right != null) {
            successorNode = findLeftmost(any.right);
        } else {
            successorNode = any.parent;
            while (successorNode != null && successorNode.left != any) {
                any = successorNode;
                successorNode = any.parent;
            }
        }
        return successorNode;
    }

    private static Node findLeftmost(Node right) {
        if (right == null) {
            return null;
        }
        while (right.left != null) {
            right = right.left;
        }
        return right;
    }


}
