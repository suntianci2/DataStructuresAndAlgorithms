package BasicDataStructures.Queue.PriorityQueue2;

import BasicDataStructures.Queue.Priority;
import BasicDataStructures.Queue.Queue;

// 有序数组实现优先级队列
public class PriorityQueue2<E extends Priority> implements Queue<E> {

    private int size = 0;

    private Priority[] array;

    public PriorityQueue2(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        insert(value);
        size++;
        return true;
    }

    // 插入元素
    private void insert(E value) {
        int i = size - 1;
        while (i >= 0 && value.priority() <= array[i].priority()) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = value;

    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E e = (E) array[size - 1];
        array[size - 1] = null;
        size--;
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
