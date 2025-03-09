package LeetCode.Leet700_799.Leet700_710.Leet700;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/9 10:01
 * @Description TODO: 方法一   迭代  0ms 100%
 *                  使用二叉搜索树的性质即可解决问题
 *                  二叉搜索树的性质：
 *                      1. 左子树所有节点的值都小于根节点的值
 *                      2. 右子树所有节点的值都大于根节点的值
 *                      3. 左右子树也都是二叉搜索树
 *                      4. 没有重复元素
 */
class Solution_1 {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode thisNode = root;
        while (thisNode != null) {
            if (val == thisNode.val) {
                return thisNode;
            } else if (val < thisNode.val) {
                thisNode = thisNode.left;
            } else {
                thisNode = thisNode.right;
            }
        }
        return thisNode;
    }
}
