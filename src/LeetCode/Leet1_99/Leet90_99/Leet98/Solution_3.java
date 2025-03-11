package LeetCode.Leet1_99.Leet90_99.Leet98;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Solution_3
 * @Author 孙天赐
 * @Date 2025/3/9 14:50
 * @Description TODO: 方法三  中序遍历优化1（迭代）  3ms 5.03%
 *                  在方法二的基础上，我们可以在中序遍历的过程中判断当前节点是否大于前一节点
 *                  如果大于前一节点，则继续遍历，否则提前退出循环
 *                  这样可以避免在遍历完整个树之后再进行判断，提高了效率
 *                  但是，由于部分恶心的测试用例无法通过，所以需要加入一个判断条件来启用在中序遍历的过程中判断的功能
 */
class Solution_3 {
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
        // 中序遍历前一个节点的值，用于在遍历过程中当条件不满足时提前退出循环
        int prevValue = Integer.MIN_VALUE;

        while (thisNode != null || !stack.isEmpty()) {
            if (thisNode != null) {
                // 左
                stack.push(thisNode);
                thisNode = thisNode.left;
            } else {
                TreeNode temp = stack.pop();
                int val = temp.val;

                // 中
                inorderList.add(val);
                // 提前退出循环的判断，当当前节点值小于等于前一节点值，则不满足二叉搜索树的条件了
                // 必须在当前值大于int类型最小值的时候，才能启用提前终止这个功能，不然有几个恶心的测试用例无法通过
                if (val > Integer.MIN_VALUE) {
                    if (val <= prevValue) {
                        return false;
                    }
                    prevValue = val;
                }

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