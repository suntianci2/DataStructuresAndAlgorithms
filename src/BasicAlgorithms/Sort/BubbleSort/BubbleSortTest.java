package BasicAlgorithms.Sort.BubbleSort;

import org.junit.Test;

import java.util.Arrays;

public class BubbleSortTest {

    @Test
    public void test() {
        int[] a = {1, 4, 2, 7, 3, 4, 5, 7, 8, 9};
        System.out.println(Arrays.toString(a));
        BubbleSortByRecursion.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
