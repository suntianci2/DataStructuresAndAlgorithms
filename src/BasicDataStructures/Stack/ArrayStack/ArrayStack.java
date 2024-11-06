package BasicDataStructures.Stack.ArrayStack;

import BasicDataStructures.Stack.Stack;

import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>, Iterable<E> {
    // 栈容量
    private int capacity;

    // 栈顶位置
    private int top = 0;

    // 用数组当作栈
    private E[] array;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        array = (E[]) new Object[capacity];
    }

    // 向栈顶压入元素
    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        array[top++] = value;
        return true;
    }

    // 向栈顶弹出元素
    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return array[--top];
    }

    // 返回栈顶元素，不弹出
    @Override
    public E peek() {
        return array[top - 1];
    }

    // 判断栈是否为空
    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    // 判断栈是否已满
    @Override
    public boolean isFull() {
        return top == capacity;
    }

    // 迭代器
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int op = top;

            @Override
            public boolean hasNext() {
                return op > 0;
            }

            @Override
            public E next() {
                return array[--op];
            }
        };
    }
}
