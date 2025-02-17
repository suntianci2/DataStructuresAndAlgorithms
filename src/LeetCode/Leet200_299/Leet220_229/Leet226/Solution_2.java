package LeetCode.Leet200_299.Leet220_229.Leet226;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/2/17 16:56
 * @Description TODO: 方法二   广度优先遍历（迭代+队列）   0ms 100%
 */
class Solution_2 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 层序遍历交换每个节点的左右孩子节点
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                // 交换当前节点的两个孩子节点
                TreeNode thisNode = queue.poll();
                TreeNode temp = thisNode.left;
                thisNode.left = thisNode.right;
                thisNode.right = temp;

                // 将孩子节点添加到队列中
                if (thisNode.left != null) {
                    queue.offer(thisNode.left);
                }
                if (thisNode.right != null) {
                    queue.offer(thisNode.right);
                }
            }
        }
        return root;
    }
}
