package LeetCode.Leet100_199.Leet140_149.Leet144;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/2/9 16:00
 * @Description TODO: 方法二   迭代  0ms 100%
 */
class Solution_2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode thisNode = root;
        while (thisNode != null || !stack.isEmpty()) {
            if (thisNode != null) {
                result.add(thisNode.val);
                stack.push(thisNode);
                thisNode = thisNode.left;
            } else {
                thisNode = stack.pop().right;
            }
        }
        return result;
    }
}
