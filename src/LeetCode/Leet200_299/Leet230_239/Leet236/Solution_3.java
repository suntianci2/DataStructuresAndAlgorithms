package LeetCode.Leet200_299.Leet230_239.Leet236;

/**
 * @ClassName Solution_3
 * @Author 孙天赐
 * @Date 2025/3/12 16:17
 * @Description TODO: 方法三   常规递归（后序遍历）    7ms   99.68%
 *                  递归返回值为目标节点（p、q），或者是答案（最近公共祖先）
 *                  1. 如果当前节点为其中一个节点，且左右子树中存在另一个节点，则当前节点为最近公共祖先
 *                  2. 如果左右子树都包含目标节点，那么该节点就是最近公共祖先
 *                  3. 如果只有左子树或右子树包含目标节点，则直接将这个节点返回，此时这个节点可能是答案，也可能就是其中一个目标节点
 *                  4. 如果左右子树都不包含目标节点，且当前节点也不是目标节点，则直接返回null
 */
class Solution_3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果当前节点为其中一个目标节点
        if (root.val == p.val || root.val == q.val) {
            // 一共两种情况：
            // 1.如果左子树或右子树存在另一个目标节点，则当前目标节点即为最近公共祖先
            // 2.如果左子树或右子树不存在另一个目标节点，则当前节点就是第一个目标节点
            // 两种情况都直接返回这个节点即可
            return root;
        }
        // 否则，如果当前节点为不是目标节点
        // 如果左右子树返回值均不为null，则当前节点即为最近公共祖先
        if (left != null && right != null) {
            return root;
        }

        // 如果左子树为null，右子树不为null。则直接返回右子树结果
        if (left == null) {
            return right;
        }

        // 如果右子树为null，左子树不为null。则直接返回左子树结果
        if (right == null) {
            return left;
        }

        // 如果左右子树均为null，说明下面没有目标节点，则返回null
        return null;
    }
}
