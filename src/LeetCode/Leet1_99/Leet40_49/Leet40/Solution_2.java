package LeetCode.Leet1_99.Leet40_49.Leet40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/3/23 11:26
 * @Description TODO: 方法二   递归回溯（手动去重）  2ms 99.63%
 *                  手动去重原理：
 *                      在横向广度层面，如果前一个元素与后一个元素相同，则跳过当前循环，因为前面一层已经出现过当前层的答案
 *                      注意只有第二层循环后才开始判断是否元素重复，
 *                          如果第一层循环时也判断，会导致当某个解有重复元素时，会漏掉这个解
 */
class Solution_2 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> nowResult = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 排序便于去重和剪枝
        Arrays.sort(candidates);
        doCombinationSum(candidates, 0, target);
        return result;
    }

    // 递归寻找答案
    public void doCombinationSum(int[] candidates, int startIndex, int target){
        // 递归终止条件：找到答案或者target小于0
        if(target <= 0){
            if(target == 0){
                result.add(new ArrayList<>(nowResult));
            }
            return;
        }
        // 递归寻找答案
        for(int i = startIndex;i < candidates.length;i++){
            // 剪枝优化1：当当前元素大于target时，后面的元素也大于target，直接返回
            if(candidates[i] > target){
                return;
            }
            // 在横向广度层面，如果前一个元素与后一个元素相同，则跳过当前循环，因为前面一层已经出现过当前层的答案
            // 注意这里的i > startIndex，因为第一次循环时，i = startIndex，所以第二层循环才开始判断是否元素重复，
            // 如果第一层循环时也判断，会导致当某个解有重复元素时，会漏掉这个解
            if(i > startIndex && candidates[i - 1] == candidates[i]){
                continue;
            }
            nowResult.add(candidates[i]);
            // 在后面找目标和为 target - 当前元素值 的组合注意这里的startIndex是i+1，因为不能重复使用元素
            doCombinationSum(candidates, i + 1, target - candidates[i]);
            nowResult.remove(nowResult.size() - 1);
        }
    }
}
