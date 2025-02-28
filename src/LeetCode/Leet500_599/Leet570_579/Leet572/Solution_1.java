package LeetCode.Leet500_599.Leet570_579.Leet572;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/21 15:58
 * @Description TODO: 方法一   递归  4ms 90.05%
 */
class Solution_1 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            // 子树为null，必存在
            return true;
        } else if (root == null) {
            // 子树不为null，主树为null，必不存在
            return false;
        }
        if (isSametree(root, subRoot)) {
            // 如果当前树与子树一样，则找到答案
            return true;
        } else {
            // 否则，递归在左右子树寻找答案
            if (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)) {
                return true;
            } else {
                return false;
            }
        }
    }

    // 判断node1树和node2树是否一样（结构、数值都一样）
    public boolean isSametree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        } else {
            return isSametree(node1.left, node2.left) && isSametree(node1.right, node2.right);
        }
    }
}
