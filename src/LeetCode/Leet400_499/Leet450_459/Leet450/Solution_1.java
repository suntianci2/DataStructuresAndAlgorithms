package LeetCode.Leet400_499.Leet450_459.Leet450;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/14 10:04
 * @Description TODO: 方法一   迭代+递归   0ms 100%
 *                  利用二叉搜索树的性质，寻找待删除节点
 *                  没找到的话，就不执行删除逻辑
 *                  找到后，分情况删除：
 *                      1.叶子节点，直接删除
 *                      2.只有左孩子，使用左孩子覆盖当前节点
 *                      3.只有右孩子，使用右孩子覆盖当前节点
 *                      4.既有左孩子又有右孩子，找到待删除节点的后继节点，使用后继节点覆盖当前节点，然后递归删除后继节点（处理后继节点的后事）
 *                  注意：
 *                      如果待删除节点为根节点，则需要特殊处理
 */
class Solution_1 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode thisNode = root;  // 寻找待删除的节点
        TreeNode prevNode = null;  // 记录待删除节点的父节点
        while (thisNode != null) {
            if (key < thisNode.val) {
                // 待删除的节点可能在左子树中
                prevNode = thisNode;
                thisNode = thisNode.left;
            } else if (key > thisNode.val) {
                // 待删除的节点可能在右子树中
                prevNode = thisNode;
                thisNode = thisNode.right;
            } else {
                // 找到了待删除节点
                break;
            }
        }
        // 未找到待删除的节点，不需要走删除逻辑
        if (thisNode == null) {
            return root;
        }
        // 找到了待删除的节点
        if (thisNode.left == null && thisNode.right == null) {
            // 情况1：待删除节点为叶子节点，直接删除即可
            if (thisNode.val == root.val) {
                // 待删除节点为根节点
                return null;
            } else if (thisNode.val < prevNode.val) {
                // 待删除节点为父节点的左孩子
                prevNode.left = null;
            } else {
                // 待删除节点为父节点的右孩子
                prevNode.right = null;
            }
        } else if (thisNode.left == null) {
            // 情况2：待删除节点只有右孩子，使用右孩子覆盖当前节点
            if (thisNode.val == root.val) {
                // 待删除节点为根节点
                TreeNode newRoot = root.right;
                root.right = null;
                return newRoot;
            } else if (thisNode.val < prevNode.val) {
                // 待删除节点为父节点的左孩子
                prevNode.left = thisNode.right;
            } else {
                // 待删除节点为父节点的右孩子
                prevNode.right = thisNode.right;
            }
            // 释放待删除节点，便于垃圾回收
            thisNode.right = null;

        } else if (thisNode.right == null) {
            // 情况3：待删除节点只有左孩子，使用左孩子覆盖当前节点
            if (thisNode.val == root.val) {
                // 待删除节点为根节点
                TreeNode newRoot = root.left;
                root.left = null;
                return newRoot;
            } else if (thisNode.val < prevNode.val) {
                // 待删除节点为父节点的左孩子
                prevNode.left = thisNode.left;
            } else {
                // 待删除节点为父节点的右孩子
                prevNode.right = thisNode.left;
            }
            // 释放待删除节点，便于垃圾回收
            thisNode.left = null;
        } else {
            // 情况4：待删除节点既有左孩子也有右孩子
            // 找到待删除节点的后继节点（右子树的最小节点）
            TreeNode postNode = thisNode.right;
            while (postNode.left != null) {
                postNode = postNode.left;
            }
            int postVal = postNode.val;
            // 递归删除后继节点（处理后继节点的后事）
            thisNode.right = deleteNode(thisNode.right, postVal);
            // 后继节点覆盖待删除节点
            thisNode.val = postVal;
        }
        return root;
    }
}
