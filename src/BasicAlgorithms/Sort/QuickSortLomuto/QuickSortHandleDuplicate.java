package BasicAlgorithms.Sort.QuickSortLomuto;

import java.util.Arrays;

/**
 * @ClassName QuickSortHandleDuplicate
 * @Author 孙天赐
 * @Date 2025/3/20 10:29
 * @Description TODO: 快速排序  （双边快排，解决重复元素过多导致的性能下降问题）
 */
public class QuickSortHandleDuplicate {
    public static void main(String[] args) {
        int[] a = {9, 3, 6, 2, 1, 8, 7, 4, 5};
        System.out.println(Arrays.toString(a));
        quickSort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("==================");
        int[] b = {9, 3, 7, 2, 8, 1, 4, 6, 5};
        System.out.println(Arrays.toString(b));
        quickSort(b);
        System.out.println(Arrays.toString(b));
    }

    // 快速排序
    private static void quickSort(int[] a) {
        quick(a, 0, a.length - 1);
    }

    // 递归执行快速排序
    private static void quick(int[] a, int left, int right) {
        if(left >= right) {
            return;
        }
        // 基准点元素的索引
        int p = partition(a, left, right);
        quick(a, left, p - 1);
        quick(a, p + 1, right);
    }

    // 分区操作
    private static int partition(int[] a, int left, int right) {
        int pivot = a[left];
        int i = left + 1; // 注意：i从left+1开始，可以解决重复元素过多导致的性能下降问题
        int j = right;
        while (i <= j) {
            // 1. j从右向左找比基准点小的元素
            while (i <= j && a[j] > pivot) {
                j--;
            }
            // 2. i从左向右找比基准点大的元素
            while (i <= j && a[i] < pivot) {
                i++;
            }
            // 3. 交换i和j元素
            if (i <= j){
                swap(a, i, j);
                i++;
                j--;
            }
        }
        swap(a, j, left);
        return j;
    }

    // 交换元素
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
