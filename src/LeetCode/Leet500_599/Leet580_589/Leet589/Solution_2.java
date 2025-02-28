package LeetCode.Leet500_599.Leet580_589.Leet589;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/2/19 18:23
 * @Description TODO: 方法二   迭代+栈    3ms 21.38%
 */
class Solution_2 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> stack = new ArrayDeque<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // 处理当前节点
            Node temp = stack.pop();
            result.add(temp.val);
            // 将当前节点的孩子，从右到左添加到栈中，这样后序访问的顺序就为从左到右了
            for (int i = temp.children.size() - 1; i >= 0; --i) {
                stack.push(temp.children.get(i));
            }
        }
        return result;
    }
}
