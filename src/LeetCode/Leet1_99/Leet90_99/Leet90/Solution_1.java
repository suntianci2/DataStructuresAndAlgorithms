package LeetCode.Leet1_99.Leet90_99.Leet90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/29 15:56
 * @Description TODO: 方法一   递归回溯    1ms 97.76%
 */
class Solution_1 {
    List<List<Integer>> result = new ArrayList<>();  // 存放所有结果
    List<Integer> oneResult = new ArrayList<>();  // 存放每一种结果
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 排序是为了避免出现重复
        Arrays.sort(nums);
        doSubsetsWithDup(nums, 0);
        return result;
    }

    public void doSubsetsWithDup(int[] nums, int startIndex){
        result.add(new ArrayList<>(oneResult));
        for(int i = startIndex;i < nums.length;i++){
            // 跳过相邻重复值，避免出现重复子集
            // 例如：[1, 2, 2]  当i = 1时，会跳过i = 2的情况，因为i = 2的情况已经在i = 1的情况中考虑过了
            if(i != startIndex && nums[i] == nums[i - 1]){
                continue;
            }
            oneResult.add(nums[i]);
            doSubsetsWithDup(nums, i + 1);
            oneResult.remove(oneResult.size() - 1);  // 回溯
        }
    }
}