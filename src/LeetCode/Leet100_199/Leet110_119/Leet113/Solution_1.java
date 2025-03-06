package LeetCode.Leet100_199.Leet110_119.Leet113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/5 19:26
 * @Description TODO: 方法一   递归、回溯   1ms 99.83%
 */
class Solution_1 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // 获取反的答案（此时答案路径是反的）
        List<List<Integer>> result = getPath(root, targetSum);
        // 颠倒路径，即为正确答案
        for (List<Integer> temp : result) {
            Collections.reverse(temp);
        }
        return result;
    }

    // 递归获取节点的路径
    public List<List<Integer>> getPath(TreeNode node, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        // 当前节点为叶子节点，且路径和等于目标
        if (node.val == targetSum && node.left == null && node.right == null) {
            List<Integer> temp = new ArrayList<>();
            temp.add(node.val);
            result.add(temp);
            return result;
        }
        // 当前节点不为叶子节点，或路径和不等于目标
        // 左子树寻找答案，递归、回溯
        List<List<Integer>> leftResult = getPath(node.left, targetSum - node.val);
        // 右子树寻找答案，递归、回溯
        List<List<Integer>> rightResult = getPath(node.right, targetSum - node.val);
        // 统计答案，将自己的节点添加到答案路径中
        for (List<Integer> temp : leftResult) {
            temp.add(node.val);
            result.add(temp);
        }
        for (List<Integer> temp : rightResult) {
            temp.add(node.val);
            result.add(temp);
        }
        // 返回结果
        return result;
    }

}