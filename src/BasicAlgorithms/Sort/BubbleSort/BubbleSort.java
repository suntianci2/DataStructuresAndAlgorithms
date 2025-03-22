package BasicAlgorithms.Sort.BubbleSort;

/**
 * @ClassName BubbleSort
 * @Author 孙天赐
 * @Date 2025/3/18 10:34
 * @Description TODO: 冒泡排序
 */
public class BubbleSort {
    public static void bubbleSort(int[] a) {
        int j = a.length - 1;
        do {
            // 未排序与已排序的分割线
            int x = 0;
            for (int i = 0; i < j; i++) {
                // 相邻元素比较
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    x = i;
                }
            }
            // 一轮比较结束，更新分割线
            j = x;
        } while (j != 0);
    }
}
