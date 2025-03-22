package BasicAlgorithms.Sort.MergeSort;

import java.util.Arrays;

/**
 * @ClassName MergeSortBottomUp
 * @Author 孙天赐
 * @Date 2025/3/19 13:53
 * @Description TODO: 自底向上归并排序（非递归）
 */
public class MergeSortBottomUp {

    public static void main(String[] args) {
        int[] a = {9, 3, 6, 2, 1, 8, 7, 4, 5};
        System.out.println(Arrays.toString(a));
        mergeSort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("==================");
        int[] b = {9, 3, 7, 2, 8, 1, 4, 6, 5};
        System.out.println(Arrays.toString(b));
        mergeSort(b);
        System.out.println(Arrays.toString(b));
    }

    public static void mergeSort(int[] array) {
        int len = array.length;
        int[] temp = new int[len];
        // 1. width代表有序区间的宽度，从1开始，每次翻倍，直到len
        for (int width = 1; width < len; width = width *= 2) {
            // 2. 每次合并，合并的数组长度为width。[left, right] 分别代表待合并区间的左右边界
            for (int left = 0; left < len; left += width * 2) {
                int right = Math.min(left + width * 2 - 1, len - 1);
                // 3. 根据左右边界计算中间索引值
                int mid = Math.min(left + width - 1, len - 1);
                // 4. 根据中间索引可以划分为两个有序数组[left, mid]和[mid + 1, right]，然后合并两个有序数组
                merge(array, left, mid, mid + 1, right, temp);
            }
            // 5. 拷贝（临时数组拷贝到正常数组中）
            System.arraycopy(temp, 0, array, 0, len);
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
