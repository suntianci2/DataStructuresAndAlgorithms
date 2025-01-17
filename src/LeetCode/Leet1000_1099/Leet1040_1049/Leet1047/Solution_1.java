package LeetCode.Leet1000_1099.Leet1040_1049.Leet1047;

import java.util.Stack;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/1/17 16:56
 * @Description TODO:   方法一     栈   81ms   45.14%
 * 看了答案才知道，可以用Deque作为栈，方法与Stack基本一致。（效率接近）
 * 也可以直接拿StringBuilder来当作栈使用，append()：向尾部添加元素，deleteCharAt(index)：删除索引处的元素（23ms）
 */
class Solution_1 {
    public String removeDuplicates(String s) {
        Stack<Character> result = new Stack<>();
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            if (result.isEmpty()) {
                // 如果栈为空，则直接将当前字符压入栈，后续操作不再进行
                result.push(sArr[i]);
                continue;
            }

            // 如果当前元素与栈顶元素相同，则弹出栈顶元素
            if (result.peek() == sArr[i]) {
                result.pop();
            } else {  // 否则，将当前元素压入栈
                result.push(sArr[i]);
            }

        }

        // 最后栈中的结果就是答案
        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()) {
            sb.append(result.pop());
        }
        // 由于栈是先进后出，所以直接取出拼接，会是反过来的。记得反转
        return sb.reverse().toString();

    }
}
