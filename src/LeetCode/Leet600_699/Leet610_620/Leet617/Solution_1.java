package LeetCode.Leet600_699.Leet610_620.Leet617;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/8 17:03
 * @Description TODO: 方法一   递归  0ms 100%
 */
class Solution_1 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 有且仅有一个节点为null的话，把就保留另一个节点
        // 两个节点都为null的话，就返回null
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        // 以root1的树为基准，将root2的树覆盖到root1的树中
        root1.val += root2.val;
        // 递归构造左子树
        root1.left = mergeTrees(root1.left, root2.left);
        // 递归构造右子树
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
