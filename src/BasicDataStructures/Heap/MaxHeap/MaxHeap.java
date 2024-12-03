package BasicDataStructures.Heap.MaxHeap;

// 大顶堆
public class MaxHeap {
    int size = 0;

    int[] array;

    public MaxHeap(int capacity) {
        array = new int[capacity];
    }

    public MaxHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    // 建立大顶堆
    private void heapify() {
        // 对于每一个**非叶子节点**，从后往前依次执行下潜操作
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
        }
    }

    // 下潜操作
    private void down(int index) {
        // 找到当前索引元素的左孩子元素索引
        int lIndex = index * 2 + 1;
        // 找到当前索引元素的右孩子元素索引
        int rIndex = index * 2 + 2;
        // 执行下潜操作
        int max = array[index];
        int maxIndex = index;
        if (lIndex < size && array[lIndex] > max) {
            max = array[lIndex];
            maxIndex = lIndex;
        }
        if (rIndex < size && array[rIndex] > max) {
            max = array[rIndex];
            maxIndex = rIndex;
        }
        // 表示可以下潜，左右孩子中存在比当前元素还大的值
        if (maxIndex != index){
            swap(index, maxIndex);
            // 递归执行下潜操作
            down(maxIndex);
        }
    }

    private void swap(int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
