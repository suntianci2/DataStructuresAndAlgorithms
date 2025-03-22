package LeetCode.Leet1_99.Leet40_49.Leet40;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/22 9:18
 * @Description TODO: 方法一   递归回溯（Set集合去重） 超时
 */
class Solution_1 {
    // 使用Set集合存储答案，可以去重
    Set<List<Integer>> result = new HashSet<>();
    List<Integer> nowResult = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        doCombinationSum(candidates, 0, target);
        // Set集合转List集合
        return new ArrayList<>(result);
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
            if(candidates[i] > target){
                return;
            }
            nowResult.add(candidates[i]);
            // 在后面找目标和为 target - 当前元素值 的组合注意这里的startIndex是i+1，因为不能重复使用元素
            doCombinationSum(candidates, i + 1, target - candidates[i]);
            nowResult.remove(nowResult.size() - 1);
        }
    }
}
