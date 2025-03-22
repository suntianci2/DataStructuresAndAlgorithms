package BasicAlgorithms.Sort.InsertionSort;

/**
 * @ClassName InsertionSort
 * @Author 孙天赐
 * @Date 2025/3/18 14:05
 * @Description TODO: 插入排序（非递归）
 */
public class InsertionSort {
    public static void insertionSort(int[] array) {
        for (int low = 1; low < array.length; low++) {
            int temp = array[low];  // 待插入的值
            int i = low - 1;
            // 自右向左寻找插入位置，同时将大于temp的元素后移，为temp腾出插入位置
            while (i >= 0 && array[i] > temp) {
                array[i + 1] = array[i];
                i--;
            }
            // 找到插入位置
            if (i != low - 1) {
                array[i + 1] = temp;
            }

        }
    }
}
