package LeetCode.Leet100_199.Leet150_159.Leet151;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/1/6 18:34
 * @Description TODO: 方法二   双指针模拟   2ms 97.06%
 */
class Solution_2 {
    public String reverseWords(String s) {
        char[] sArr = s.toCharArray();
        int len = sArr.length;
        int startIndex = len - 1;
        int endIndex = len - 1;
        StringBuilder sb = new StringBuilder();
        // 从最后面开始
        while (startIndex >= 0 && endIndex >= 0) {
            // 找到一个单词的最后一个字符
            if (sArr[endIndex] == ' ') {
                endIndex--;
                continue;
            }
            startIndex = endIndex;
            // 找到这个单词的起始位置 - 1
            while (startIndex >= 0 && sArr[startIndex] != ' ') {
                startIndex--;
            }
            // 将这个单词添加到sb中
            // 如果不是第一次添加，则先添加一个空格
            if (sb.length() != 0) {
                sb.append(" ");
            }
            for (int i = startIndex + 1; i <= endIndex; i++) {
                sb.append(sArr[i]);
            }
            // 将endIndex移动到startIndex前面一个位置，进入下一次循环，开始寻找前一个单词
            endIndex = startIndex - 1;
        }
        return sb.toString();
    }
}
