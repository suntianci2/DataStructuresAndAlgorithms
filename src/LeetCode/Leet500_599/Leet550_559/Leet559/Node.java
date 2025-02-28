package LeetCode.Leet500_599.Leet550_559.Leet559;

import java.util.List;

/**
 * @ClassName Node
 * @Author 孙天赐
 * @Date 2025/2/25 17:17
 * @Description TODO: Definition for a Node.
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
