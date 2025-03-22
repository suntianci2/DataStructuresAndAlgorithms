package BasicAlgorithms.Sort.ShellSort;

import java.util.Arrays;

/**
 * @ClassName ShellSort
 * @Author 孙天赐
 * @Date 2025/3/19 11:19
 * @Description TODO: 希尔排序
 */
public class ShellSort {
    public static void shellSort(int[] array) {
        // 间隙初始值为数组长度的一半，每次循环将间隙缩小一半
        for(int gap = array.length >> 1; gap > 0; gap = gap >> 2) {
            // 根据间隙分组，组内进行插入排序
            // 从第一个元素开始，对每个元素进行插入排序
            for (int low = gap; low < array.length; low++) {
                int temp = array[low];  // 待插入的值
                int i = low - gap;
                // 自右向左寻找插入位置，同时将大于temp的元素后移，为temp腾出插入位置
                while (i >= 0 && array[i] > temp) {
                    array[i + gap] = array[i];
                    i -= gap;
                }
                // 找到插入位置
                if (i != low - gap) {
                    array[i + gap] = temp;
                }

            }
        }
    }

    public static void main(String[] args) {
        int[] a = {9, 3, 6, 2, 1, 8, 7, 4, 5};
        System.out.println(Arrays.toString(a));
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }
}
