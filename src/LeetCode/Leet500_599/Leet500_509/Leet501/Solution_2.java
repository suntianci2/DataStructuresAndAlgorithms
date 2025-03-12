package LeetCode.Leet500_599.Leet500_509.Leet501;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/3/12 10:46
 * @Description TODO: 方法二   中序遍历    0ms 100%
 *                  中序遍历二叉搜索树，得到的结果为升序数组（不严格升序，因为存在相同元素），所以同一元素一定靠在一起
 *                  因此，我们可以在中序遍历的过程中，判断前一元素与当前元素值是否相等，从而记录元素出现的次数
 *                  然后判断当前元素出现次数是否为最大出现次数，如果是，则加入结果集合
 *                  如果大于最大出现次数，则清空结果集合，并加入当前元素
 */
class Solution_2 {
    int maxCount = 1;  // 元素的最大出现次数
    int thisCount = 0;  // 当前元素的出现次数
    List<Integer> resultList = new ArrayList<>();
    TreeNode prevNode = null;

    public int[] findMode(TreeNode root) {
        getNumCount(root);
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    // 中序遍历二叉搜索树，得到的结果为升序数组（不严格升序，因为存在相同元素），所以同一元素一定靠在一起
    public void getNumCount(TreeNode node) {
        if (node == null) {
            return;
        }

        // 左
        getNumCount(node.left);

        // 中
        // 记录当前元素出现次数
        if (prevNode == null || prevNode.val == node.val) {
            thisCount++;
        } else {
            thisCount = 1;
        }
        // 如果当前元素出现次数等于最大次数，则加入结果集合，如果大于最大次数，则清空结果集合，并加入集合，并更新最大次数
        if (thisCount == maxCount) {
            resultList.add(node.val);
        } else if (thisCount > maxCount) {
            resultList.clear();
            resultList.add(node.val);
            maxCount = thisCount;
        }
        // 记录前一节点
        prevNode = node;

        // 右
        getNumCount(node.right);
    }
}
