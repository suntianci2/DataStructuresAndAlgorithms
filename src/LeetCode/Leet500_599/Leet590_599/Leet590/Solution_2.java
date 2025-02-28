package LeetCode.Leet500_599.Leet590_599.Leet590;

import java.util.*;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/2/19 18:34
 * @Description TODO: 方法二   迭代+栈    3ms 20.45%
 *                  先按照伪前序遍历（中 -> 右 -> 左）的顺序遍历，然后将结果集合颠倒，即为答案
 */
class Solution_2 {
    public List<Integer> postorder(Node root) {
        // 先按照中->右->左的顺序记录结果，然后再颠倒结果即为答案
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // 处理当前节点
            Node temp = stack.pop();
            result.add(temp.val);
            // 将当前节点所有孩子按照从左到右压入栈，后序将按照从右到左的顺序访问
            for (Node child : temp.children) {
                stack.push(child);
            }
        }
        // 颠倒集合，即为答案
        Collections.reverse(result);
        return result;
    }

}
