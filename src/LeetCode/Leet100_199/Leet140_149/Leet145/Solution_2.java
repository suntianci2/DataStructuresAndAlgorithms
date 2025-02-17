package LeetCode.Leet100_199.Leet140_149.Leet145;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/2/9 16:38
 * @Description TODO: 方法二   迭代  0ms 100%
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution_2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode thisNode = root;
        TreeNode prePopNode = null;  // 记录上一个弹出的节点
        while (thisNode != null || !stack.isEmpty()) {
            if (thisNode != null) {
                stack.push(thisNode);
                thisNode = thisNode.left;
            } else {
                // 前一个节点
                TreeNode preNode = stack.peek();
                // 表示上一节点的左右孩子已经处理完毕
                if (preNode.right == null || preNode.right == prePopNode) {
                    // 处理当前节点
                    stack.pop();
                    prePopNode = preNode;
                    result.add(preNode.val);
                } else {
                    // 表示只有左孩子处理完毕
                    // 接下来处理右孩子
                    thisNode = preNode.right;
                }
            }
        }
        return result;
    }

}
