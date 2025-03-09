package LeetCode.Leet1_99.Leet90_99.Leet98;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/9 12:54
 * @Description TODO: 方法一   递归  4ms 3.85%
 *                  自顶向下双层递归。效率低，因为每次都要遍历整个子树，多了很多重复计算
 */
class Solution_1 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 节点的左子树只包含 小于 当前节点的数。
        if (!isMax(root.left, root.val)) {
            return false;
        }
        // 节点的右子树只包含 大于 当前节点的数。
        if (!isMin(root.right, root.val)) {
            return false;
        }
        // 所有左子树和右子树自身必须也是二叉搜索树
        return isValidBST(root.left) && isValidBST(root.right);

    }

    // 判断节点子树是否只包含小于当前节点的数
    public boolean isMax(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        return node.val < val && isMax(node.left, val) && isMax(node.right, val);
    }

    // 判断节点子树是否只包含大于当前节点的数
    public boolean isMin(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        return node.val > val && isMin(node.left, val) && isMin(node.right, val);
    }
}
