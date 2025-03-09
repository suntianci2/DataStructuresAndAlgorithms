package LeetCode.Leet600_699.Leet650_659.Leet654;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/8 14:47
 * @Description TODO: 方法一   递归  2ms 97.70%
 */
class Solution_1 {
    int[] nums; // 将数组提升为全局变量，减少数组的创建

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return doConstructMaximumBinaryTree(0, nums.length - 1);
    }

    // 递归构建最大二叉树。参数startIndex表示当前要构建的子树的起始位置，参数endIndex表示当前要构建的子树的终止位置
    public TreeNode doConstructMaximumBinaryTree(int startIndex, int endIndex){
        if(startIndex > endIndex){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        // 寻找当前数组范围内的最大值，作为根节点值
        for(int i = startIndex;i <= endIndex;i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        int val = nums[maxIndex];
        // 构建当前节点
        TreeNode node = new TreeNode(val);
        // 递归构建左右子树
        node.left = doConstructMaximumBinaryTree(startIndex, maxIndex - 1);
        node.right = doConstructMaximumBinaryTree(maxIndex + 1, endIndex);
        return node;
    }
}
