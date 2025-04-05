package LeetCode.Leet1_99.Leet40_49.Leet47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/4/5 14:21
 * @Description TODO: 方法二   递归回溯    2ms 58.92%
 *                  先排序，然后递归回溯，同时处理树层和树枝去重（used）
 */
class Solution_2 {
    List<List<Integer>> result = new ArrayList<>();  // 存储结果集
    List<Integer> oneResult = new ArrayList<>();  // 存储单个结果

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);  // 排序用于去重
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
        for (int i = 0; i < nums.length; i++) {
            // 去重（树层去重和树枝去重）
            if (i != 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
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
            }
        }
    }
}
