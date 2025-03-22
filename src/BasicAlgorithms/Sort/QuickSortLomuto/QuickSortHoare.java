package BasicAlgorithms.Sort.QuickSortLomuto;

import java.util.Arrays;

/**
 * @ClassName QuickSortHoare
 * @Author 孙天赐
 * @Date 2025/3/20 10:09
 * @Description TODO: 快速排序  （Hoare 版本，双边循环）
 *                  核心思想：
 *                      1. 选择最左元素作为基准点
 *                      2. j指针负责找到比基准点小的元素，i找比基准点大的，一旦找到，两者交换
 *                          i从左向右找
 *                          j从右向左找
 *                      3. 最后基准点与i交换，i即为基准点最终索引
 *
 */
public class QuickSortHoare {
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
        int i = left;
        int j = right;
        while (i < j) {
            // 注意：先从右向左找，再从左向右找，不然会出问题
            // 因为i和j相遇时，会将基准点与i交换，而i指向的元素是大于基准点的，会导致基准点右边的元素都大于基准点，从而导致排序错误
            // 1. j从右向左找比基准点小的元素
            while (i < j && a[j] >= pivot) {
                j--;
            }
            // 2. i从左向右找比基准点大的元素
            while (i < j && a[i] <= pivot) {
                i++;
            }
            // 3. 交换i和j元素
            swap(a, i, j);
        }
        swap(a, i, left);
        return i;
    }

    // 交换元素
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
