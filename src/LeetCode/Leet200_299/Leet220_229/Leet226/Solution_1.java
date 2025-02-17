package LeetCode.Leet200_299.Leet220_229.Leet226;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/17 16:39
 * @Description TODO: 方法一   递归  0ms 100%
 */
class Solution_1 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        // 递归翻转右子树，赋给左孩子
        root.left = invertTree(root.right);
        // 递归翻转左子树，赋给右孩子
        root.right = invertTree(temp);
        return root;
    }
}
