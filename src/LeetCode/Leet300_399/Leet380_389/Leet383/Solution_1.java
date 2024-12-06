package LeetCode.Leet300_399.Leet380_389.Leet383;

/**
 * TODO:==**方法一	哈希表数组**==	（1ms）
 * <p>
 * 利用一个数组存储magazine出现的字符，再根据ransomNote删除记录的字符，若出现某个字符多删除了一个，则返回false
 */
class Solution_1 {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] rArr = ransomNote.toCharArray();
        char[] mArr = magazine.toCharArray();
        int[] count = new int['z' - 'a' + 1];
        // 记录magazine出现的字符
        for (char c : mArr) {
            count[c - 'a'] += 1;
        }
        // 根据ransomNote删除字符
        for (char c : rArr) {
            count[c - 'a'] -= 1;
            // 出现了多余的字符
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}