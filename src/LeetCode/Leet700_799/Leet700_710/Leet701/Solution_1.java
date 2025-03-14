package LeetCode.Leet700_799.Leet700_710.Leet701;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/13 19:47
 * @Description TODO: 方法一   迭代   0ms 100%
 *                  利用二叉搜索树的性质，寻找插入的位置
 */
class Solution_1 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode thisNode = root;
        TreeNode prevNode = null;
        while (thisNode != null) {
            // 记录前一个节点
            prevNode = thisNode;
            if (val < thisNode.val) {
                // 应该插入到左子树中
                thisNode = thisNode.left;
            } else {
                // 应该插入到右子树中
                thisNode = thisNode.right;
            }
        }
        TreeNode newNode = new TreeNode(val);
        // 找到了插入的位置，而prevNode即为插入元素的父节点
        // 新节点值小于父亲节点，则新节点作为左孩子
        if (val < prevNode.val) {
            prevNode.left = newNode;
        } else {
            // 新节点值大于父亲节点，则新节点作为右孩子
            prevNode.right = newNode;
        }

        return root;
    }
}
