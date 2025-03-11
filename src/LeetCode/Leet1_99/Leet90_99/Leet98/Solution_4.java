package LeetCode.Leet1_99.Leet90_99.Leet98;

import java.util.LinkedList;

/**
 * @ClassName Solution_4
 * @Author 孙天赐
 * @Date 2025/3/10 21:04
 * @Description TODO: 方法四 中序遍历优化2（迭代）  1ms 25.79%
 *                  将中序遍历前一个节点的值的类型由int改为long，这样的最小值要比Integer的最小值小，所以可以通过测试用例
 *                  此外，这种方法不再需要遍历整个树，而是在遍历的过程中就可以判断是否满足二叉搜索树的条件
 */
class Solution_4 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 中序遍历用的栈
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 当前访问的节点
        TreeNode thisNode = root;
        // 中序遍历前一个节点的值，用于在遍历过程中当条件不满足时提前退出循环
        long prevValue = Long.MIN_VALUE;

        while (thisNode != null || !stack.isEmpty()) {
            if (thisNode != null) {
                // 左
                stack.push(thisNode);
                thisNode = thisNode.left;
            } else {
                TreeNode temp = stack.pop();
                int val = temp.val;

                // 中
                // 提前退出循环的判断，当当前节点值小于等于前一节点值，则不满足二叉搜索树的条件了
                if (val <= prevValue) {
                    return false;
                }
                prevValue = val;

                // 右
                thisNode = temp.right;
            }
        }
        return true;
    }

}
