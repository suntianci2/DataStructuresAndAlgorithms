package LeetCode.Leet1_99.Leet90_99.Leet94;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/2/9 16:16
 * @Description TODO: 方法二   迭代  0ms 100%
 */
class Solution_2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode thisNode = root;
        while (thisNode != null || !stack.isEmpty()) {
            if (thisNode != null) {
                stack.push(thisNode);
                thisNode = thisNode.left;
            } else {
                TreeNode temp = stack.pop();
                result.add(temp.val);
                thisNode = temp.right;
            }
        }
        return result;
    }

}
