package BasicDataStructures.Heap.MinHeap;

import BasicDataStructures.Heap.MaxHeap.MaxHeap;
import org.junit.Test;

public class MinHeapTest {
    @Test
    public void testMaxHeap() {
        int[] array = {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        MinHeap minHeap = new MinHeap(array, 20);
        System.out.println(minHeap);

        System.out.println("peek=====================");
        System.out.println(minHeap.peek());
        System.out.println(minHeap.peek());
        System.out.println(minHeap);
        System.out.println("poll=====================");
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap);
        System.out.println("poll(value)=====================");
        System.out.println(minHeap.poll(4));
        System.out.println(minHeap);
        System.out.println("replace=====================");
        System.out.println(minHeap.replace(10));
        System.out.println(minHeap);
        System.out.println("offer=====================");
        minHeap.offer(16);
        minHeap.offer(0);
        System.out.println(minHeap);

    }
}
