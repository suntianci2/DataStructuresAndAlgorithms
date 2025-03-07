package LeetCode.Leet100_199.Leet100_109.Leet106;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/3/6 19:47
 * @Description TODO: 方法二 迭代（优化版）   2ms  91.74%
 *                  与方法一思路完全一致，但是进行了很大的优化，
 *                  1.使用了哈希表存储中序遍历结果的下标，这样在递归函数中，就不需要每次都遍历中序遍历结果数组了。
 *                  2.使用了一个全局变量 post_idx 记录当前子树的根节点在后序遍历结果数组中的下标，这样在递归函数中，就不需要每次都创建新的数组了。
 *                  3.使用了一个全局变量 idx_map 记录中序遍历结果数组中每个元素的下标，这样在递归函数中，就不需要每次都遍历中序遍历结果数组了。
 *
 */
class Solution_2 {

    // 记录当前子树的根节点在后序遍历结果数组中的下标
    int post_idx;

    // 记录后序遍历结果数组
    int[] postorder;

    // 记录中序遍历结果数组
    int[] inorder;

    // 存储中序遍历结果数组中每个元素的下标，以便快速查找元素的位置
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    // 递归函数
    // in_left 中序遍历结果数组的左边界
    // in_right 中序遍历结果数组的右边界
    // 返回当前子树的根节点
    public TreeNode helper(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);

        // 下标减一
        post_idx--;
        // 构造右子树
        root.right = helper(index + 1, in_right);
        // 构造左子树
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;

        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }

        return helper(0, inorder.length - 1);
    }
}
