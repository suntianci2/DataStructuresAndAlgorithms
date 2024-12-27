package BasicDataStructures.Tree.TreeTraversal;

import BasicDataStructures.Tree.TreeNode;

import java.util.LinkedList;

// 非递归实现树的前、中、后序遍历
public class NonRecursiveTraversal {

    // 模拟遍历过程走过的路
    public static void TraversalRoad(TreeNode treeNode) {
        TreeNode thisNode = treeNode;
        // 用栈记录走过的路，方便向回走
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 节点不为空，或栈不为空，都进入循环
        while (thisNode != null || !stack.isEmpty()) {
            // 还没走到头，继续走
            if (thisNode != null) {
                stack.push(thisNode);
                System.out.print(thisNode.value + "\t");
                // 将当前节点修改为该节点的左孩子
                thisNode = thisNode.left;
                // 走到头了，开始往回走
            } else {
                TreeNode prevNode = stack.pop();
                System.out.print(prevNode.value + "\t");
                // 将当前节点修改为该节点的右孩子
                thisNode = prevNode.right;
            }

        }
    }

    // 前序遍历，在模拟路径TraversalRoad的基础上就可以实现
    public static void preOrder(TreeNode treeNode) {
        TreeNode thisNode = treeNode;
        // 用栈记录走过的路，方便向回走
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 节点不为空，或栈不为空，都进入循环
        while (thisNode != null || !stack.isEmpty()) {
            // 还没走到头，继续走
            if (thisNode != null) {
                stack.push(thisNode);
                // 打印前序遍历结果
                System.out.print(thisNode.value + "\t");
                // 将当前节点修改为该节点的左孩子
                thisNode = thisNode.left;
                // 走到头了，开始往回走
            } else {
                TreeNode prevNode = stack.pop();
                // 删除此行即可实现前序遍历
                // System.out.print(prevNode.value + "\t");
                // 将当前节点修改为该节点的右孩子
                thisNode = prevNode.right;
            }

        }
    }

    // 中序遍历，在模拟路径TraversalRoad的基础上就可以实现
    public static void inOrder(TreeNode treeNode) {
        TreeNode thisNode = treeNode;
        // 用栈记录走过的路，方便向回走
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 节点不为空，或栈不为空，都进入循环
        while (thisNode != null || !stack.isEmpty()) {
            // 还没走到头，继续走
            if (thisNode != null) {
                stack.push(thisNode);
                // 删除此行即可实现中序遍历
                // System.out.print(thisNode.value + "\t");
                // 将当前节点修改为该节点的左孩子
                thisNode = thisNode.left;
                // 走到头了，开始往回走
            } else {
                TreeNode prevNode = stack.pop();
                // 打印前序遍历结果
                System.out.print(prevNode.value + "\t");
                // 将当前节点修改为该节点的右孩子
                thisNode = prevNode.right;
            }

        }
    }

    // 后序遍历，在模拟路径TraversalRoad的基础上也可以实现
    public static void postOrder(TreeNode treeNode) {
        TreeNode thisNode = treeNode;
        // 用栈记录走过的路，方便向回走
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 记录上一个弹出的节点，便于分析某个节点的左右节点是否都已经处理完毕
        TreeNode prevPopNode = null;
        // 节点不为空，或栈不为空，都进入循环
        while (thisNode != null || !stack.isEmpty()) {
            // 还没走到头，继续走
            if (thisNode != null) {
                // 压入栈，便于寻找回来的路
                stack.push(thisNode);
                // System.out.print(thisNode.value + "\t");
                // 将当前节点修改为该节点的左孩子
                thisNode = thisNode.left;
                // 走到头了，开始往回走
            } else {
                // 前一个节点
                TreeNode prevNode = stack.peek();
                // 如果前一个节点的左右孩子都处理完毕，则弹出栈，
                if (prevNode.right == null || prevNode.right == prevPopNode) {
                    // 弹出节点，准备处理该节点
                    stack.pop();
                    // 记录上一次弹出的节点，便于后续使用
                    prevPopNode = prevNode;
                    System.out.print(prevNode.value + "\t");
                    // 否则，表示左孩子处理完毕了，但是右孩子还没有
                } else {
                    // 下一轮处理右孩子
                    thisNode = prevNode.right;
                }
            }

        }
    }

    // 通用遍历，根据遍历operation指定遍历方式。0：前序，1：中序，2：后续
    public static void order(Integer operation, TreeNode treeNode) {
        TreeNode thisNode = treeNode;
        // 用栈记录走过的路，方便向回走
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 记录上一个弹出的节点，便于分析某个节点的左右节点是否都已经处理完毕
        TreeNode prevPopNode = null;
        // 节点不为空，或栈不为空，都进入循环
        while (thisNode != null || !stack.isEmpty()) {
            // 还没走到头，继续走
            if (thisNode != null) {
                // 压入栈，便于寻找回来的路
                stack.push(thisNode);
                if (operation == 0) {
                    // 前序遍历输出值
                    System.out.print(thisNode.value + "\t");
                }
                // 将当前节点修改为该节点的左孩子
                thisNode = thisNode.left;
                // 走到头了，开始往回走
            } else {
                // 前一个节点
                TreeNode prevNode = stack.peek();
                // 前一个节点的没有右孩子
                if (prevNode.right == null) {
                    if (operation == 1) {
                        // 中序遍历输出值
                        System.out.print(prevNode.value + "\t");
                    }
                    // 弹出节点，准备处理该节点
                    stack.pop();
                    // 记录上一次弹出的节点，便于后续使用
                    prevPopNode = prevNode;
                    if (operation == 2) {
                        // 后序遍历输出值
                        System.out.print(prevNode.value + "\t");
                    }
                    // 前一个节点有右孩子，且已经处理过了
                } else if (prevNode.right == prevPopNode) {
                    // 弹出节点，准备处理该节点
                    stack.pop();
                    // 记录上一次弹出的节点，便于后续使用
                    prevPopNode = prevNode;
                    if (operation == 2) {
                        // 后序遍历输出值
                        System.out.print(prevNode.value + "\t");
                    }
                    // 前一个节点有右孩子，但是还没有处理过
                } else {
                    if (operation == 1) {
                        // 中序遍历输出值
                        System.out.print(prevNode.value + "\t");
                    }
                    // 下一轮处理右孩子
                    thisNode = prevNode.right;
                }
            }

        }
    }
}
