package BasicAlgorithms.Sort.BubbleSort;

/**
 * 递归实现冒泡排序
 */
public class BubbleSortByRecursion {
    public static void sort(int[] a) {
        bubbleSort(a,a.length-1);
    }

    public static void bubbleSort(int[] a, int end) {
        if (end == 0) {
            return;
        }
        int x = 0;     // 未排序与已排序的分割线
        for (int i = 0; i < end; i++) {
            if (a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                x = i;
            }
        }
        bubbleSort(a, x);

    }
}
