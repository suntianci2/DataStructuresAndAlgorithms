package LeetCode.Leet100_199.Leet140_149.Leet144;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/8 11:13
 * @Description TODO: 方法一   递归  0ms 100%
 */
class Solution_1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    public void preorder(TreeNode node, List<Integer> result){
        if(node == null){
            return;
        }
        result.add(node.val);  // 中
        preorder(node.left, result);  // 左
        preorder(node.right, result);  // 右
    }
}
