package LeetCode.Leet200_299.Leet220_229.Leet222;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/2/26 20:07
 * @Description TODO: 方法二   递归优化    0ms 100%
 *                  利用满二叉树的性质，当递归到某一节点时，该节点下的树为满二叉树，则可以直接根据公式计算，不需要再递归了
 */
class Solution_2 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 如果以当前节点为根的树是满二叉树，则当前树的节点个数为 2^深度 - 1，无需再递归
        // 向左遍历的深度
        int leftDepth = getLeftDepth(root);
        // 向右遍历的深度
        int rightDepth = getRightDepth(root);
        // 如果向左遍历的深度等于向右遍历的深度，说明以当前节点为根的树是满二叉树
        if (leftDepth == rightDepth) {
            return (int) (Math.pow(2, leftDepth) - 1);
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int getLeftDepth(TreeNode node) {
        int leftDepth = 0;
        while (node != null) {
            node = node.left;
            leftDepth++;
        }
        return leftDepth;
    }

    public int getRightDepth(TreeNode node) {
        int rightDepth = 0;
        while (node != null) {
            node = node.right;
            rightDepth++;
        }
        return rightDepth;
    }
}
