package LeetCode.Leet100_199.Leet130_139.Leet131;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/23 15:04
 * @Description TODO: 方法一   递归回溯 13ms   17.57%
 *                  效率低的原因：每种子串都要判断是否回文，所以判断回文的地方会有很多重复计算
 */
class Solution_1 {
    List<List<String>> result = new ArrayList<>();
    List<String> nowResult = new ArrayList<>();

    public List<List<String>> partition(String s) {
        char[] sArr = s.toCharArray();
        doPartition(sArr, 0);
        return result;
    }

    public void doPartition(char[] sArr, int startIndex) {
        // 找到答案（递归终止条件）
        if (startIndex >= sArr.length) {
            result.add(new ArrayList<>(nowResult));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i < sArr.length; i++) {
            // sb记录的是索引[startIndex, i]组合成的字符串
            sb.append(sArr[i]);
            // 判断字符串[startIndex, i]是否为回文串，只有是回文串才进行递归回溯
            if (isPalindrome(sb.toString())) {
                nowResult.add(sb.toString());
                doPartition(sArr, i + 1);  // 从i + 1的位置开始，继续分割
                nowResult.remove(nowResult.size() - 1);  // 回溯
            }

        }
    }

    // 判断给定字符串是否为回文串
    public boolean isPalindrome(String s) {
        // char[] arr = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
