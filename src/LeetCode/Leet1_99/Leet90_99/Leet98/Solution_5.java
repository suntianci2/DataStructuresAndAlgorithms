package LeetCode.Leet1_99.Leet90_99.Leet98;

/**
 * @ClassName Solution_5
 * @Author 孙天赐
 * @Date 2025/3/10 21:10
 * @Description TODO: 方法五   中序遍历（递归）
 *                  方法四的递归版本，通过递归实现中序遍历，在遍历的过程中就可以判断是否满足二叉搜索树的条件
 *                  全局变量prevValue记录中序遍历前一个节点的值，用于在遍历过程中当条件不满足时提前退出循环
 */
class Solution_5 {
    long prevValue = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        if (!isValidBST(root.left)) {
            return false;
        }

        // 中
        if (root.val <= prevValue) {
            return false;
        }
        prevValue = root.val;

        // 右
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}
