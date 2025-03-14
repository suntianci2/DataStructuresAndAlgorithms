package LeetCode.Leet200_299.Leet230_239.Leet235;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/13 13:27
 * @Description TODO: 方法一   迭代  6ms   99.88%
 *                  利用二叉搜索树的性质，从根节点开始遍历
 *                  1. 如果目标节点值均小于当前节点，则下次循环去左子树中查找
 *                  2. 如果目标节点值均大于当前节点，则下次循环去右子树中查找
 *                  3. 如果当前节点为其中一个节点，则另一个节点肯定在下面，当前节点为最近公共祖先
 *                  4. 如果目标节点值一个小于当前节点，另一个大于当前节点，则当前节点为最近公共祖先
 *                  时间复杂度为O(n)，空间复杂度为O(1)
 */
class Solution_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode thisNode = root;
        while (thisNode != null) {
            if (p.val < thisNode.val && q.val < thisNode.val) {
                // 情况1：目标节点值均小于当前节点，下次循环去左子树中查找
                thisNode = thisNode.left;
            } else if (p.val > thisNode.val && q.val > thisNode.val) {
                // 情况2：目标节点值均大于当前节点，下次循环去右子树中查找
                thisNode = thisNode.right;
            } else {
                // 情况3：当前节点值等于其中一个目标节点
                // 情况4：一个目标节点值小于当前节点，另一个目标节点大于当前节点
                return thisNode;
            }
        }
        return null;
    }
}