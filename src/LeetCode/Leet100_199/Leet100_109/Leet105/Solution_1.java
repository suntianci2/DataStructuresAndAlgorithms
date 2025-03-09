package LeetCode.Leet100_199.Leet100_109.Leet105;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/7 19:37
 * @Description TODO: 方法一  递归  2ms  90.11%
 *                  思路：
 *                      1、前序遍历的第一个元素为根节点（如果递归构建，也是当前节点）
 *                      2、中序遍历按照根节点将数组划分为两个子数组，前一个子数组为左子树的中序遍历结果，后一个子数组为右子树的中序遍历结果
 */
class Solution_1 {
    int[] preorder;  // 将前序遍历结果提升为成员变量，减少对象的创建
    int[] inorder;   // 将中序遍历结果提升为成员变量，减少对象的创建
    int preIndex;    // 前序遍历第一个元素的索引，模拟删除数组的第一个元素
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        this.preorder = preorder;
        this.inorder = inorder;
        preIndex = 0;
        // 将中序遍历元素与其在数组中的索引下标添加到map中，用于快速定位指定元素在数组中的位置
        for(int i = 0;i < inorder.length;i++){
            map.put(inorder[i], i);
        }
        return doBuild(0, inorder.length - 1);
    }

    // 递归构建树，参数startIndex为当前节点中序遍历起始索引，参数endIndex为当前节点中序遍历结束索引
    public TreeNode doBuild(int startIndex, int endIndex){
        if(startIndex > endIndex || preIndex > preorder.length - 1){
            return null;
        }
        // 前序遍历的第一个值即为当前节点值
        int val = preorder[preIndex];
        // 前序遍历第一个元素的索引+1，模拟删除了第一个元素
        preIndex++;
        // 找到中序遍历中该元素值所在的索引位置
        int index = map.get(val);
        // 构建当前节点
        TreeNode node = new TreeNode(val);
        // 根据元素在中序遍历中的位置将中序遍历切分成前后两部分，前后两部分分别用于递归构建左子树和右子树（先构建左子树）
        node.left = doBuild(startIndex, index - 1);
        node.right = doBuild(index + 1, endIndex);
        return node;
    }
}
