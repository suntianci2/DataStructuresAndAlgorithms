package BasicDataStructures.Heap;

import BasicDataStructures.Heap.MaxHeap.MaxHeap;

/**
 * 使用大顶堆实现堆排序
 */
public class SortByHeap {
    public static void main(String[] args) {
        int[] array = {1,6,9,4,2,13,24,12,18,16,29};
        MaxHeap heap = new MaxHeap(array);
        // 循环，直至只剩堆顶元素未处理
        while(heap.size != 1){
            // 将堆顶（最大值）放到最后
            heap.swap(0,heap.size - 1);
            // 放到最后后，这个元素的位置就固定了，后续就不需要再调整这个元素了，
            // 所以size-1，表示后续只需要调整前面的元素，并且防止其他方法接触到该元素。
            // 这个时候的size不是表示堆的大小了，而是还剩前面多少个元素没有排序
            heap.size--;
            // 对于新的堆顶，执行下潜操作。这时候的下潜操作不会涉及到刚才放在堆最后的元素
            heap.down(0);
        }
        // 循环结束后，数组元素就已经排好序了
        // 此时，size受到了影响，恢复为初始值
        heap.size = array.length;
        System.out.println(heap);
    }
}
