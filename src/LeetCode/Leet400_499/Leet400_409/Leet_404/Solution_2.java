package LeetCode.Leet400_499.Leet400_409.Leet_404;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/3/3 18:19
 * @Description TODO: 方法二   递归  0ms 100%
 */
class Solution_2 {
    public int sumOfLeftLeaves(TreeNode root) {
        // 终止条件1
        if (root == null) {
            return 0;
        }
        int leftValue = 0;
        // 寻找左子树结果
        // 情况一：如果左孩子为叶子节点（终止条件2：左孩子为叶子节点）
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftValue = root.left.val;
        } else {
            // 情况2：否则，递归寻找左子树的结果
            leftValue = sumOfLeftLeaves(root.left);
        }
        // 递归寻找右子树的结果
        int rightValue = sumOfLeftLeaves(root.right);
        // 左右子树的结果返回
        return leftValue + rightValue;
    }
}