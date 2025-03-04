package LeetCode.Leet100_199.Leet100_109.Leet104;

/**
 * @ClassName Solution_3
 * @Author 孙天赐
 * @Date 2025/3/3 16:51
 * @Description TODO: 方法三   前序遍历（递归+回溯） 0ms 100%
 */
class Solution_3 {
    int max = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        getDepth(root, depth);
        return max;
    }

    public void getDepth(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        // 更新最大深度  中
        if (depth > max) {
            max = depth;
        }
        // 递归左子树，孩子深度+1，此处隐含了回溯  左
        getDepth(node.left, depth + 1);
        // 递归右子树，孩子深度+1，此处隐含了回溯  右
        getDepth(node.right, depth + 1);
    }
}
