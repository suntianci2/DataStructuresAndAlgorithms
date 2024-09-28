package BasicDataStructures.Queue.ArrayQueue;

import org.junit.Test;

import java.util.Iterator;

public class Test1 {

    @Test
    public void ArrayQueue1Test(){
        ArrayQueue1<Integer> queue = new ArrayQueue1<>();
        for (Integer i : queue) {
            System.out.print(i + " ");
        }
        System.out.print("isEmpty：");
        System.out.println(queue.isEmpty());
        queue.offer(3);
        queue.offer(2);
        queue.offer(5);

        System.out.println("\n==================================");

        Iterator<Integer> iter = queue.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next() + " ");
        }

        System.out.println("\n==================================");

        queue.offer(6);
        queue.offer(9);
        queue.offer(2);
        for (Integer i : queue) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("isFull：");
        System.out.println(queue.isFull());

        System.out.println("\n==================================");

        System.out.println(queue.poll());
        for (Integer i : queue) {
            System.out.print(i + " ");
        }

        System.out.println("\n==================================");

        System.out.println(queue.poll());
        for (Integer i : queue) {
            System.out.print(i + " ");
        }

        System.out.println("\n==================================");

        System.out.println(queue.peek());
        for (Integer i : queue) {
            System.out.print(i + " ");
        }

        System.out.println("\n==================================");

        System.out.println(queue.poll());
        for (Integer i : queue) {
            System.out.print(i + " ");
        }

        System.out.println("\n==================================");

        System.out.println(queue.poll());
        for (Integer i : queue) {
            System.out.print(i + " ");
        }

        System.out.println("\n==================================");

        System.out.println(queue.poll());
        for (Integer i : queue) {
            System.out.print(i + " ");
        }
        System.out.print("isEmpty：");
        System.out.println(queue.isEmpty());

        System.out.println("\n==================================");

        queue.offer(51);
        queue.offer(4);
        queue.offer(88);
        for (Integer i : queue) {
            System.out.print(i + " ");
        }
    }


}
