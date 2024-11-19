package BasicDataStructures.Queue.PriorityQueue2;

import BasicDataStructures.Queue.Entry;
import BasicDataStructures.Queue.PriorityQueue1.PriorityQueue1;
import org.junit.Test;

public class PriorityQueue2Test {

    @Test
    public void TestPriorityTest(){
        PriorityQueue2<Entry> priorityQueue2 = new PriorityQueue2<>(5);
        priorityQueue2.offer(new Entry("message10", 10));
        priorityQueue2.offer(new Entry("message6", 6));
        priorityQueue2.offer(new Entry("message12", 12));
        priorityQueue2.offer(new Entry("message1", 1));
        priorityQueue2.offer(new Entry("message8", 8));
        priorityQueue2.offer(new Entry("message9", 9));

        System.out.println(priorityQueue2.isEmpty());
        System.out.println(priorityQueue2.isFull());

        System.out.println(priorityQueue2.peek());
        System.out.println(priorityQueue2.poll());
        System.out.println(priorityQueue2.poll());

        System.out.println(priorityQueue2.isEmpty());
        System.out.println(priorityQueue2.isFull());

        System.out.println("--------------------------------------");
        System.out.println(priorityQueue2.poll());
        System.out.println(priorityQueue2.poll());
        System.out.println(priorityQueue2.poll());
        System.out.println(priorityQueue2.poll());

        System.out.println(priorityQueue2.isEmpty());
        System.out.println(priorityQueue2.isFull());
    }
}
