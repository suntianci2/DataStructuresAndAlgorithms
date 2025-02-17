package LeetCode.Leet100_199.Leet100_109.Leet104;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/2/16 10:18
 * @Description TODO: 方法二   深度优先遍历（递归）  0ms 100%
 *                  当前节点最大深度 = max(左子树最大深度，右子树最大深度) + 1
 */
class Solution_2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 求左子树最大深度
        int leftMaxDepth = maxDepth(root.left);

        // 求右子树最大深度
        int rightMaxDepth = maxDepth(root.right);

        // 得到当前节点最大深度
        return leftMaxDepth > rightMaxDepth ? leftMaxDepth + 1 : rightMaxDepth + 1;
    }
}
