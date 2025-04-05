package LeetCode.Leet1_99.Leet40_49.Leet47;

import java.util.*;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/4/5 14:10
 * @Description TODO: 方法一   递归回溯   2ms 58.92%
 *                  不进行排序，然后递归回溯，分别处理树层去重（set）和树枝去重（used）
 */
class Solution_1 {
    List<List<Integer>> result = new ArrayList<>();  // 存储结果集
    List<Integer> oneResult = new ArrayList<>();  // 存储单个结果

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];  // 用于标记是否使用过，避免 不同层 使用同一个元素（位置和元素值都相等的元素）
        doPermuteUnique(nums, used);
        return result;
    }

    public void doPermuteUnique(int[] nums, boolean[] used) {
        // 递归终止条件：找到答案（单个结果长度与输入数组相同）
        if (oneResult.size() == nums.length) {
            result.add(new ArrayList<>(oneResult));
            return;
        }
        Set<Integer> set = new HashSet<>();  // 用于单层去重，避免 相同层 使用相同元素（位置不同，元素值相同的元素）
        for (int i = 0; i < nums.length; i++) {
            // 单层去重
            if (set.contains(nums[i])) {
                continue;
            }
            // 只有当前元素未使用过，才进行递归
            if (!used[i]) {
                used[i] = true;
                oneResult.add(nums[i]);
                doPermuteUnique(nums, used);
                // 回溯
                oneResult.remove(oneResult.size() - 1);
                used[i] = false;
                // 记录当前元素值，用于单层去重
                set.add(nums[i]);
            }
        }
    }
}
