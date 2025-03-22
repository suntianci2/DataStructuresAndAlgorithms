package LeetCode.Leet1_99.Leet70_79.Leet77;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/3/18 16:53
 * @Description TODO: 方法二   递归回溯    15ms    99.14%
 *                      对方法一的优化，思路大致一致
 *                      优化点：
 *                          1.将结果集合提升为全局变量，减少集合创建次数
 *                          2.递归过程中，通过判断当前集合的大小，来更新结果集，而原来是通过k值来判断的
 *                          3.方法一每层递归k值都不同（减一），然后通过判断k值是否为1或n来终止递归
 *                              方法二每层递归k值都相同，判断当前组合结果长度与k值是否相同，来终止递归
 *                          4.剪枝优化：
 *                              1.当当前组合结果长度大于k，再往下递归也不会出现答案，直接返回
 *                              2.当剩下的元素不足以出现答案，也就是说即使全部元素组合也比k小，那么直接返回
 */
class Solution_2 {
    // 结果集
    List<List<Integer>> result = new ArrayList<>();

    // 当前组合结果
    List<Integer> nowResult = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        doCombine(n, k);
        return result;
    }

    public void doCombine(int n, int k) {
        int size = nowResult.size();
        if (size > k) {
            // 剪枝优化1，当前组合结果长度大于k，再往下递归也不会出现答案，直接返回
            return;
        } else if (size == k) {
            // 找到一个答案，加入结果集
            result.add(new ArrayList<>(nowResult));
            return;
        }
        for (int i = n - 1; i >= 0; i--) {
            // 剪枝优化2：当剩下的元素不足以出现答案，也就是说即使全部元素组合也比k小，那么直接返回
            // 之所以是 小于 k-1 ，是因为如果 i+size 等于k-1，加上当前循环元素i+1，元素个数正好等于k，会出现一个答案
            // 再小的话，就不会出现答案了
            if (i + size < k - 1) {
                return;
            }
            // 将i+1加入当前组合结果
            nowResult.add(i + 1);
            doCombine(i, k);  // 递归，在更小范围（除去刚加入的元素）内搜索结果
            nowResult.remove(nowResult.size() - 1);  // 回溯，去除结果集中的i+1
        }
    }
}
