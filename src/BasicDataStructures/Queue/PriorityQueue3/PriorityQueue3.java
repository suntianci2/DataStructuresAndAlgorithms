package BasicDataStructures.Queue.PriorityQueue3;

import BasicDataStructures.Queue.Priority;
import BasicDataStructures.Queue.Queue;

// 使用满足大顶堆规律的无序数组实现优先级队列
public class PriorityQueue3<E extends Priority> implements Queue<E> {
    private int size = 0;
    private Priority[] array;

    public PriorityQueue3(int capacity) {
        array = new Priority[capacity];
    }

    // 当前索引的父索引
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // 当前索引的左孩子
    private int leftSon(int index) {
        return index * 2 + 1;
    }

    // 当前索引的右孩子
    private int rightSon(int index) {
        return index * 2 + 2;
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[size] = value;
        // 上浮新元素，确保满足大顶堆
        up(size);
        size++;
        return true;
    }

    // 上浮(确保满足大顶堆)
    private void up(int index) {
        // 父元素索引
        int parent = parent(index);
        // 如果到最上面了，则不用上浮了（递归结束条件之一）
        if (index == 0) {
            return;
        }
        if (array[index].priority() > array[parent].priority()) {
            swap(index, parent);
            // 递归，对parent索引的元素进行上浮操作
            up(parent);
        }
    }

    // 交换两个元素
    private void swap(int index1, int index2) {
        E temp = (E) array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        // 先交换顶和底元素，方便出队
        swap(0, size - 1);
        E value = (E) array[size - 1];
        array[size - 1] = null;
        size--;
        // 然后执行下潜操作，确保满足大顶堆
        down(0);
        return value;
    }

    // 下潜操作，确保满足大顶堆
    private void down(int index) {
        // 递归终止条件
        if (index >= size) {
            return;
        }
        // 找到孩子中最大的那个孩子
        int max = array[index].priority();
        int newIndex = index;
        if (leftSon(index) < size && max < array[leftSon(index)].priority()) {
            max = array[leftSon(index)].priority();
            newIndex = leftSon(index);
        }
        if (rightSon(index) < size && max < array[rightSon(index)].priority()) {
            max = array[leftSon(index)].priority();
            newIndex = rightSon(index);
        }

        // 递归下潜
        if(newIndex != index){
            swap(index, newIndex);
            down(newIndex);
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[0];
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
