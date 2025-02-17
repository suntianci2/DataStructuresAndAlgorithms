package LeetCode.Leet400_499.Leet420_429.Leet429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/12 20:20
 * @Description TODO: 方法一   迭代  3ms 89.94%
 */
class Solution_1 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 当前层节点个数
            int len = queue.size();
            // 当前层结果
            List<Integer> tempResult = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                Node thisNode = queue.poll();
                tempResult.add(thisNode.val);
                // 将当前节点的孩子添加到队列中
                for (Node child : thisNode.children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }
            result.add(tempResult);
        }
        return result;
    }
}
