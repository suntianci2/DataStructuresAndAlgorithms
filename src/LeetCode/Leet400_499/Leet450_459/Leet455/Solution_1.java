package LeetCode.Leet400_499.Leet450_459.Leet455;

import java.util.Arrays;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/10 15:58
 * @Description TODO: 方法一	贪心（排序后不断寻找局部最优）	8ms	100%
 */
class Solution_1 {
    public int findContentChildren(int[] g, int[] s) {
        int result = 0;
        int i = 0;  // 指向孩子数组
        int j = 0;  // 指向饼干数组
        // 排序，便于寻找局部最优解
        Arrays.sort(g);
        Arrays.sort(s);
        while(i < g.length && j < s.length){
            if(g[i] <= s[j]){
                // 当前饼干可以满足当前孩子，则计数+1，处理下一个孩子和饼干
                result++;
                i++;
            }else{
                // 当前饼干不能满足当前孩子，则看下一个饼干能否满足当前孩子
            }
            j++;
        }
        return result;
    }
}
