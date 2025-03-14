package LeetCode.Leet400_499.Leet450_459.Leet450;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/3/14 19:53
 * @Description TODO: 方法二   递归  0ms 100%
 *                  方法一的递归版本，思路一致
 */
class Solution_2 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // 当前节点为待删除节点
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                // 情况1：待删除节点为叶子节点，直接删除即可
                return null;
            } else if (root.left == null) {
                // 情况2：待删除节点只有右孩子，使用右孩子覆盖当前节点
                return root.right;
            } else if (root.right == null) {
                // 情况3：待删除节点只有左孩子，使用左孩子覆盖当前节点
                return root.left;
            } else {
                // 情况4：待删除节点既有左孩子也有右孩子
                // 找到待删除节点的后继节点（右子树的最小节点）
                TreeNode postNode = root.right;
                while (postNode.left != null) {
                    postNode = postNode.left;
                }
                int postVal = postNode.val;
                // 递归删除后继节点（处理后继节点的后事）
                root.right = deleteNode(root.right, postVal);
                // 后继节点覆盖待删除节点
                root.val = postVal;
            }
        } else {
            // 当前节点不是待删除节点，则递归到子树中删除
            if (root.val > key) {
                // 到左子树中删除
                root.left = deleteNode(root.left, key);
            } else {
                // 到右子树中删除
                root.right = deleteNode(root.right, key);
            }
        }
        return root;
    }
}
