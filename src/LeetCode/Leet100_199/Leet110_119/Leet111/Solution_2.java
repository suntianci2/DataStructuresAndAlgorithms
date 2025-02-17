package LeetCode.Leet100_199.Leet110_119.Leet111;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/2/16 10:42
 * @Description TODO: 方法二   深度有限遍历（递归）  8ms 57.04%
 *                  节点最小深度 = min(左子树最小深度，右子树最小深度) + 1
 */
class Solution_2 {
    public int minDepth(TreeNode root) {
        // 没有该节点
        if (root == null) {
            return 0;
        }
        // 节点既没有左子树也没有右子树，则节点深度为1
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 节点没有左子树，则最小深度为右子树最小深度 + 1
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        // 节点没有右子树，则最小深度为左子树最小深度 + 1
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        // 节点既有左子树，也有右子树，则最小深度为 min(左子树最小深度，右子树最小深度) + 1
        // 左子树的最小深度
        int leftMinDepth = minDepth(root.left);
        // 右子树的最小深度
        int rightMinDepth = minDepth(root.right);
        // 当前节点的最小深度
        return leftMinDepth < rightMinDepth ? leftMinDepth + 1 : rightMinDepth + 1;
    }
}
