package BasicDataStructures.Queue.PriorityQueue1;

import org.junit.Test;

public class PriorityQueue1Test {

    @Test
    public void TestPriorityTest(){
        PriorityQueue1<Entry> priorityQueue1 = new PriorityQueue1<>(5);
        priorityQueue1.offer(new Entry("message10", 10));
        priorityQueue1.offer(new Entry("message6", 6));
        priorityQueue1.offer(new Entry("message12", 12));
        priorityQueue1.offer(new Entry("message1", 1));
        priorityQueue1.offer(new Entry("message8", 8));
        priorityQueue1.offer(new Entry("message9", 9));

        System.out.println(priorityQueue1.isEmpty());
        System.out.println(priorityQueue1.isFull());

        System.out.println(priorityQueue1.peek());
        System.out.println(priorityQueue1.poll());
        System.out.println(priorityQueue1.poll());

        System.out.println(priorityQueue1.isEmpty());
        System.out.println(priorityQueue1.isFull());

        System.out.println("--------------------------------------");
        System.out.println(priorityQueue1.poll());
        System.out.println(priorityQueue1.poll());
        System.out.println(priorityQueue1.poll());
        System.out.println(priorityQueue1.poll());

        System.out.println(priorityQueue1.isEmpty());
        System.out.println(priorityQueue1.isFull());
    }
}
