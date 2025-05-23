package LeetCode.Leet1_99.Leet70_79.Leet70;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/15 14:38
 * @Description TODO: 方法一   递归  超时
 *                  有很多重复计算
 */
class Solution_1 {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
