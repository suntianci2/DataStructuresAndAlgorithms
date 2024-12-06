package LeetCode.Leet300_399.Leet380_389.Leet389;

/**
 * TODO:==**方法三	位运算**==	（1ms）
 * <p>
 * 使用异或`^`运算。异或运算有以下特点：
 * <p>
 * `a ^ a = 0`：相同的值异或结果为 0。
 * <p>
 * `a ^ 0 = a`：任意值与 0 异或结果为该值。
 * <p>
 * 通过对 `s` 和 `t` 的所有字符进行异或，相同的字符会互相抵消，最后 `req` 中剩下的就是 `t` 中多出的那个字符的ASCII码值。
 */
class Solution_3 {
    public char findTheDifference(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int req = 0;
        for (char c : sArr) {
            req ^= c;
        }
        for (char c : tArr) {
            req ^= c;
        }
        return (char) req;
    }
}
