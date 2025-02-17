package LeetCode.Leet100_199.Leet190_199.Leet199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/11 20:40
 * @Description TODO: 方法一   层序遍历    1ms 77.67%
 */
class Solution_1 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 当前层元素个数
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                // 如果遍历到当前层最后一个元素，则加入到result中
                if (i == len - 1) {
                    result.add(temp.val);
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return result;
    }
}
