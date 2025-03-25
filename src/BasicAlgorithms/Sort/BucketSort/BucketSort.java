package BasicAlgorithms.Sort.BucketSort;

import BasicAlgorithms.Sort.InsertionSort.InsertionSort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName BucketSort
 * @Author 孙天赐
 * @Date 2025/3/23 16:55
 * @Description TODO: 桶排序
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] a = {91, 32, 67, 23, 16, 81, 79, 45, 55, 65, 75, 85, 95};
        System.out.println(Arrays.toString(a));
        bucketSort(a, 3);
        System.out.println(Arrays.toString(a));
        System.out.println("==================");
        int[] b = {9, 3, 7, 2, 8, 1, 4, 6, 5};
        System.out.println(Arrays.toString(b));
        bucketSort(b, 3);
        System.out.println(Arrays.toString(b));
    }

    // 桶排序。range表示 预期的每个桶放的元素个数
    private static void bucketSort(int[] arr, int range) {
        // 1.找到最大值和最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // 2.准备桶
        ArrayList<Integer>[] buckets = new ArrayList[(max - min) / range + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        // 3.将元素放入桶中
        for (int num : arr) {
            buckets[(num - min) / range].add(num);
        }

        int k = 0;
        for (ArrayList<Integer> bucket : buckets) {
            int[] temp = new int[bucket.size()];
            for (int i = 0; i < bucket.size(); i++) {
                temp[i] = bucket.get(i);
            }
            // 4.对每个桶进行排序
            InsertionSort.insertionSort(temp);
            // 5.将排序后的元素放入原数组中
            for (int num : temp) {
                arr[k++] = num;
            }
        }
    }
}
