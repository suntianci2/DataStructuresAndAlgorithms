package LeetCode.Leet100_199.Leet110_119.Leet112;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/4 19:23
 * @Description TODO: 方法一   递归+回溯   0ms 100%
 */
class Solution_1 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int val = root.val;
        // 找到答案
        if (targetSum == val && root.left == null && root.right == null) {
            return true;
        }
        // 往左子树和右子树寻找答案（targetSum减去当前节点的值），隐含了回溯
        return hasPathSum(root.left, targetSum - val) || hasPathSum(root.right, targetSum - val);
    }
}
