package LeetCode.Leet300_399.Leet340_349.Leet345;

import java.util.Collections;
import java.util.HashSet;

/**
 * TODO:**方法一	哈希表+双指针**	（3ms）
 * <p>
 * 两个指针分别从头和尾开始往另一边移动，交换每一对碰到的元音字母，直到两个指针相遇
 */
class Solution_1 {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        HashSet<Character> set = new HashSet<>();
        Collections.addAll(set, 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        while (true) {
            // 找到左侧的元音字母
            while (i < arr.length && !set.contains(arr[i])) {
                i++;
            }
            // 找到右侧的元音字母
            while (j >= 0 && !set.contains(arr[j])) {
                j--;
            }
            // 终止判断
            if (j < i) {
                break;
            }
            // 交换字母
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}