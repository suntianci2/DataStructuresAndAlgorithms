package LeetCode.Leet500_599.Leet500_509.Leet509;

/**
 * @ClassName Solution_3
 * @Author 孙天赐
 * @Date 2025/5/14 13:48
 * @Description TODO: 方法三  动态规划  0ms 100%
 *                  相比方法二，空间复杂度更低
 */
class Solution_3 {
    public int fib(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        int result = 1;  // n
        int pre = 1;  // n-1
        int prePre = 0;  // n-2
        for(int i = 3;i <= n;i++){
            // 更新n-2, n-1, n
            prePre = pre;
            pre = result;
            result = pre + prePre;

        }
        return result;
    }
}
