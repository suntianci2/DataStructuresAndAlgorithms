package LeetCode.Leet1_99.Leet90_99.Leet98;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/3/9 14:33
 * @Description TODO: 方法二   中序遍历（迭代）    4ms 3.85%
 *                  中序遍历二叉搜索树，得到的结果是严格升序的
 *                  所以我们可以对得到的中序遍历结果进行判断，
 *                  如果是严格升序的，那么该树就是二叉搜索树
 *                  效率还是有点低，因为我们需要遍历整个树。
 */
class Solution_2 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 记录中序遍历结果
        List<Integer> inorderList = new ArrayList<>();
        // 中序遍历用的栈
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 当前访问的节点
        TreeNode thisNode = root;
        while (thisNode != null || !stack.isEmpty()) {
            if (thisNode != null) {
                // 左
                stack.push(thisNode);
                thisNode = thisNode.left;
            } else {
                TreeNode temp = stack.pop();
                // 中
                inorderList.add(temp.val);
                // 右
                thisNode = temp.right;
            }
        }
        // 判断中序遍历结果是否严格升序，只有严格升序，该树才为二叉搜索树
        for (int i = 1; i < inorderList.size(); i++) {
            if (inorderList.get(i - 1) >= inorderList.get(i)) {
                return false;
            }
        }
        return true;
    }

}