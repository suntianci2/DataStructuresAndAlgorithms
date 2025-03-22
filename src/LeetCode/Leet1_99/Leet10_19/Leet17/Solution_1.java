package LeetCode.Leet1_99.Leet10_19.Leet17;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/19 20:06
 * @Description TODO: 方法一   递归回溯    0ms 100%
 *                  取字符串中第一个数字对应的字符，然后依次取每一个字符，递归组合后面的字符，并收集答案
 */
class Solution_1 {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    // 题目条件字符串对应的字符数组
    char[] strArr;
    // 将数字作为下标，找到数字对应的字符串
    String[] numtoStr = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        this.strArr = digits.toCharArray();
        getLetterCombinations(0);
        return result;
    }

    // 递归寻找答案  startIndex : 当前处理的strArr的起始索引
    public void getLetterCombinations(int startIndex) {
        // 终止条件1：输入条件为 ""
        if (strArr.length == 0) {
            return;
        }
        // 终止条件2：找到答案
        if (sb.length() == strArr.length) {
            result.add(sb.toString());
            return;
        }
        // 获取数组中第一个数字代表的字符（3或4个）
        char[] character = numtoStr[strArr[startIndex] - '0'].toCharArray();
        // 依次取一个字符作为第一个字符，然后递归组合后续字符
        for (char c : character) {
            // 记录当前字符
            sb.append(c);
            // 从下一个位置寻找后续字符
            getLetterCombinations(startIndex + 1);
            // 回溯
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
