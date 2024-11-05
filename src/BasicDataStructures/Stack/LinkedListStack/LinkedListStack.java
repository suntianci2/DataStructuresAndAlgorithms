package BasicDataStructures.Stack.LinkedListStack;

import BasicDataStructures.Stack.Stack;

import java.util.Iterator;

public class LinkedListStack<E> implements Stack<E>, Iterable<E> {
    // 容量
    private int capacity;
    // 已有元素个数
    private int size = 0;
    // 哨兵节点
    private Node<E> head = new Node<>(null, null);

    private static class Node<E> {
        public E value;
        public Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        public Node() {
        }

    }

    public LinkedListStack(int capacity){
        this.capacity=capacity;
    }

    // 向栈顶压入元素
    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        head.next = new Node<E>(value, head.next);
        size++;
        return true;
    }

    // 向栈顶弹出元素
    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        Node<E> thisNode = head.next;
        head.next = thisNode.next;
        size--;
        return thisNode.value;
    }

    // 返回栈顶元素，不弹出
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    // 判断当前栈是否为空
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // 判断当前栈是否已满
    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> thisNode = head.next;
            @Override
            public boolean hasNext() {
                return thisNode != null;
            }

            @Override
            public E next() {
                E value = thisNode.value;
                thisNode = thisNode.next;
                return value;
            }
        };
    }


}
