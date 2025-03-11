package LeetCode.Leet1_99.Leet90_99.Leet98;

/**
 * @ClassName Solution_6
 * @Author 孙天赐
 * @Date 2025/3/10 21:26
 * @Description TODO: 方法六   常规递归    0ms 100%
 *                  对于每个节点，只需要判断其左右子树的所有节点值是否在指定区间内
 *                  1.对于左右子树的根节点，如果其值在指定区间内，继续递归判断其的左右子树是否在指定区间内
 *                  2.如果不在指定区间内，直接返回false
 *                  3.如果当前节点为null，直接返回true
 *                  4.对于根节点，指定区间为Long.MIN_VALUE和Long.MAX_VALUE
 */
class Solution_6 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // 判断当前节点下的树的所有值是否在min和max之间（开区间）
    public boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        // 递归检查左子树和右子树是否在指定区间内。左子树：(min, 当前节点值)   右子树：(当前节点值, max)
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}
