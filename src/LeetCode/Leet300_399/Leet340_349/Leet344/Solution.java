package LeetCode.Leet300_399.Leet340_349.Leet344;

/**
 * @ClassName Solution
 * @Author 孙天赐
 * @Date 2025/1/4 14:54
 * @Description TODO: 方法一 前后两两交换    0ms 100%
 */
class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        for(int i = 0; i < len / 2;i++){
            char temp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = temp;
        }
    }
}