package LeetCode.Leet300_399.Leet380_389.Leet387;

/**
 * TODO:==**方法一	哈希表数组**==	（4ms）
 *
 * 利用一个数组存储每个字母的出现次数
 */
class Solution_1 {
    public int firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        int[] count = new int[26];
        // 记录每个字母出现的次数
        for(char a : arr){
            count[a - 'a'] += 1;
        }
        // 从原字符串数组中逐个寻找只出现一次的字符
        for(int i = 0;i < arr.length;i++){
            if(count[arr[i] - 'a'] == 1){
                return i;
            }
        }
        // 未找到唯一字符
        return -1;
    }
}
