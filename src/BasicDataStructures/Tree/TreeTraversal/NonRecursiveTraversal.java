package BasicDataStructures.Tree.TreeTraversal;

import BasicDataStructures.Tree.TreeNode;

import java.util.LinkedList;

// 非递归实现树的前、中、后序遍历
public class NonRecursiveTraversal {

    // 模拟遍历过程走过的路
    public static void TraversalRoad(TreeNode treeNode){
        TreeNode thisNode = treeNode;
        // 用栈记录走过的路，方便向回走
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 节点不为空，或栈不为空，都进入循环
        while(thisNode != null || !stack.isEmpty()){
            // 还没走到头，继续走
            if(thisNode != null){
                stack.push(thisNode);
                System.out.println(thisNode.value);
                // 将当前节点修改为该节点的左孩子
                thisNode = thisNode.left;
            // 走到头了，开始往回走
            }else{
                TreeNode prevNode = stack.pop();
                System.out.println(prevNode.value);
                // 将当前节点修改为该节点的右孩子
                thisNode = prevNode.right;
            }

        }
    }
}
