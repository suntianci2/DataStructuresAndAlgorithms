package LeetCode.Leet100_199.Leet140_149.Leet145;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/8 11:39
 * @Description TODO: 方法一   递归    0ms   100%
 */
class Solution_1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    public void postorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        postorder(node.left, result);  // 左
        postorder(node.right, result);  // 右
        result.add(node.val);  // 中
    }
}
