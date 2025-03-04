package LeetCode.Leet400_499.Leet400_409.Leet_404;

import java.util.LinkedList;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/3 17:15
 * @Description TODO: 方法一   中序遍历（迭代+栈）  0ms 100%
 */
class Solution_1 {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode thisNode = root;
        while (thisNode != null || !stack.isEmpty()) {
            if (thisNode != null) {
                stack.push(thisNode);
                thisNode = thisNode.left; // 左
            } else {
                TreeNode temp = stack.pop();
                // 中，若左孩子为叶子节点，则记录值
                if (temp.left != null && temp.left.left == null && temp.left.right == null) {
                    sum += temp.left.val;
                }
                thisNode = temp.right;  // 右
            }
        }
        return sum;
    }
}
