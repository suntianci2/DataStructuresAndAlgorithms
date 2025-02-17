package LeetCode.Leet100_199.Leet110_119.Leet111;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/16 10:39
 * @Description TODO: 方法一   广度优先遍历（迭代+队列）   2ms 96.85%
 */
class Solution_1 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            minDepth++;
            // 当前层节点个数
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode thisNode = queue.poll();
                // 如果当前节点既不存在左孩子，也不存在右孩子，则找到了最小深度
                if (thisNode.left == null && thisNode.right == null) {
                    return minDepth;
                }
                // 将左右孩子添加到队列中
                if (thisNode.left != null) {
                    queue.offer(thisNode.left);
                }
                if (thisNode.right != null) {
                    queue.offer(thisNode.right);
                }
            }
        }
        return minDepth;
    }
}
