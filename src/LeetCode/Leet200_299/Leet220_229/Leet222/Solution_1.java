package LeetCode.Leet200_299.Leet220_229.Leet222;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/26 11:25
 * @Description TODO: 方法一   递归  0ms 100%
 *                   通用方法，树节点个数=左子树节点个数+右子树节点个数+1
 */
class Solution_1 {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
