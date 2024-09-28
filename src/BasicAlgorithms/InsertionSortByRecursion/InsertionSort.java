package BasicAlgorithms.InsertionSortByRecursion;

public class InsertionSort {
    public static void sort(int[] arr) {
        insertionSort(arr, 1);
    }

    private static void insertionSort(int[] arr, int bound) {

        // 递归终止条件
        if (bound == arr.length) {
            return;
        }

        int temp = arr[bound];  // 记录待插入的值
        int i = bound - 1;    // 记录应插入的位置

        // 找到该插入的位置
        while (i >= 0 && arr[i] > temp){
            arr[i+1] = arr[i];
            i--;
        }

        // 插入值
        arr[i+1] = temp;

        // 递归插入下一个值
        insertionSort(arr, bound + 1);

    }
}
