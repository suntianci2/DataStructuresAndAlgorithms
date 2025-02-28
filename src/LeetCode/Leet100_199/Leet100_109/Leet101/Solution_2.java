package LeetCode.Leet100_199.Leet100_109.Leet101;

import java.util.LinkedList;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/2/20 15:53
 * @Description TODO: 方法二   迭代+栈（也可以用队列）  1ms 16.65
 */
class Solution_2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root.left != null) {
            stack.push(root.left);
        }
        if (root.right != null) {
            stack.push(root.right);
        }
        while (!stack.isEmpty()) {
            // 对称轴左侧节点leftNode
            TreeNode leftNode = stack.pop();
            // 弹出一个元素后栈空了，也不对称（表明此时节点个数为奇数个）
            if (stack.isEmpty()) {
                return false;
            }
            // 对称轴右侧节点rightNode
            TreeNode rightNode = stack.pop();

            // 若两个节点都为null，则进入下一循环
            if (leftNode == null && rightNode == null) {
                continue;
            }

            // 如果其中一个节点为null，则不对称了
            if (((leftNode != null && rightNode == null) || (leftNode == null && rightNode != null))) {
                return false;
            }

            // 当两个节点值不一样，则也不对称了
            if (leftNode.val != rightNode.val) {
                return false;
            }

            // 加入leftNode的左孩子和rightNode的右孩子（对称节点）
            stack.push(leftNode.left);
            stack.push(rightNode.right);
            // 加入leftNode的右孩子和rightNode的左孩子（对称节点）
            stack.push(leftNode.right);
            stack.push(rightNode.left);
        }

        // 当栈为空时，表明树对称
        return true;
    }
}