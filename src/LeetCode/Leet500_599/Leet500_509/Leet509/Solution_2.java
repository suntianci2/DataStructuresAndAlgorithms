package LeetCode.Leet500_599.Leet500_509.Leet509;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/5/14 13:42
 * @Description TODO: 方法二  动态规划  0ms 100%
 */
class Solution_2 {
    public int fib(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2;i <= n;i++){
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
