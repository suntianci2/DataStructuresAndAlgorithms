package LeetCode.Leet100_199.Leet100_109.Leet104;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/16 10:17
 * @Description TODO: 方法一   广度优先遍历（迭代+队列）   1ms 21.04%
 */
class Solution_1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            maxDepth++;
            // 当前层节点个数
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode thisNode = queue.poll();
                // 将左右孩子添加到队列中
                if (thisNode.left != null) {
                    queue.offer(thisNode.left);
                }
                if (thisNode.right != null) {
                    queue.offer(thisNode.right);
                }
            }
        }
        return maxDepth;
    }
}
