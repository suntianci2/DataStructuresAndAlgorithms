package LeetCode.Leet500_599.Leet510_519.Leet513;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/3/3 20:32
 * @Description TODO: 方法二   递归+回溯   1ms 88.68%
 */
class Solution_2 {
    int maxDepth = 0;
    int finalResult;
    public int findBottomLeftValue(TreeNode root) {
        int depth = 0;
        doFindBottomLeftValue(root, depth + 1);
        return finalResult;
    }

    public void doFindBottomLeftValue(TreeNode node, int depth){
        if(node == null){
            return;
        }

        // 记录最深的结果
        if(depth > maxDepth){
            maxDepth = depth;
            finalResult = node.val;
        }

        // 先从左子树中寻找，找到的一定是最底层最左边的
        // 在左子树中寻找结果，隐含了回溯
        doFindBottomLeftValue(node.left, depth + 1);
        // 在右子树中寻找结果，隐含了回溯
        doFindBottomLeftValue(node.right, depth + 1);
    }
}
