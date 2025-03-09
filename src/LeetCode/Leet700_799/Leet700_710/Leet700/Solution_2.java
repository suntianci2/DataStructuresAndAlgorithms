package LeetCode.Leet700_799.Leet700_710.Leet700;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/3/9 10:06
 * @Description TODO: 方法二  递归  0ms 100%
 *                  同样是使用二叉搜索树的性质解决问题
 */
class Solution_2 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        // 相等即找到
        if (val == root.val) {
            return root;
            // 要找的值小于当前节点值，则在左子树中寻找
        } else if (val < root.val) {
            return searchBST(root.left, val);
            // 要找的值大于当前节点值，则在右子树中寻找
        } else {
            return searchBST(root.right, val);
        }
    }
}
