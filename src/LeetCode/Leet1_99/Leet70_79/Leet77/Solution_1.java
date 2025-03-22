package LeetCode.Leet1_99.Leet70_79.Leet77;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/18 15:08
 * @Description TODO: 方法一   递归回溯    34ms    10.16%
 *                  选择一个元素（从后往前选择）作为组合的第一个元素，然后在剩下的元素中选择k-1个元素作为组合的其他元素
 *                  递归求解在剩下的元素中选择k-1个元素作为组合的其他元素
 *                  缺点：
 *                      1. 递归层数过多
 *                      2. 递归过程中，重复计算
 */
class Solution_1 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // 如果k为1，那么所有元素都可以单独作为一个组合
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                result.add(list);
            }
            return result;
        }
        // 如果k等于n，那么所有元素都在一个组合中
        if (k == n) {
            List<Integer> onlyResult = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                onlyResult.add(i);
            }
            result.add(onlyResult);
            return result;
        }
        // 递归求解
        // 在[1,n]中，选择一个元素（从后往前选择）作为组合的第一个元素，然后在剩下的元素中选择k-1个元素作为组合的其他元素
        // 递归求解在剩下的元素中选择k-1个元素作为组合的其他元素
        for (int i = n - 1; i >= k - 1; i--) {
            List<List<Integer>> tempResult = combine(i, k - 1);
            for (List<Integer> temp : tempResult) {
                temp.add(i + 1);
                result.add(temp);
            }
        }
        return result;
    }
}
