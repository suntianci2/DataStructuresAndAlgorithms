package LeetCode.Leet500_599.Leet550_559.Leet559;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/25 17:16
 * @Description TODO: 方法一   层序遍历    2ms 29.56%
 */
class Solution_1 {
    public int maxDepth(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            maxDepth++;
            int len = queue.size();  // 当前层节点个数
            for (int i = 0; i < len; i++) {
                for (Node nextNode : queue.poll().children) {
                    queue.offer(nextNode);
                }
            }
        }
        return maxDepth;
    }
}
