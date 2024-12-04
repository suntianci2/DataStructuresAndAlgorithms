package BasicDataStructures.Heap.MaxHeap;

import java.util.StringJoiner;

// 大顶堆
public class MaxHeap {
    int size = 0;

    int[] array;

    public MaxHeap(int capacity) {
        this.array = new int[capacity];
    }

    public MaxHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    public MaxHeap(int[] array, int capacity) {
        this.array = new int[capacity];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
            this.size++;
        }
        heapify();
    }

    // 建立大顶堆
    private void heapify() {
        // 对于每一个**非叶子节点**，从后往前依次执行下潜操作
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
        // 直接取出效率低，因为需要移动堆中删除的索引后面的元素。
        // 先和堆底元素交换
        swap(index, size - 1);
        // 然后移除堆底元素
        int value = array[--size];
        // 然后对索引处的元素执行下潜操作
        down(index);
        return value;
    }

    // 替换堆顶元素
    public int replace(int newValue) {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        int oldValue = array[0];
        array[0] = newValue;
        down(0);
        return oldValue;
    }

    // 向堆尾部添加元素
    public boolean offer(int value) {
        if (isFull()) {
            return false;
        }
        array[size++] = value;
        up(size - 1);
        return true;
    }

    // 下潜操作
    private void down(int index) {
        // 找到当前索引元素的左孩子元素索引
        int lIndex = index * 2 + 1;
        // 找到当前索引元素的右孩子元素索引
        int rIndex = index * 2 + 2;
        // 执行下潜操作
        int maxIndex = index;
        if (lIndex < size && array[lIndex] > array[maxIndex]) {
            maxIndex = lIndex;
        }
        if (rIndex < size && array[rIndex] > array[maxIndex]) {
            maxIndex = rIndex;
        }
        // 表示可以下潜，左右孩子中存在比当前元素还大的值
        if (maxIndex != index) {
            swap(index, maxIndex);
            // 递归执行下潜操作
            down(maxIndex);
        }
    }

    // 上浮操作
    private void up(int index) {
        // 找到当前元素的父节点索引
        int parent = (index - 1) / 2;
        // down方法是用递归实现的，这里用循环
        // 存在父节点，则循环
        while (parent >= 0) {
            // 若当前节点元素值小于等于父节点，则循环停止
            if (array[index] <= array[parent]) {
                break;
            }
            swap(index, parent);
            // 把父节点看作新节点，继续循环
            index = parent;
            // 找到新的节点的父节点索引
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
        StringJoiner sj = new StringJoiner(", ","[","]");
        for (int i = 0; i < this.size; i++) {
            sj.add(String.valueOf(this.array[i]));
        }
        return sj.toString();
    }
}
