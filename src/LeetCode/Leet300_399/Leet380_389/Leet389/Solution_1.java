package LeetCode.Leet300_399.Leet380_389.Leet389;

/**
 * TODO:**方法一	哈希表数组**	（1ms）
 *
 * 利用一个数组`count`记录`s`出现的字符及其次数，根据`t`出现的字符逐渐减去数组`count`中的元素，最后不为0的索引对应的字符即为目标字符
 */
class Solution_1 {
    public char findTheDifference(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] count = new int['z' - 'a' + 1];
        for (char sss : sArr) {
            count[sss - 'a'] += 1;
        }
        for (char ttt : tArr) {
            count[ttt - 'a'] -= 1;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return (char) (i + 'a');
            }
        }
        return ' ';
    }
}
