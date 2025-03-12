package LeetCode.Leet200_299.Leet230_239.Leet236;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/3/12 13:51
 * @Description TODO: 方法二   递归   10ms   13.63%
 *                  1. 先找到根节点到p和q的路径
 *                  2. 然后在两个路径中找到最后一个相同的节点，即为最近公共祖先
 *                  3. 时间复杂度为O(n)，空间复杂度为O(n)
 */
class Solution_2 {
    List<TreeNode> pPath = new ArrayList<>();
    List<TreeNode> qPath = new ArrayList<>();
    List<TreeNode> path = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findPath(root, p, q);
        int i;
        for (i = 0; i < pPath.size() && i < qPath.size(); i++) {
            if (pPath.get(i) != qPath.get(i)) {
                return pPath.get(i - 1);
            }
        }
        return pPath.get(i - 1);

    }

    // 前序遍历找到根节点到这两个节点的路径
    public void findPath(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return;
        }
        // 已经找到两个点的路径了，不需要继续遍历了
        if (!pPath.isEmpty() && !qPath.isEmpty()) {
            return;
        }
        // 中
        path.add(node);

        if (node.val == p.val) {
            // 找到p节点
            pPath.addAll(path);
        } else if (node.val == q.val) {
            // 找到q节点
            qPath.addAll(path);
        }

        // 左
        findPath(node.left, p, q);

        // 右
        findPath(node.right, p, q);

        // 回溯（删除路径中的该节点）
        path.remove(path.size() - 1);
    }
}
