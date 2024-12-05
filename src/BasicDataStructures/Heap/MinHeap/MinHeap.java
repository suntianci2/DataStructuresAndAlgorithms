package BasicDataStructures.Heap.MinHeap;

import java.util.StringJoiner;

// 小顶堆
public class MinHeap {
    int size = 0;

    int[] array;

    public MinHeap(int capacity) {
        array = new int[capacity];
    }

    public MinHeap(int[] array) {
        this.array = array;
        size = array.length;
        heapify();
    }

    public MinHeap(int[] array, int capacity) {
        this.array = new int[capacity];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
            size++;
        }
        heapify();
    }

    // 建立小顶堆
    private void heapify() {
        // 对每一个非叶子节点，执行下潜操作
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
        }
    }

    // 获得堆顶元素，但不取出
    public int peek() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        return array[0];
    }

    // 取出堆顶元素
    public int poll() {
        return poll(0);
    }

    // 删除指定索引的元素
    public int poll(int index) {
        if (index >= size) {
            throw new NullPointerException();
        }
        // 直接取出，效率较低，后面的元素可能需要移动位置
        // 所以，先跟最后一个元素交换，然后对新的元素作下潜操作
        swap(index, size - 1);
        int value = array[--size];
        down(index);
        return value;
    }

    // 替换堆顶元素
    public int replace(int newValue) {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        int value = array[0];
        array[0] = newValue;
        down(0);
        return value;
    }

    // 向堆尾部添加元素
    public boolean offer(int value) {
        if (isFull()) {
            return false;
        }
        array[size++] = value;
        // 添加完成后，执行上浮，保持小顶堆
        up(size - 1);
        return true;
    }

    // 下潜操作
    // 与大顶堆不同，这里的下潜是如果最小的孩子节点比自己小，就跟这个孩子节点交换
    private void down(int index) {
        // 左孩子索引
        int lindex = 2 * index + 1;
        // 右孩子索引
        int rindex = 2 * index + 2;
        int minIndex = index;
        if (lindex < size && array[lindex] < array[minIndex]) {
            minIndex = lindex;
        }
        if (rindex < size && array[rindex] < array[minIndex]) {
            minIndex = rindex;
        }
        // 如果这个节点的孩子中有比这个节点小的，则下潜，然后递归执行下潜
        if (minIndex != index) {
            swap(index, minIndex);
            // 递归执行下潜
            down(minIndex);
        }

    }

    // 上浮操作
    // 与大顶堆不同，这里的上浮是如果父节点比自己大，就跟这个父节点交换
    private void up(int index) {
        // 找到当前所有节点的父节点索引
        int parent = (index - 1) / 2;
        // 使用迭代（循环）实现
        while (parent >= 0){
            if (array[parent] <= array[index]){
                break;
            }
            swap(index, parent);
            // 更新当前节点和父节点，用于下一轮循环
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    // 交换两个元素
    private void swap(int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    // 判断堆是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 判断堆是否满
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < this.size; i++) {
            sj.add(String.valueOf(this.array[i]));
        }
        return sj.toString();
    }
}
