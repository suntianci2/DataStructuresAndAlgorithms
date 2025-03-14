package LeetCode.Leet200_299.Leet230_239.Leet235;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/3/13 13:32
 * @Description TODO: 方法二   递归  6ms   99.88%
 *                  方法一的递归版本，思路与方法一一致
 */
class Solution_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val && q.val < root.val) {
            // 情况1：目标节点值均小于当前节点，递归去左子树中查找
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            // 情况2：目标节点值均大于当前节点，递归去右子树中查找
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // 情况3：当前节点值等于其中一个目标节点
            // 情况4：一个目标节点值小于当前节点，另一个目标节点大于当前节点
            return root;
        }
    }
}
