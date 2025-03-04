package LeetCode.Leet200_299.Leet250_259.Leet257;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/3/2 13:33
 * @Description TODO: 方法二   后序遍历（迭代）    2ms 52.05%
 */
class Solution_2 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();  // 记录当前节点的路径

        // 后续遍历
        TreeNode thisNode = root;
        TreeNode prePopNode = null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (thisNode != null || !stack.isEmpty()) {
            if (thisNode == null) {
                // 走到头了
                TreeNode temp = stack.peek();  // 上一个节点
                // 如果上一次处理的节点是上一个节点的右孩子，则说明上一个节点的左右孩子均处理完毕
                if (temp.right == null || temp.right == prePopNode) {
                    stack.pop();
                    // 移除路径
                    path.remove(path.size() - 1);
                    // 记录弹出的节点，便于后序遍历
                    prePopNode = temp;
                    // 执行业务逻辑
                    // 如果该节点的左右孩子均为null，则该节点为叶子节点
                    if (temp.left == null && temp.right == null) {
                        // 记录当前叶子节点的路径到答案中
                        result.add(getPath(path, temp.val));
                    }
                } else {
                    // 否则，表明只处理完了左子树，接下来开始处理右子树
                    thisNode = temp.right;
                }
            } else {
                // 没有走到头
                stack.push(thisNode);
                // 记录路径
                path.add(thisNode.val);
                thisNode = thisNode.left;
            }
        }
        return result;
    }

    // 将路径转化为答案指定格式
    public String getPath(List<Integer> path, int value) {
        StringBuilder sb = new StringBuilder();
        int len = path.size();
        for (int i = 0; i < len; i++) {
            sb.append(path.get(i));
            sb.append("->");
        }
        sb.append(value);
        return sb.toString();
    }
}
