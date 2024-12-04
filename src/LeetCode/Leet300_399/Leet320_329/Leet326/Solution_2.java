package LeetCode.Leet300_399.Leet320_329.Leet326;

/**
 * TODO:**方法二	投机取巧**	(8ms)
 *
 * 在题目给定的 32 位有符号整数的范围内，最大的 3 的幂为 $3^{19}$=1162261467。我们只需要判断 n 是否是 $3^{19}$ 的约数即可。
 */
class Solution_2 {
    public boolean isPowerOfThree(int n) {
        if(n < 1){
            return false;
        }
        return Math.pow(3,19) % n == 0;
    }
}
