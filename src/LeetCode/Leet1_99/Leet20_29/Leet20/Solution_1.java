package LeetCode.Leet1_99.Leet20_29.Leet20;

import java.util.Stack;

/**
 * TODO:==**方法一	栈**==	（2ms）
 */
class Solution_1 {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        if (arr.length % 2 != 0) {
            return false;
        }
        // 栈，用于存放遇到的左括号
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            // 如果为左括号，则压入元素
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                // 如果为右括号，则从栈顶弹出元素（左括号），判断弹出的左括号是否与当前右括号匹配
                // 如果此时栈为空，也不满足条件
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == ')' && stack.pop() != '(') {
                    return false;
                }
                if (c == ']' && stack.pop() != '[') {
                    return false;
                }
                if (c == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }
        // 最后，只有栈为空才满足条件
        if (stack.isEmpty()) {
            return true;
        }
        return false;

    }
}
