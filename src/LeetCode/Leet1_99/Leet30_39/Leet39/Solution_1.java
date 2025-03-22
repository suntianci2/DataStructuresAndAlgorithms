package LeetCode.Leet1_99.Leet30_39.Leet39;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/21 13:58
 * @Description TODO: 方法一   递归回溯 3ms    28.88%
 */
class Solution_1 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> nowResult = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        getCombinationSum(candidates, 0, target);
        return result;
    }

    public void getCombinationSum(int[] arr, int startIndex, int target){
        // 递归终止条件
        if(startIndex == arr.length || target < 0){
            return;
        }
        // 找到一组答案
        if(target == 0){
            result.add(new ArrayList<>(nowResult));
            return;
        }

        for(int i = startIndex; i < arr.length;i++){
            nowResult.add(arr[i]);
            // 递归寻找答案，注意这里的startIndex是i，因为可以重复使用元素
            getCombinationSum(arr, i, target - arr[i]);
            nowResult.remove(nowResult.size() - 1);  // 回溯
        }
    }
}
