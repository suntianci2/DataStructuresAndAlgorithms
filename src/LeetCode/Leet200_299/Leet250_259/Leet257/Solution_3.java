package LeetCode.Leet200_299.Leet250_259.Leet257;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_3
 * @Author 孙天赐
 * @Date 2025/3/2 14:24
 * @Description TODO: 方法三   前序遍历（递归）    1ms 99.95%
 */
class Solution_3 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        getPath(root, result, path);
        return result;
    }

    // 递归前序遍历
    public void getPath(TreeNode node, List<String> result, List<Integer> path) {
        if (node == null) {
            return;
        }
        // 中
        path.add(node.val);
        // 碰到叶子节点，记录答案
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            int len = path.size();
            for (int i = 0; i < len; i++) {
                sb.append(path.get(i));
                if (i != len - 1) {
                    sb.append("->");
                }
            }
            result.add(sb.toString());
        }

        // 左
        getPath(node.left, result, path);
        // 回溯，左孩子存在才回溯
        if (node.left != null) {
            path.remove(path.size() - 1);
        }


        // 右
        getPath(node.right, result, path);
        // 回溯，右孩子存在才回溯
        if (node.right != null) {
            path.remove(path.size() - 1);
        }

    }
}
