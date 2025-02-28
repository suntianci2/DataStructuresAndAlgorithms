package LeetCode.Leet100_199.Leet100_109.Leet101;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/20 15:32
 * @Description TODO: 方法一   递归  0ms 100%
 */
class Solution_1 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    // 判断以两个节点为根的树是否对称
    public boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        // 判断节点1的左子树与节点2的右子树是否对称
        if (!isSymmetric(node1.left, node2.right)) {
            return false;
        }
        // 判断节点1的右子树与节点2的左子树是否对称
        if (!isSymmetric(node1.right, node2.left)) {
            return false;
        }
        // 判断当前两个节点值是否相等
        if (node1.val == node2.val) {
            return true;
        } else {
            return false;
        }

    }
}
