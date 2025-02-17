package LeetCode.Leet600_699.Leet630_639.Leet637;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/12 16:38
 * @Description TODO: 方法一   层序遍历    2ms 94.20%
 */
class Solution_1 {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 当前层节点数量
            int len = queue.size();
            double tempResult = 0.0;
            // 累加当前层和，并将下一层的节点添加到队列中
            for (int i = 0; i < len; i++) {
                TreeNode thisNode = queue.poll();
                tempResult += thisNode.val;
                if (thisNode.left != null) {
                    queue.offer(thisNode.left);
                }
                if (thisNode.right != null) {
                    queue.offer(thisNode.right);
                }
            }
            // 计算当前层平均值
            tempResult /= len;
            result.add(tempResult);
        }
        return result;
    }
}
