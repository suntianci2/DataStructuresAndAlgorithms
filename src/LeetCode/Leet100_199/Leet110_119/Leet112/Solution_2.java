package LeetCode.Leet100_199.Leet110_119.Leet112;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/3/4 20:08
 * @Description TODO: 方法二 广度优先遍历    1ms 13.11%
 *                      使用两个队列，一个队列用来广度优先遍历，另一个队列存放上一个队列中元素节点对应的路径和（根节点到该节点的路径和）
 */
class Solution_2 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        // 与上一个队列中的节点元素对应，使用一个队列存放根节点到每个节点的路径和（节点与值对应）
        Queue<Integer> sumQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        sumQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            int len = nodeQueue.size();
            for (int i = 0; i < len; i++) {
                TreeNode temp = nodeQueue.poll();
                int sum = sumQueue.poll();
                if (sum == targetSum && temp.left == null && temp.right == null) {
                    return true;
                }
                if (temp.left != null) {
                    nodeQueue.offer(temp.left);
                    // 存放左孩子的路径和
                    sumQueue.offer(sum + temp.left.val);
                }
                if (temp.right != null) {
                    nodeQueue.offer(temp.right);
                    // 存放右孩子的路径和
                    sumQueue.offer(sum + temp.right.val);
                }
            }
        }
        return false;
    }
}
