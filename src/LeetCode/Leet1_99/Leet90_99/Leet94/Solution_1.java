package LeetCode.Leet1_99.Leet90_99.Leet94;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/8 11:31
 * @Description TODO: 方法一   递归      0ms     100%
 */
class Solution_1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public void inorder(TreeNode node, List<Integer> result){
        if(node == null){
            return;
        }
        inorder(node.left, result);  // 左
        result.add(node.val);  // 中
        inorder(node.right, result);  // 右
    }
}
