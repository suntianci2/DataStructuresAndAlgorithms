package LeetCode.Leet300_399.Leet380_389.Leet389;

/**
 * TODO:==**方法二	ASCII码求差**==	（1ms）
 * <p>
 * `s`内所有字符求ASCII码和，`t`内所有字符求ASCII码和，两者相减则是目标字符的ASCII码
 */
class Solution_2 {
    public char findTheDifference(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int sSum = 0;
        int tSum = 0;
        for (char c : sArr) {
            sSum += c - 'a';
        }
        for (char c : tArr) {
            tSum += c - 'a';
        }
        return (char) (tSum - sSum + 'a');
    }
}
