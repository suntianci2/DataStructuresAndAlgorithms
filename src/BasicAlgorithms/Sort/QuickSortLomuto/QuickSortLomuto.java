package BasicAlgorithms.Sort.QuickSortLomuto;

import java.util.Arrays;

/**
 * @ClassName QuickSortLomuto
 * @Author 孙天赐
 * @Date 2025/3/20 9:51
 * @Description TODO: 快速排序  （Lomuto 版本，单边循环）
 *                  核心思想：
 *                      1. 选择最右元素作为基准点元素
 *                      2. j指针负责找到比基准点小的元素，一旦找到则与i进行交换
 *                      3. i指针指向大于基准点元素的左边界，也是每次交换的目标索引
 *                      4. 最后基准点与i交换，i即为分区位置
 *
 */
public class QuickSortLomuto {
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
        int pivot = a[right];
        int i = left;
        int j = left;
        while (j < right) {
            if (a[j] <= pivot) {
                if(i != j){
                    swap(a, i, j);
                }
                i++;
            }
            j++;
        }
        swap(a, i, right);
        return i;
    }

    // 交换元素
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
