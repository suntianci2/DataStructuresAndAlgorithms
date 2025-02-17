package LeetCode.Leet400_499.Leet420_429.Leet429;

import java.util.List;

/**
 * @ClassName Node
 * @Author 孙天赐
 * @Date 2025/2/12 20:19
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

