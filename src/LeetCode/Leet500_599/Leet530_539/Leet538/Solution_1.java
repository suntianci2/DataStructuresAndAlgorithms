package LeetCode.Leet500_599.Leet530_539.Leet538;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/16 16:27
 * @Description TODO: 方法一    递归 0ms 100%
 *                  反向中序遍历，记录经过的节点的和（包括当前节点本身），当前节点值更新为该和（经过的节点的值，肯定都大于等于当前节点值）
 */
class Solution_1 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 右
        convertBST(root.right);

        // 中
        // 记录经过的节点的和
        sum = sum + root.val;
        // 当前节点值更新为该和（经过的节点的值，肯定都大于等于当前节点值，因为是反向中序遍历）（包括当前节点本身）
        root.val = sum;

        // 左
        convertBST(root.left);

        return root;
    }
}
