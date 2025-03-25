package BasicAlgorithms.Sort.RadixSort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName RadixSort
 * @Author 孙天赐
 * @Date 2025/3/24 15:45
 * @Description TODO: 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        String[] a = {"19112345678", "12489298372", "17551545341", "13333033303", "14444044404", "23454647485", "21876473659"};
        System.out.println(Arrays.toString(a));
        radixSort(a, 11);
        System.out.println(Arrays.toString(a));
    }

    // 基数排序
    private static void radixSort(String[] arr, int length) {
        // 1.准备桶
        ArrayList<String>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        // 从最后一位开始，每次按照当前位进行排序（桶排序）
        for (int i = length - 1; i >= 0; i--) {
            // 2.从后往前遍历，将元素放入桶中
            for (String s : arr) {
                buckets[s.charAt(i) - '0'].add(s);
            }
            // 3.将桶中的元素依次取出，放入原数组中
            int k = 0;
            for (ArrayList<String> bucket : buckets) {
                for (String s : bucket) {
                    arr[k++] = s;
                }
                bucket.clear();
            }
        }
    }
}
