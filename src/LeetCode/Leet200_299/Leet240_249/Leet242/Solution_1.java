package LeetCode.Leet200_299.Leet240_249.Leet242;

/**
 * TODO:方法一 哈希表数组   (1ms)   100%
 * 使用一个数组来记录字符串s中每个字母的出现次数
 * 然后变量字符串t，减去相应字母的出现次数
 * 若最终该数组全为0，则返回true。否则返回false
 */
class Solution_1 {
    public boolean isAnagram(String s, String t) {
        // 字符串转换为字符串数组，因为操作数组的效率要比操作字符串更高
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        if (sArr.length != tArr.length) {
            // 长度不一样肯定为false
            return false;
        }
        int[] arr = new int[26];

        for (char i : sArr) {
            arr[i - 'a']++;
        }

        for (char i : tArr) {
            arr[i - 'a']--;
            if (arr[i - 'a'] < 0) {
                // 如果已经小于0了，则已经不满足要求了，后面不需要再判断了
                return false;
            }
        }

        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
