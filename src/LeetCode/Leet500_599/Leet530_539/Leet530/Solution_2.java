package LeetCode.Leet500_599.Leet530_539.Leet530;

import java.util.Stack;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/3/11 16:50
 * @Description TODO: 方法二   中序遍历（迭代）    2ms 18.25%
 *                  中序遍历二叉搜索树，得到的是一个升序数组
 *                  因此，我们可以在中序遍历的过程中，记录前一个节点，
 *                  然后计算当前节点与前一个节点的差值，取最小值即可
 *                  当答案为1时，不需要再遍历了，因为不会出现比1更小的差值了
 */
class Solution_2 {
    public int getMinimumDifference(TreeNode root) {
        int result = Integer.MAX_VALUE;
        TreeNode prevNode = null;  // 前一个节点
        TreeNode thisNode = root;
        Stack<TreeNode> stack = new Stack<>();
        while (thisNode != null || !stack.isEmpty()) {
            if (thisNode != null) {
                // 左
                stack.push(thisNode);
                thisNode = thisNode.left;
            } else {
                // 中
                TreeNode temp = stack.pop();
                if (prevNode != null && temp.val - prevNode.val < result) {
                    result = temp.val - prevNode.val;
                }
                // 答案最小为1，不可能小于1
                if (result == 1) {
                    return 1;
                }
                prevNode = temp;
                // 右
                thisNode = temp.right;
            }
        }
        return result;
    }
}
