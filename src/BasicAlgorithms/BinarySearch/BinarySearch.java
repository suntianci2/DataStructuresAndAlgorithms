package BasicAlgorithms.BinarySearch;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.builders.JUnit3Builder;

public class BinarySearch {
    @Test
    public static void main(String[] args) {
        int arr[] = {1, 4, 7, 12, 18, 19, 29, 41, 43, 95};
        Assert.assertEquals(0,binarySearch(arr,1));
        Assert.assertEquals(1,binarySearch(arr,4));
        Assert.assertEquals(2,binarySearch(arr,7));
        Assert.assertEquals(3,binarySearch(arr,12));
        Assert.assertEquals(4,binarySearch(arr,18));
        Assert.assertEquals(5,binarySearch(arr,19));
        Assert.assertEquals(6,binarySearch(arr,29));
        Assert.assertEquals(7,binarySearch(arr,41));
        Assert.assertEquals(8,binarySearch(arr,43));
        Assert.assertEquals(9,binarySearch(arr,95));

        Assert.assertEquals(-1,binarySearch(arr,0));
        Assert.assertEquals(-1,binarySearch(arr,25));
        Assert.assertEquals(-1,binarySearch(arr,100));

    }

    // 二分查找
    public static int binarySearch(int arr[], int target) {
        // 指向第一个值（闭）
        int i = 0;

        // 指向最后一个值（闭）
        int j = arr.length - 1;

        // 二分查找
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (target < arr[mid]) {
                j = mid - 1;
            } else if (arr[mid] < target) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        // 如果没有找到
        return -1;
    }
}
