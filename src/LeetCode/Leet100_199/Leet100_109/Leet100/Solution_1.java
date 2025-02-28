package LeetCode.Leet100_199.Leet100_109.Leet100;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/21 13:02
 * @Description TODO: 方法一   递归  0ms 100%
 */
class Solution_1 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            // 两个节点都为null，则树一样
            return true;
        } else if (p == null || q == null) {
            // 若有一个节点为null。另一个节点不为null，则树不一样
            return false;
        } else {
            // 两个节点都存在
            // 若两个节点值不同，则树不一样
            if (p.val != q.val) {
                return false;
            }
            // 判断两个节点的左子树是否一样，若不一样，则树不一样
            if (!isSameTree(p.left, q.left)) {
                return false;
            }
            // 判断两个节点的右子树是否一样，若不一样，则树不一样
            if (!isSameTree(p.right, q.right)) {
                return false;
            }
        }
        return true;
    }
}
