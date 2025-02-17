package LeetCode.Leet100_199.Leet110_119.Leet117;

/**
 * @ClassName Node
 * @Author 孙天赐
 * @Date 2025/2/16 9:27
 * @Description TODO: Definition for a Node.
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
