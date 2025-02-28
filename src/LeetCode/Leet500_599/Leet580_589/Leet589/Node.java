package LeetCode.Leet500_599.Leet580_589.Leet589;

import java.util.List;

/**
 * @ClassName Node
 * @Author 孙天赐
 * @Date 2025/2/18 13:58
 * @Description TODO: Definition for a Node.
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

