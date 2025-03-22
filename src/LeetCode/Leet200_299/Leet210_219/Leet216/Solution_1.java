package LeetCode.Leet200_299.Leet210_219.Leet216;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/19 16:13
 * @Description TODO: 方法一   递归回溯    0ms 100%
 *                  假设当前index处元素包含在答案中，递归去[index + 1, 9]中寻找剩余的数，其和为n - 当前元素值
 */
class Solution_1 {
    // 结果集合
    List<List<Integer>> result = new ArrayList<>();

    // 当前组合
    List<Integer> nowList = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        combination(k, n, 1);
        return result;
    }

    // 在[startIndex, 9]中寻找 k 个数，其和为 n
    public void combination(int k, int n, int startIndex) {
        // 剪枝优化1，如果要求的k个数数量大于目标和n，则后面不可能再有答案了，直接返回
        if (k > n) {
            return;
        }
        // 剪枝优化2，如果当前和已经大于目标和n，则后面不可能再有答案了，直接返回
        if(n < 0){
            return;
        }
        // 当找到了k个元素时
        if (k == 0) {
            // 找到答案：当元素和为n时，则找到了一个答案，将当前组合加入结果列表
            // 剪枝优化3：当目标和不为0，再往后也找不到答案了，直接返回
            if (n == 0) {
                result.add(new ArrayList<>(nowList));
            }
            return;
        }
        for (int i = startIndex; i <= 9; i++) {
            // 剪枝优化4，如果剩下的数不够凑k个数，则后面不可能再有答案了，直接返回
            if (9 - startIndex < k - 1) {
                return;
            }
            nowList.add(i);
            // 递归去[startIndex + 1, 9]中寻找k - 1个数，其和为n - i
            combination(k - 1, n - i, i + 1);
            nowList.remove(nowList.size() - 1);
        }
    }
}