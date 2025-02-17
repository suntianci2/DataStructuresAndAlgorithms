package LeetCode.Leet100_199.Leet100_109.Leet102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/2/10 20:51
 * @Description TODO: 方法二   队列+递归   1ms 92.93%
 */
class Solution_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        getLevelResult(queue, result);
        return result;
    }

    // 获取队列当前层级遍历结果
    private void getLevelResult(Queue<TreeNode> queue, List<List<Integer>> result) {
        if (queue.isEmpty()) {
            return;
        }
        int len = queue.size();
        List<Integer> levelResult = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            TreeNode temp = queue.poll();
            levelResult.add(temp.val);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        result.add(levelResult);
        // 递归开始下一层的遍历
        getLevelResult(queue, result);
    }
}
