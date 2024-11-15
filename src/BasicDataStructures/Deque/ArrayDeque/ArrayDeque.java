package BasicDataStructures.Deque.ArrayDeque;

import BasicDataStructures.Deque.Deque;

import java.util.Iterator;

// 循环数组实现双端队列
public class ArrayDeque<E> implements Deque<E>, Iterable<E> {
    private int head = 0; // 头指针
    private int tail = 0;  // 尾指针
    private E[] array;  // 循环数组

    public ArrayDeque(int capacity){
        // 因为要留一个空间不能使用，所以初始化capacity + 1长度的数组
        array = (E[]) new Object[capacity + 1];
    }
    // 防止增加越界
    public int inc(int value, int capacity){
        if(value + 1 == capacity){
            return 0;
        }
        return value + 1;
    }

    // 防止减少越界
    public int dec(int value, int capacity){
        if(value - 1 < 0){
            return capacity - 1;
        }
        return value - 1;
    }
    @Override
    public boolean offerFirst(E e) {
        if(isFull()){
            return false;
        }
        head = dec(head, array.length);
        array[head] = e;
        return true;

    }

    @Override
    public boolean offerLast(E e) {
        if(isFull()){
            return false;
        }
        array[tail] = e;
        tail = inc(tail, array.length);
        return true;
    }

    @Override
    public E pollFirst() {
        if(isEmpty()){
            return null;
        }
        E e = array[head];
        // 释放内存
        array[head] = null;
        head = inc(head, array.length);
        return e;
    }

    @Override
    public E pollLast() {

        if(isEmpty()){
            return null;
        }
        tail = dec(tail, array.length);
        E e = array[tail];
        // 释放内存
        array[tail] = null;
        return e;
    }

    @Override
    public E peekFirst() {
        return array[head];
    }

    @Override
    public E peekLast() {
        return array[dec(tail, array.length)];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return inc(tail, array.length) == head;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int t = head;
            @Override
            public boolean hasNext() {
                return t != tail;
            }

            @Override
            public E next() {
                E value = array[t];
                t = inc(t, array.length);
                return value;
            }
        };
    }
}
