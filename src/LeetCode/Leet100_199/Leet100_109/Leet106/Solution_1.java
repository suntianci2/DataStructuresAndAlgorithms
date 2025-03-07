package LeetCode.Leet100_199.Leet100_109.Leet106;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/6 19:44
 * @Description TODO: 方法一   普通递归    47ms    5.28%
 *                      我自己想的思路，可惜效率很低。
 *                        1、递归函数的参数：中序遍历结果、后序遍历结果
 *                        2、递归函数的返回值：当前子树的根节点
 *                        3、递归函数的终止条件：中序遍历结果为空，或后序遍历结果为空
 *                        4、递归函数的逻辑：
 *                          1、当前根节点的值，必为后序遍历的最后一个值
 *                          2、处理后序遍历的值，移除刚才取到的根节点的值
 *                          3、构建当前根节点
 *                          4、根据根节点的值，将中序遍历结果划分为两个子数组，左侧子数组必为当前根节点的左子树中序遍历结果，右侧子数组必为当前根节点的右子树中序遍历结果。将两个子数组作为新的中序遍历结果，用于递归构建子树
 *                        5、返回当前根节点
 *                      缺点：
 *                        1、每次递归都需要创建新的数组，效率较低
 *                        2、每次递归都需要遍历中序遍历结果数组，效率较低
 */
class Solution_1 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        // 集合转数组，后续操作更方便
        List<Integer> inorderList = new ArrayList<>();
        List<Integer> postorderList = new ArrayList<>();
        for (int a : inorder) {
            inorderList.add(a);
        }
        for (int a : postorder) {
            postorderList.add(a);
        }
        // 调用递归函数构建
        return doBuild(inorderList, postorderList);
    }

    public TreeNode doBuild(List<Integer> inorder, List<Integer> postorder) {
        // 递归终止条件
        if (inorder.size() == 0 || postorder.size() == 0) {
            return null;
        }
        // 1. 当前根节点的值，必为后序遍历的最后一个值
        int val = postorder.get(postorder.size() - 1);
        // 2. 处理后序遍历的值，移除刚才取到的根节点的值
        postorder.remove(postorder.size() - 1);
        // 3. 构建当前根节点
        TreeNode root = new TreeNode(val);
        // 4. 根据根节点的值，将中序遍历结果划分为两个子数组，左侧子数组必为当前根节点的左子树中序遍历结果，右侧子数组必为当前根节点的右子树中序遍历结果。将两个子数组作为新的中序遍历结果，用于递归构建子树
        // 4.1 递归构建右子树（必须先递归构建右子树，因为后序遍历结果数组中最后一个值，是右子树的根节点）
        root.right = doBuild(inorder.subList(inorder.indexOf(val) + 1, inorder.size()), postorder);
        // 4.2 递归构建左子树
        root.left = doBuild(inorder.subList(0, inorder.indexOf(val)), postorder);
        // 返回当前根节点
        return root;
    }
}
