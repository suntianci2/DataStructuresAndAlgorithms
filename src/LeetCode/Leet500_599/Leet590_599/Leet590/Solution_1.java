package LeetCode.Leet500_599.Leet590_599.Leet590;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/2/18 14:04
 * @Description TODO: 方法一   递归  0ms 100%
 */
class Solution_1 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        doPostorder(root, result);
        return result;
    }

    // 递归后序遍历
    public void doPostorder(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }

        // 从左到右，对子树作后序遍历
        for (Node child : node.children) {
            doPostorder(child, result);
        }
        // 获取值
        result.add(node.val);
    }
}
