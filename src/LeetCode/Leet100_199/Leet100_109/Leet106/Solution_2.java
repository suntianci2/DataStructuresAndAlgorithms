package LeetCode.Leet100_199.Leet100_109.Leet106;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/3/6 19:47
 * @Description TODO: 方法二 迭代（优化版）   2ms  91.74%
 *                  与方法一思路完全一致，但是进行了很大的优化
 *                  1. 把中序遍历的数组元素和下标都存放到map集合中，便于后续获取指定元素的下标
 *                  2. 把中序遍历和后续遍历的数组都提升为成员变量，避免频繁创建数组
 *                  3. 把后续遍历的最后一个元素的索引提升为成员变量，避免频繁创建数组
 *
 */
class Solution_2 {
    int[] inorder;  // 中序遍历数组提升为成员变量，避免频繁创建数组
    int[] postorder; // 后序遍历数组提升为成员变量，避免频繁创建数组
    int postIndex;  // 后续遍历最后一个元素的索引
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0){
            return null;
        }
        // 元素提升为成员变量
        this.inorder = inorder;
        this.postorder = postorder;
        this.postIndex = postorder.length - 1;
        // map集合存放每个节点元素在中序遍历结果数组中的下标（元素：下标）
        for(int i = 0;i < inorder.length;i++){
            map.put(inorder[i], i);
        }
        return doBuild(0, inorder.length - 1);
    }

    // 递归构建树。两个参数分别为当前节点中序遍历数组的起始坐标和终止坐标（闭区间）
    public TreeNode doBuild(int startIndex, int endIndex){
        // 递归终止条件
        if(startIndex > endIndex || postIndex < 0){
            return null;
        }
        // 后续遍历的最后一个值，即为当前根节点的值
        int val = postorder[postIndex];
        // 后续遍历最后一个元素的索引减一，模拟删除了最后一个元素
        postIndex--;
        // 获取当前节点值在中序遍历数组中的位置
        int index = map.get(val);
        // 构建当前节点
        TreeNode root = new TreeNode(val);
        // 按照该位置切分中序遍历数组，并且递归构建右子树和左子树。先构建右子树
        root.right = doBuild(index + 1, endIndex);
        root.left = doBuild(startIndex, index - 1);
        return root;
    }
}
