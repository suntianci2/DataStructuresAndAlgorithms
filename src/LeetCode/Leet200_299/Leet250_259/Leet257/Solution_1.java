package LeetCode.Leet200_299.Leet250_259.Leet257;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/2 11:51
 * @Description TODO: 方法一   递归  7ms 30.10%
 */
class Solution_1 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        // 节点不存在
        if (root == null) {
            return result;
        }
        String value = String.valueOf(root.val);
        // 叶子节点
        if (root.left == null && root.right == null) {
            result.add(value);
            return result;
        }
        // 获取左孩子到所有叶子节点的路径
        List<String> leftResult = binaryTreePaths(root.left);
        // 获取右孩子到所有叶子节点的路径
        List<String> rightResult = binaryTreePaths(root.right);
        // 将当前节点的路径添加到左孩子和右孩子路径中
        for (String s : leftResult) {
            result.add(value + "->" + s);
        }
        for (String s : rightResult) {
            result.add(value + "->" + s);
        }
        return result;

    }
}
