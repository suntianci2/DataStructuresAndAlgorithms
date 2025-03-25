package LeetCode.Leet1_99.Leet70_79.Leet78;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/25 14:25
 * @Description TODO: 方法一   递归回溯    0ms 100%
 */
class Solution_1 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> nowResult = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        doSubsets(nums, 0);
        return result;
    }

    public void doSubsets(int[] nums, int startIndex) {
        // 这里不需要任何条件，每次递归都是一个答案（空集也是答案）
        result.add(new ArrayList<>(nowResult));

        // 单层递归逻辑
        for (int i = startIndex; i < nums.length; i++) {
            nowResult.add(nums[i]);  // 当前元素加入结果集
            doSubsets(nums, i + 1);  // 递归找组合
            nowResult.remove(nowResult.size() - 1);  // 回溯
        }
    }
}