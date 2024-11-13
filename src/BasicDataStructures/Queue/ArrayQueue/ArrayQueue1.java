package BasicDataStructures.Queue.ArrayQueue;

import BasicDataStructures.Queue.Queue;

import java.util.Iterator;

public class ArrayQueue1<E> implements Queue<E>,Iterable<E> {
    private int start = 0;
    private int end = 0;
    private final int CAPACITY = 5;
    public E[] array = null;

    public ArrayQueue1(){
        array = (E[]) new Object[CAPACITY + 1];
    }
    // 向队尾插入值
    @Override
    public boolean offer(E value) {
        if (isFull()){
            return false;
        }
        array[end] = value;
        end = (end + 1) % array.length;
        return true;
    }

    // 从队头获取值，并移除
    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        E value = array[start];
        start = (start + 1) % array.length;
        return value;
    }

    // 从队头获取值，不移除
    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return array[start];
    }

    @Override
    public boolean isEmpty() {
        return start == end;
    }

    public boolean isFull(){
        return ((end + 1) % array.length) == start;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator() {
            int startIndex = start;
            @Override
            public boolean hasNext() {
                return startIndex != end;
            }

            @Override
            public E next() {
                E value = array[startIndex];
                startIndex = (startIndex + 1) % array.length;
                return value;
            }
        };
    }
}
