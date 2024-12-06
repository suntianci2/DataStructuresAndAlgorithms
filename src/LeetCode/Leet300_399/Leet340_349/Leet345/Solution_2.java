package LeetCode.Leet300_399.Leet340_349.Leet345;

/**
 * TODO:==**方法二	双指针**==	（2ms）
 * <p>
 * 对**方法一**的优化。
 * <p>
 * 1. 不使用哈希表，将判断是否为元音字母单独放到一个函数中。
 * 2. 将移动指针操作放到一个循环中实现
 */
class Solution_2 {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (isYuan(arr[i]) && isYuan(arr[j])) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            } else {
                if (!isYuan(arr[i])) {
                    i++;
                }
                if (!isYuan(arr[j])) {
                    j--;
                }
            }
        }
        return new String(arr);
    }

    // 判断一个字符是否为元音字母
    public boolean isYuan(char c) {
        return (c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u') || (c == 'A') || (c == 'E') || (c == 'I') || (c == 'O') || (c == 'U');
    }
}
