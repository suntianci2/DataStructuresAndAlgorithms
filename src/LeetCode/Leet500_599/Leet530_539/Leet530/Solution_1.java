package LeetCode.Leet500_599.Leet530_539.Leet530;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/11 9:55
 * @Description TODO: 方法一  递归  0ms 100%
 *                  对于每个节点，递归判断其左右子树中的最小差值，并判断当前节点与左子树的最大值和右子树的最小值的差值是否为最小值
 */
class Solution_1 {
    int result = Integer.MAX_VALUE; // 存放答案

    public int getMinimumDifference(TreeNode root) {
        getMinDifference(root);
        return result;
    }

    public void getMinDifference(TreeNode node) {
        // 递归终止条件
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        // 如果左孩子不为空，则递归左子树寻找答案，并且判断当前节点与左子树最大值的差值是否为最小值
        if (node.left != null) {
            getMinDifference(node.left);
            int leftMax = getMax(node.left);  // 左子树的最大值
            if (node.val - leftMax < result) {
                result = node.val - leftMax;
            }
        }
        // 如果右孩子不为空，则递归右子树寻找答案，并且判断当前节点与右子树最小值的差值是否为最小值
        if (node.right != null) {
            getMinDifference(node.right);
            int rightMin = getMin(node.right);  // 右子树的最小值
            if (rightMin - node.val < result) {
                result = rightMin - node.val;
            }
        }
    }

    // 寻找指定树下的最小值（树最左侧的节点值）
    public int getMin(TreeNode node) {
        TreeNode thisNode = node;
        while (thisNode.left != null) {
            thisNode = thisNode.left;
        }
        return thisNode.val;
    }

    // 寻找指定树下的最大值（树最右侧的节点值）
    public int getMax(TreeNode node) {
        TreeNode thisNode = node;
        while (thisNode.right != null) {
            thisNode = thisNode.right;
        }
        return thisNode.val;

    }
}