package BasicDataStructures.Stack.LinkedListStack;

import BasicDataStructures.Stack.Stack;
import org.junit.Test;

import java.util.Iterator;

public class TestStack {

    @Test
    public void pushTest(){
        LinkedListStack<Integer> stack = new LinkedListStack<>(5);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(2);
        for (Integer integer : stack) {
            System.out.println(integer);
        }

    }

    @Test
    public void popTest(){
        LinkedListStack<Integer> stack = new LinkedListStack<>(5);
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
    public void peekTest(){
        LinkedListStack<Integer> stack = new LinkedListStack<>(5);
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
    public void isEmptyTest(){
        LinkedListStack<Integer> stack = new LinkedListStack<>(5);
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
