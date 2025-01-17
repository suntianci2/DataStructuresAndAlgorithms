package LeetCode.Leet100_199.Leet150_159.Leet151;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/1/6 18:12
 * @Description TODO: 方法一   模拟  6ms 61.77%
 *                      按照空格切分，再收集为List，最后使用StringBuilder倒序拼接
 */
class Solution_1 {
    public String reverseWords(String s) {
        String[] sArr = s.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < sArr.length; i++) {
            if (" ".equals(sArr[i]) || "".equals(sArr[i])) {
                continue;
            }
            list.add(sArr[i]);
            if (i != sArr.length - 1) {
                list.add(" ");
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
