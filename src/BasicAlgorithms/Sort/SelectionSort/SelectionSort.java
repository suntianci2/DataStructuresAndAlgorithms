package BasicAlgorithms.Sort.SelectionSort;

/**
 * @ClassName SelectionSort
 * @Author 孙天赐
 * @Date 2025/3/18 10:39
 * @Description TODO: 选择排序
 */
public class SelectionSort {
    public static void selectionSort(int[] a) {
        // 1.选择轮数 a.length - 1
        // 2.交换的索引位置 初始 a.length - 1 每次递减
        for (int right = a.length - 1; right > 0; right--) {
            int maxIndex = right;
            // 找最大值
            for (int i = 0; i < right; i++) {
                if (a[i] > a[maxIndex]) {
                    maxIndex = i;
                }
            }
            // 将最大值与right位置交换
            // 最大值不是right位置的元素，才交换
            if (maxIndex != right) {
                int temp = a[right];
                a[right] = a[maxIndex];
                a[maxIndex] = temp;
            }


        }
    }
}
