package LeetCode.Leet100_199.Leet110_119.Leet110;

import java.util.HashMap;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/28 15:02
 * @Description TODO: 方法一   递归  0ms 100%
 */
class Solution_1 {
    public boolean isBalanced(TreeNode root) {
        // 如果高度为-1，说明出现了不平衡
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 计算左子树高度，如果为-1，直接返回
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        // 计算右子树高度，如果为-1，直接返回
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        // 计算当前节点高度
        // 如果当前节点平衡，则返回高度，如果不平衡，返回-1
        if (leftHeight - rightHeight <= 1 && leftHeight - rightHeight >= -1) {
            return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
        }
        return -1;
    }
}
