package LeetCode.Leet100_199.Leet150_159.Leet150;

import java.util.Stack;

/**
 * TODO:==**方法一	栈**==	（6ms）
 *
 * 使用数据结构**栈**存放原始整数和经过操作后的整数
 */
class Solution_1 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer num1;
        Integer num2;
        for (String s : tokens) {
            // 如果是运算符，则弹出两个元素，进行运算，将运算结果压入栈
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 - num1);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 / num1);
                    break;
                // 如果不是运算符，则是操作数，将操作数压入栈中。
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        // 最后栈中剩下的元素即为答案
        return stack.peek();
    }

}
