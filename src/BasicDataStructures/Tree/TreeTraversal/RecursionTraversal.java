package BasicDataStructures.Tree.TreeTraversal;

import BasicDataStructures.Tree.TreeNode;

// 递归实现树的前、中、后序遍历
public class RecursionTraversal {


    // 前序遍历
    public static void preOrder(TreeNode treeNode){
        // 递归终止条件
        if(treeNode == null){
            return;
        }

        // 先访问自身节点的值
        System.out.print(treeNode.value + "\t");

        // 然后访问左子树
        preOrder(treeNode.left);

        // 最后访问右子树
        preOrder(treeNode.right);
    }

    // 中序遍历
    public static void inOrder(TreeNode treeNode){
        // 递归终止条件
        if(treeNode == null){
            return;
        }

        // 先访问左子树
        inOrder(treeNode.left);

        // 然后访问自身节点的值
        System.out.print(treeNode.value + "\t");

        // 最后访问右子树
        inOrder(treeNode.right);
    }

    // 后序遍历
    public static void postOrder(TreeNode treeNode){
        // 递归终止条件
        if(treeNode == null){
            return;
        }

        // 先访问左子树
        postOrder(treeNode.left);

        // 然后访问右子树
        postOrder(treeNode.right);

        // 最后访问自身节点值
        System.out.print(treeNode.value + "\t");
    }
}
