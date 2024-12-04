package BasicDataStructures.Heap.MaxHeap;

import org.junit.Test;

import java.util.Arrays;

public class MaxHeapTest {
    @Test
    public void testMaxHeap() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        MaxHeap maxHeap = new MaxHeap(array,20);
        System.out.println(maxHeap);

        System.out.println("peek=====================");
        System.out.println(maxHeap.peek());
        System.out.println(maxHeap.peek());
        System.out.println(maxHeap);
        System.out.println("poll=====================");
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap);
        System.out.println("poll(value)=====================");
        System.out.println(maxHeap.poll(4));
        System.out.println(maxHeap);
        System.out.println("replace=====================");
        System.out.println(maxHeap.replace(10));
        System.out.println(maxHeap);
        System.out.println("offer=====================");
        maxHeap.offer(16);
        maxHeap.offer(0);
        System.out.println(maxHeap);

    }
}
