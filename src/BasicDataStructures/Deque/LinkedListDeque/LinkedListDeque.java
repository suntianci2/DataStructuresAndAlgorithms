package BasicDataStructures.Deque.LinkedListDeque;

import BasicDataStructures.Deque.Deque;

import java.util.Iterator;

// 基于双向环形链表的双端队列
public class LinkedListDeque<E> implements Deque<E>, Iterable<E> {

    // 队列容量
    int capacity;

    // 当前队列大小
    int size = 0;

    Node<E> sentinel;

    // 节点类
    static class Node<E> {
        Node<E> pre;
        E value;
        Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        public Node(Node<E> pre, E value, Node<E> next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }
    }

    // 构造方法
    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
        sentinel = new Node<E>(null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
    }

    @Override
    public boolean offerFirst(E e) {
        if (isFull()) {
            return false;
        }
        Node<E> aNode = sentinel;
        Node<E> bNode = sentinel.next;
        Node<E> newNode = new Node<>(aNode, e, bNode);
        aNode.next = newNode;
        bNode.pre = newNode;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (isFull()) {
            return false;
        }
        Node<E> aNode = sentinel.pre;
        Node<E> bNode = sentinel;
        Node<E> newNode = new Node<>(aNode, e, bNode);
        aNode.next = newNode;
        bNode.pre = newNode;
        size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> aNode = sentinel;
        Node<E> removedNode = sentinel.next;
        Node<E> bNode = sentinel.next.next;
        aNode.next = bNode;
        bNode.pre = aNode;
        size--;
        return removedNode.value;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> aNode = sentinel.pre.pre;
        Node<E> removedNode = sentinel.pre;
        Node<E> bNode = sentinel;
        aNode.next = bNode;
        bNode.pre = aNode;
        size--;
        return removedNode.value;
    }

    @Override
    public E peekFirst() {
        return sentinel.next.value;
    }

    @Override
    public E peekLast() {
        return sentinel.pre.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> thisNode = sentinel.next;
            @Override
            public boolean hasNext() {
                return thisNode != sentinel;
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
