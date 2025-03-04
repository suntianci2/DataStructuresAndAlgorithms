package LeetCode.Leet500_599.Leet510_519.Leet513;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/3 20:21
 * @Description TODO: 方法一   广度优先遍历（迭代+队列）   3ms 53.74%
 */
class Solution_1 {
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                if (i == 0) {
                    result = temp.val;
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
