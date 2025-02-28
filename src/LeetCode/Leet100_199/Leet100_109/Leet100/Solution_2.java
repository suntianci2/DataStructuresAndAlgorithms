package LeetCode.Leet100_199.Leet100_109.Leet100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/2/21 13:02
 * @Description TODO: 方法二   迭代+队列（也可以用栈）    0ms 100%
 */
class Solution_2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            // 如果出队了一个元素后队列就为空，说明节点个数为奇数个，则两个树不一样了
            if (queue.isEmpty()) {
                return false;
            }
            TreeNode node2 = queue.poll();
            // 此时，node1和node2应该对应的是同一位置的节点
            if (node1 == null && node2 == null) {
                // 两个节点都为null，则进入下一循环
                continue;
            } else if (node1 == null || node2 == null) {
                // 两个节点中，有一个节点为null，另一个节点不为null，则树不一样了
                return false;
            } else {
                // 两个节点都存在
                // 若两个节点值不相同，则树不对称了
                if (node1.val != node2.val) {
                    return false;
                }
                // 至此，这两个节点相同。将这两个节点的孩子节点加入到队列中，并进入下一循环
                // 加入队列的顺序不能乱
                // 左孩子
                queue.offer(node1.left);
                queue.offer(node2.left);
                // 右孩子
                queue.offer(node1.right);
                queue.offer(node2.right);
            }
        }
        // 循环正常结束，则两个树一样
        return true;
    }
}
