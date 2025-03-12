package LeetCode.Leet500_599.Leet500_509.Leet501;

import java.util.*;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/12 10:32
 * @Description TODO: 方法一   哈希表+递归  5ms 26.28%
 *                  用哈希表记录每个元素出现的次数（元素：出现次数），然后在哈希表中找出出现次数最高的元素
 *                  没有用到二叉搜索树的性质（有序），所以效率较低
 */
class Solution_1 {
    int maxCount = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        // 获取每个元素出现的次数，即元素最大出现次数
        getNumCount(root);
        List<Integer> resultList = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 获取出现次数为最大次数的元素，并放入List中
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == maxCount) {
                resultList.add(entry.getKey());
            }
        }
        // 将List转化为数组，并返回结果
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    // 前序遍历获取每个元素出现的次数，并放入哈希表中，并获取元素最大出现次数
    public void getNumCount(TreeNode node) {
        if (node == null) {
            return;
        }
        // 中
        // 记录元素出现次数
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        // 记录元素最大出现次数
        if (map.get(node.val) > maxCount) {
            maxCount = map.get(node.val);
        }

        // 左
        getNumCount(node.left);

        // 右
        getNumCount(node.right);
    }
}
