package LeetCode.Leet700_799.Leet700_710.Leet701;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/3/13 19:57
 * @Description TODO: 方法二   递归   0ms 100%
 *                  利用二叉搜索树的性质，寻找插入的位置，思路与方法一一致。
 *                  不同的是，递归是判断当前节点的左右孩子是否为空，为空且满足平衡二叉树规则，则说明当前节点是待插入节点的父亲。不为空则递归进孩子节点。
 *                  而迭代是不管左右孩子是否为空，都会继续迭代，直到迭代到null，说明之前一个节点为待插入节点的父亲
 */
class Solution_2 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 二叉树为空，则该节点为根节点
        if (root == null) {
            return new TreeNode(val);
        }
        // 1.值小于当前节点值，且当前节点不存在左孩子
        if (root.left == null && val < root.val) {
            root.left = new TreeNode(val);
        } else if (root.right == null && val > root.val) {
            // 2.值大于当前节点值，且当前节点不存在右孩子
            root.right = new TreeNode(val);
        } else if (val < root.val) {
            // 3.值小于当前节点值，且当前节点存在左孩子（不需要考虑返回值，没有意义）
            insertIntoBST(root.left, val);
        } else {
            // 4.值大于当前节点值，且当前节点存在右孩子（不需要考虑返回值，没有意义）
            insertIntoBST(root.right, val);
        }
        // 除了二叉树为空的情况根节点会改变，别的情况根节点都不会发生改变，所以直接返回根节点
        return root;
    }
}