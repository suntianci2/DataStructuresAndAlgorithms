package BasicAlgorithms.InsertionSortByRecursion;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = {1, 4, 7, 2, 3, 9, 8, 5, 0, 13};
        InsertionSort.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
