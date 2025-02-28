package LeetCode.Leet500_599.Leet550_559.Leet559;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/2/25 17:18
 * @Description TODO: 方法二   递归  0ms 100%
 */
class Solution_2 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        // 递归获取所有孩子节点的最大深度
        for (Node node : root.children) {
            int temp = maxDepth(node);
            if (temp > maxDepth) {
                maxDepth = temp;
            }
        }
        // 该节点最大深度为子节点最大深度+1
        return maxDepth + 1;
    }
}