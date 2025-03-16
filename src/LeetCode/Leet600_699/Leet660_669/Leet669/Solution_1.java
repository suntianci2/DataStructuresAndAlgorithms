package LeetCode.Leet600_699.Leet660_669.Leet669;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/15 13:55
 * @Description TODO: 方法一    递归 0ms 100%
 *                    思路：
 *                      1. 如果当前节点的值小于最小值，则去右子树中修剪，返回右子树修剪结果
 *                      2. 如果当前节点的值大于最大值，则去左子树中修剪，返回左子树修剪结果
 *                      3. 如果当前节点的值在范围内，则递归修建左子树和右子树，并返回当前节点
 */
class Solution_1 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        int val = root.val;
        if (val < low) {
            // 当前节点值小于最小值，则去右子树中修剪（当前节点须丢弃，而直接return右子树修剪结果，隐含了丢弃该节点）
            return trimBST(root.right, low, high);
        } else if (val > high) {
            // 当前节点值大于最大值，则去左子树中修剪（当前节点须丢弃，而直接return左子树修剪结果，隐含了丢弃该节点）
            return trimBST(root.left, low, high);
        } else {
            // 当前节点值在范围内，则递归修建左子树和右子树
            // 当前节点须保留，所以设置了当前节点的左右子树为修剪后的结果，并返回了当前节点
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
}