package BasicDataStructures.Queue.PriorityQueue3;

import BasicDataStructures.Queue.Entry;
import BasicDataStructures.Queue.PriorityQueue2.PriorityQueue2;
import org.junit.Test;

public class PriorityQueue3Test {

    @Test
    public void TestPriorityTest(){
        PriorityQueue3<Entry> priorityQueue3 = new PriorityQueue3<>(5);
        priorityQueue3.offer(new Entry("message10", 10));
        priorityQueue3.offer(new Entry("message6", 6));
        priorityQueue3.offer(new Entry("message12", 12));
        priorityQueue3.offer(new Entry("message1", 1));
        priorityQueue3.offer(new Entry("message8", 8));
        priorityQueue3.offer(new Entry("message9", 9));

        System.out.println(priorityQueue3.isEmpty());
        System.out.println(priorityQueue3.isFull());

        System.out.println(priorityQueue3.peek());
        System.out.println(priorityQueue3.poll());
        System.out.println(priorityQueue3.poll());

        System.out.println(priorityQueue3.isEmpty());
        System.out.println(priorityQueue3.isFull());

        System.out.println("--------------------------------------");
        System.out.println(priorityQueue3.poll());
        System.out.println(priorityQueue3.poll());
        System.out.println(priorityQueue3.poll());
        System.out.println(priorityQueue3.poll());

        System.out.println(priorityQueue3.isEmpty());
        System.out.println(priorityQueue3.isFull());
    }
}
