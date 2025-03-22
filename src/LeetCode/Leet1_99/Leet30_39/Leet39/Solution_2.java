package LeetCode.Leet1_99.Leet30_39.Leet39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/3/21 14:05
 * @Description TODO: 方法二   递归回溯  剪枝优化 2ms    90.21%
 */
class Solution_2 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> nowResult = new ArrayList<>();
    int[] array;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 排序后，可以剪枝优化
        Arrays.sort(candidates);
        array = candidates;
        getCombinationSum(0, target);
        return result;
    }

    public void getCombinationSum(int startIndex, int target){
        if(startIndex == array.length || target < 0){
            return;
        }
        // 找到一组答案
        if(target == 0){
            result.add(new ArrayList<>(nowResult));
            return;
        }
        for(int i = startIndex; i < array.length;i++){
            int num = array[i];
            // 剪枝优化1：因为排序后的数组，后面的元素都比当前元素大，所以如果当前元素已经大于target，后面的元素也都大于target，后面不会再有答案了
            if(num > target){
                return;
            }
            nowResult.add(num);
            getCombinationSum(i, target - num);
            nowResult.remove(nowResult.size() - 1);
        }
    }
}
