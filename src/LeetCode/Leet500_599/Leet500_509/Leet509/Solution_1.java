package LeetCode.Leet500_599.Leet500_509.Leet509;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/14 13:42
 * @Description TODO: 方法一   递归  9ms 21.6%
 */
class Solution_1 {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
