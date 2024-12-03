package BasicDataStructures.Heap.MaxHeap;

import org.junit.Test;

import java.util.Arrays;

public class MaxHeapTest {
    @Test
    public void testMaxHeap() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        MaxHeap maxHeap = new MaxHeap(array);
        System.out.println(Arrays.toString(maxHeap.array));
    }
}
