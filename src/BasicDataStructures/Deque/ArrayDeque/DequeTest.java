package BasicDataStructures.Deque.ArrayDeque;

import org.junit.Test;

public class DequeTest {
    @Test
    public void FirstTest(){
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>(5);
        System.out.println(deque.isEmpty());
        System.out.println(deque.isFull());
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerFirst(4);
        deque.offerFirst(5);
        deque.offerFirst(6);
        for (Integer i : deque) {
            System.out.println(i);
        }
        System.out.println(deque.isEmpty());
        System.out.println(deque.isFull());

        System.out.println("------------------------");
        System.out.println(deque.pollFirst());
        System.out.println();
        for (Integer i : deque) {
            System.out.println(i);
        }
        System.out.println("-----------------------");
        System.out.println(deque.peekFirst());
        System.out.println();
        for (Integer i : deque) {
            System.out.println(i);
        }
        System.out.println(deque.isEmpty());
        System.out.println(deque.isFull());
    }

    @Test
    public void LastTest(){
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>(5);
        System.out.println(deque.isEmpty());
        System.out.println(deque.isFull());
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerLast(4);
        deque.offerLast(5);
        deque.offerLast(6);
        for (Integer i : deque) {
            System.out.println(i);
        }
        System.out.println(deque.isEmpty());
        System.out.println(deque.isFull());

        System.out.println("------------------------");
        System.out.println(deque.pollLast());
        System.out.println();
        for (Integer i : deque) {
            System.out.println(i);
        }
        System.out.println("-----------------------");
        System.out.println(deque.peekLast());
        System.out.println();
        for (Integer i : deque) {
            System.out.println(i);
        }
        System.out.println(deque.isEmpty());
        System.out.println(deque.isFull());
    }
}
