package LeetCode.Leet100_199.Leet100_109.Leet102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/10 16:54
 * @Description TODO: 方法一   队列+迭代  1ms 92.93%
 */
class Solution_1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 当前层元素个数
            int len = queue.size();
            // 当前层结果
            List<Integer> tempRes = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                tempRes.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            result.add(tempRes);
        }
        return result;
    }
}
