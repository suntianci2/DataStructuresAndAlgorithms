package LeetCode.Leet500_599.Leet530_539.Leet530;

/**
 * @ClassName Solution_3
 * @Author 孙天赐
 * @Date 2025/3/11 16:55
 * @Description TODO: 方法三   中序遍历（递归）    0ms 100%
 *                  方法二的递归版本，思路一致
 */
class Solution_3 {
    int result = Integer.MAX_VALUE;
    TreeNode prevNode = null;  // 前一个节点

    public int getMinimumDifference(TreeNode root) {
        doInorder(root);
        return result;
    }

    public void doInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        // 答案最小为1，不可能小于1
        if (result == 1) {
            return;
        }
        // 左
        doInorder(node.left);

        // 中
        if (prevNode != null && node.val - prevNode.val < result) {
            result = node.val - prevNode.val;
        }
        prevNode = node;

        // 右
        doInorder(node.right);
    }
}