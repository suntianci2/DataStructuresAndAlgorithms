package BasicDataStructures.Queue.PriorityQueue1;

import BasicDataStructures.Queue.Queue;

// 无序数组实现优先级队列
public class PriorityQueue1<E extends Priority> implements Queue<E>{

    private Priority[] array;

    private int size = 0;

    public PriorityQueue1(int capacity){
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {
        if(isFull()){
            return false;
        }
        array[size] = value;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        int index = findMax();
        Priority priority = array[index];
        remove(index);
        return (E) priority;
    }

    // 移除索引为index的元素
    private void remove(int index) {
        System.arraycopy(array,index+1, array, index, array.length - 1 - index);
        size--;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        int index = findMax();
        return (E) array[index];
    }

    // 寻找优先级最高的元素索引
    private int findMax() {
        int maxIndex = 0;
        int maxPriority = array[0].priority();
        for (int i = 0; i < size; i++) {
            if(array[i].priority() > maxPriority){
                maxPriority = array[i].priority();
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull(){
        return size == array.length;
    }

}
