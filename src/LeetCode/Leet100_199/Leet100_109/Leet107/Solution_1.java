package LeetCode.Leet100_199.Leet100_109.Leet107;

import java.util.*;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/11 20:25
 * @Description TODO: 方法一   迭代  1ms 93.59%
 */
class Solution_1 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(result);
        return result;
    }
}
