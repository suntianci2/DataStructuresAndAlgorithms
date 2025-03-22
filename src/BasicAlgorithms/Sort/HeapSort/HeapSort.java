package BasicAlgorithms.Sort.HeapSort;

/**
 * @ClassName HeapSort
 * @Author 孙天赐
 * @Date 2025/3/18 13:23
 * @Description TODO: 堆排序
 */
public class HeapSort {
    public static void heapSort(int[] array){
        heapify(array, array.length);
        for (int right = array.length - 1; right >= 0; right--) {
            swap(array, 0, right);
            down(array, 0, right);
        }
    }

    // 建立大顶堆
    private static void heapify(int[] array, int size) {
        // 对于每一个**非叶子节点**，从后往前依次执行下潜操作
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(array, i, size);
        }
    }

    // 下潜操作
    private static void down(int[] array, int parent, int size) {
        while(true){
            int left = parent * 2 + 1;
            int right = left + 1;
            int max = parent;
            if (left < size && array[left] > array[max]) {
                max = left;
            }
            if (right < size && array[right] > array[max]) {
                max = right;
            }
            if(max == parent){
                break;
            }
            // 找到了更大的孩子
            swap(array, max, parent);
            down(array, max, size);
        }

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
