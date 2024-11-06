package BasicDataStructures.Stack.ArrayStack;

import org.junit.Test;

public class TestArrayStack {
    @Test
    public void pushTest() {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(2);
        for (Integer integer : stack) {
            System.out.println(integer);
        }

    }

    @Test
    public void popTest() {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        stack.push(3);
        stack.push(4);
        stack.push(7);
        stack.push(2);

        stack.pop();
        stack.pop();
        for (Integer i : stack) {
            System.out.println(i);
        }
    }

    @Test
    public void peekTest() {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        stack.push(3);
        stack.push(4);
        stack.push(7);
        stack.push(2);

        System.out.println(stack.peek());
        System.out.println(stack.peek());
        for (Integer i : stack) {
            System.out.println(i);
        }
    }

    @Test
    public void isEmptyTest() {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        stack.push(7);
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        for (Integer i : stack) {
            System.out.println(i);
        }
    }
}
