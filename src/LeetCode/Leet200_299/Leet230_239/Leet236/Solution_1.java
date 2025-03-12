package LeetCode.Leet200_299.Leet230_239.Leet236;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/12 15:07
 * @Description TODO: 方法一   常规递归    1512ms  5.48%
 *                  1. 从根节点开始遍历
 *                  2. 如果当前节点为其中一个节点，且左右子树中存在另一个节点，则当前节点为最近公共祖先
 *                  3. 如果左右子树都包含目标节点，那么该节点就是最近公共祖先
 *                  4. 如果只有左子树包含目标节点，则递归进左子树寻找答案
 *                  5. 如果只有右子树包含目标节点，则递归进右子树寻找答案
 *                  时间复杂度为O(n^2)，空间复杂度为O(n)
 */
class Solution_1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        boolean leftContainNode = containNode(root.left, p, q);
        boolean rightContainNode = containNode(root.right, p, q);
        // 当前节点为其中一个节点，且左右子树中存在另一个节点
        if((root.val == p.val || root.val == q.val) && (leftContainNode || rightContainNode)){
            return root;
        }
        // 如果左右子树都包含目标节点，那么该节点就是最近公共祖先
        if(leftContainNode && rightContainNode){
            return root;
        }

        if(leftContainNode){
            // 只有左子树包含目标节点，则递归进左子树寻找答案
            return lowestCommonAncestor(root.left, p, q);
        }
        if(rightContainNode){
            // 只有右子树包含目标节点，则递归进右子树寻找答案
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }

    // 判断当前节点树下是否有指定节点
    public boolean containNode(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return false;
        }
        if(node.val == p.val || node.val == q.val){
            return true;
        }
        return containNode(node.left, p, q) || containNode(node.right, p, q);
    }

}
