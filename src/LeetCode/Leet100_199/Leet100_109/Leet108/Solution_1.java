package LeetCode.Leet100_199.Leet100_109.Leet108;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/16 14:28
 * @Description TODO: 方法一    递归 0ms 100%
 *                  每次取数组的中间节点作为根节点，然后递归构建左子树和右子树
 */
class Solution_1 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBST(nums, 0, nums.length - 1);
    }

    // 根据nums数组中[startIndex, endIndex]范围内的元素，构建二叉搜索树，并返回根节点
    public TreeNode arrayToBST(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        if (startIndex == endIndex) {
            return new TreeNode(nums[startIndex]);
        }
        // 找到范围内的中间节点（如果节点个数为偶数个，则取中间靠右侧节点为中间节点）
        int middleIndex = startIndex + (endIndex - startIndex + 1) / 2;
        // 将中间节点作为根节点
        TreeNode root = new TreeNode(nums[middleIndex]);
        // 递归构建左子树和右子树
        root.left = arrayToBST(nums, startIndex, middleIndex - 1);
        root.right = arrayToBST(nums, middleIndex + 1, endIndex);
        // 返回当前根节点
        return root;
    }
}
