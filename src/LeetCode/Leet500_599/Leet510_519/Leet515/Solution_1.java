package LeetCode.Leet500_599.Leet510_519.Leet515;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/13 20:39
 * @Description TODO:方法一    层序遍历（迭代+队列） 2ms 90.03%
 */
class Solution_1 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 当前层节点个数
            int len = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                TreeNode thisNode = queue.poll();
                if (thisNode.val > max) {
                    max = thisNode.val;
                }
                if (thisNode.left != null) {
                    queue.offer(thisNode.left);
                }
                if (thisNode.right != null) {
                    queue.offer(thisNode.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}