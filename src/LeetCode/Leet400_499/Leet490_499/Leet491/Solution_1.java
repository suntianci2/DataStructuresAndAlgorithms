package LeetCode.Leet400_499.Leet490_499.Leet491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/30 17:06
 * @Description TODO: 方法一   递归回溯    6ms 91.88%
 *                  无法通过排序去重，排序后无法寻找答案
 *                  所以使用Set集合记录出现过的元素，并去重，注意Set不能为全局变量，而是每层递归都有一个Set
 *                  如果Set为全局变量，会影响后面的递归，并漏解
 */
class Solution_1 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> oneResult = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        doFindSubsequences(nums, 0);
        return result;
    }

    public void doFindSubsequences(int[] nums, int startIndex){
        // 找到一个答案
        if(oneResult.size() >= 2){
            result.add(new ArrayList<>(oneResult));
        }
        // 递归终止条件
        if(startIndex >= nums.length){
            return;
        }
        // 判断当层是否出现重复元素
        Set<Integer> used = new HashSet<>();

        for(int i = startIndex;i < nums.length;i++){
            // 同层去重，防止出现重复答案
            if(used.contains(nums[i])){
                continue;
            }
            // 只有满足非递减序列，才进入递归回溯
            if(oneResult.isEmpty() || nums[i] >= oneResult.get(oneResult.size() - 1)){
                oneResult.add(nums[i]);
                doFindSubsequences(nums, i + 1);
                oneResult.remove(oneResult.size() - 1);
            }
            // 当前元素已经访问，后续出现重复元素不再访问
            used.add(nums[i]);
        }

    }
}