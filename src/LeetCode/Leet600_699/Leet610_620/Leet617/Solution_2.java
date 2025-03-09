package LeetCode.Leet600_699.Leet610_620.Leet617;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/3/8 19:29
 * @Description TODO: 方法二   迭代（队列+层序遍历） 1ms 18.76%
 *                  使用层序遍历的方式，将两个树的节点同时入队
 *                  每次出队两个节点，则说明当前节点均存在，将两个节点的值相加，即为当前节点的值
 *                  然后将两个节点的左孩子入队，右孩子入队（只有均存在才会入队）
 *                  如果第一个节点左孩子不存在，第二个节点左孩子存在，则将左孩子移给第一个节点
 *                  如果第一个节点右孩子不存在，第二个节点右孩子存在，则将右孩子移给第一个节点
 *                  最后返回root1
 */
class Solution_2 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode thisNode1 = queue.poll();
            TreeNode thisNode2 = queue.poll();
            // 当前两个节点一定不为空，节点值相加
            thisNode1.val += thisNode2.val;

            // 两个节点左孩子均存在，则加入队列
            if (thisNode1.left != null && thisNode2.left != null) {
                queue.offer(thisNode1.left);
                queue.offer(thisNode2.left);
            }

            // 两个节点右孩子均存在，则加入队列
            if (thisNode1.right != null && thisNode2.right != null) {
                queue.offer(thisNode1.right);
                queue.offer(thisNode2.right);
            }

            // 第一个节点左孩子不存在，第二个节点左孩子存在，则将左孩子移给第一个节点
            if (thisNode1.left == null && thisNode2.left != null) {
                thisNode1.left = thisNode2.left;
            }

            // 第一个节点右孩子不存在，第二个节点右孩子存在，则将右孩子移给第一个节点
            if (thisNode1.right == null && thisNode2.right != null) {
                thisNode1.right = thisNode2.right;
            }
        }
        return root1;
    }
}