package LeetCode.Leet100_199.Leet110_119.Leet117;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/16 9:28
 * @Description TODO: 方法一   层序遍历（迭代）+队列 1ms 80.28%
 */
class Solution_1 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 当前层节点个数
            int len = queue.size();
            // 记录前一个节点，用于设置next值
            Node preNode = null;
            for (int i = 0; i < len; i++) {
                Node thisNode = queue.poll();

                // 将下一层节点添加到队列中
                if (thisNode.left != null) {
                    queue.offer(thisNode.left);
                }
                if (thisNode.right != null) {
                    queue.offer(thisNode.right);
                }

                // 设置前一节点的next指针为当前节点
                if (preNode != null) {
                    preNode.next = thisNode;
                }
                // 保存当前节点，用于下一循环设置next指针
                preNode = thisNode;
            }
            // 设置最后一个节点的next指向null。默认next为null，所以这段代码不加也没问题
            // preNode.next = null;
        }
        return root;
    }
}
