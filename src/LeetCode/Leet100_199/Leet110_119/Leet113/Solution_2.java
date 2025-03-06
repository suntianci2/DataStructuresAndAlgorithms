package LeetCode.Leet100_199.Leet110_119.Leet113;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/3/5 20:12
 * @Description TODO: 方法二   递归+回溯（优化版）  1ms 99.83%
 *                    优化点：
 *                      1、不需要将路径颠倒过来，因为我们是从根节点开始遍历的
 *                      2、将路径作为参数传递，不需要返回值
 *                      3、将结果和路径提升为全局变量，减少创建对象的次数
 */
class Solution_2 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return result;
        }
        path.add(root.val);
        getPath(root, targetSum);
        return result;
    }

    public void getPath(TreeNode node, int targetSum){
        if(node == null){
            return;
        }
        // 叶子节点，且路径和为答案
        if(node.val == targetSum && node.left == null && node.right == null){
            // 必须添加一个新建的对象，如果直接添加path，result中的集合与path实际是同一个数组
            result.add(new ArrayList<>(path));
            return;
        }
        // 非叶子节点，或者和不为答案
        // 左子树寻找答案
        if(node.left != null){
            path.add(node.left.val); // 深入
            getPath(node.left, targetSum - node.val); // 隐含回溯
            path.remove(path.size() - 1);  // 回溯
        }

        // 右子树寻找答案
        if(node.right != null){
            path.add(node.right.val); // 深入
            getPath(node.right, targetSum - node.val); // 隐含回溯
            path.remove(path.size() - 1);  // 回溯
        }

    }

}
