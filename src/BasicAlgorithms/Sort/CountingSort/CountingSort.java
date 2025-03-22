package BasicAlgorithms.Sort.CountingSort;

import java.util.Arrays;

/**
 * @ClassName CountingSort
 * @Author 孙天赐
 * @Date 2025/3/21 15:03
 * @Description TODO: 计数排序 条件：
 *                      1. 待排序的序列中的元素必须是整数
 *                      2. 序列中的元素必须是有确定范围的整数
 *                      3. 计数排序需要开辟一个长度为max - min + 1的数组，所以当max很大或min很小时，会浪费很多空间
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] a = {9, 3, 6, 2, 1, 8, 7, 4, 5};
        System.out.println(Arrays.toString(a));
        countingSort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("==================");
        int[] b = {9, 3, 7, 2, 8, 1, 4, 6, 5};
        System.out.println(Arrays.toString(b));
        countingSort(b);
        System.out.println(Arrays.toString(b));
    }

    public static void countingSort(int[] a) {
        int max = a[0];
        int min = a[0];
        // 找到最大值和最小值
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }

        // 开辟一个新的数组，长度为max - min + 1，用于存储每个元素出现的次数
        int[] count = new int[max - min + 1];
        // 统计每个元素出现的次数
        for (int i = 0; i < a.length; i++) {
            count[a[i] - min]++;
        }

        int index = 0;
        // 遍历count数组，将每个元素出现的次数，依次放入原数组中
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                a[index++] = i + min;
                count[i]--;
            }
        }
    }
}
