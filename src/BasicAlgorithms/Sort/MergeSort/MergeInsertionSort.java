package BasicAlgorithms.Sort.MergeSort;

import java.util.Arrays;

/**
 * @ClassName MergeInsertionSort
 * @Author 孙天赐
 * @Date 2025/3/19 14:20
 * @Description TODO: 归并排序+插入排序
 */
public class MergeInsertionSort {
    public static void main(String[] args) {
        int[] a = {9, 3, 6, 2, 1, 8, 7, 4, 5};
        System.out.println(Arrays.toString(a));
        mergeInsertionSort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("==================");
        int[] b = {9, 3, 7, 2, 8, 1, 4, 6, 5};
        System.out.println(Arrays.toString(b));
        mergeInsertionSort(b);
        System.out.println(Arrays.toString(b));
    }

    public static void mergeInsertionSort(int[] array) {
        int[] temp = new int[array.length];
        split(array, 0, array.length - 1, temp);
    }

    // 归并排序+插入排序
    public static void split(int[] array, int left, int right, int[] temp) {
        // 2.治，当数组范围较小时，使用插入排序，提高性能
        if (right - left <= 7) {
            // 插入排序
            insertionSort(array, left, right);
            return;
        }

        // 1.分
        int mid = (left + right) >>> 1;
        split(array, left, mid, temp);  // 左边部分
        split(array, mid + 1, right, temp);  // 右边部分

        // 3.合
        merge(array, left, mid, mid + 1, right, temp);
        // 4. 拷贝（临时数组拷贝到正常数组中）
        for (int i = left; i <= right; i++) {
            array[i] = temp[i];
        }
    }

    // 插入排序
    public static void insertionSort(int[] array, int left, int right) {
        for (int low = left + 1; low <= right; low++) {
            int temp = array[low];  // 待插入的值
            int i = low - 1;
            // 自右向左寻找插入位置，同时将大于temp的元素后移，为temp腾出插入位置
            while (i >= left && array[i] > temp) {
                array[i + 1] = array[i];
                i--;
            }
            // 找到插入位置
            if (i != low - 1) {
                array[i + 1] = temp;
            }

        }
    }

    // 合并两个有序数组
    private static void merge(int[] array1, int i, int iEnd, int j, int jEnd, int[] array2) {
        int k = i;
        while (i <= iEnd && j <= jEnd) {
            if (array1[i] <= array1[j]) {
                array2[k] = array1[i];
                i++;
            } else {
                array2[k] = array1[j];
                j++;
            }
            k++;
        }
        // 处理剩余的元素
        if (i > iEnd) {
            while (j <= jEnd) {
                array2[k] = array1[j];
                k++;
                j++;
            }
        }
        if (j > jEnd) {
            while (i <= iEnd) {
                array2[k] = array1[i];
                k++;
                i++;
            }
        }
    }
}
