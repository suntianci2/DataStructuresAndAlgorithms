package LeetCode.Leet500_599.Leet580_589.Leet589;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/18 13:59
 * @Description TODO: 方法一   递归  0ms 100%
 */
class Solution_1 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        doPreorder(root, result);
        return result;
    }

    // 递归前序遍历
    public void doPreorder(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        // 获取值
        result.add(node.val);
        // 从左到右，对子树作前序遍历
        for (Node child : node.children) {
            doPreorder(child, result);
        }
    }
}
