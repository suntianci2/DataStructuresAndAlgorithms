package BasicDataStructures.LinkedList.SinglyLinkedListSentinel;

import org.junit.Test;

public class Main {

    // 头插+遍历
    @Test
    public void Test1() {
        SinglyLinkedListSentinel sll = new SinglyLinkedListSentinel();
        sll.addFirst(1);
        sll.addFirst(2);
        sll.addFirst(3);
        sll.addFirst(4);
        sll.addFirst(5);

        sll.foreach(value -> System.out.print(value + " "));

        System.out.println();

        for (Integer value : sll) {
            System.out.print(value + " ");
        }
    }

    // 尾插+遍历
    @Test
    public void Test2(){
        SinglyLinkedListSentinel sll = new SinglyLinkedListSentinel();
        sll.addLast(1);
        sll.addLast(2);
        sll.addLast(3);
        sll.addLast(4);
        sll.addLast(5);

        sll.foreach(value -> System.out.print(value + " "));

        System.out.println();

        for (Integer value : sll) {
            System.out.print(value + " ");
        }
    }

    // 头插+遍历+获取值
    @Test
    public void Test3() {
        SinglyLinkedListSentinel sll = new SinglyLinkedListSentinel();

        sll.addFirst(1);
        sll.addFirst(2);
        sll.addFirst(3);
        sll.addFirst(4);
        sll.addFirst(5);

        sll.foreach(value -> System.out.print(value + " "));

        System.out.println();

        System.out.println(sll.get(2));
        System.out.println(sll.get(4));
        System.out.println(sll.get(1));  // 越界的情况

    }

    // 指定位置插入元素
    @Test
    public void insertTest(){
        SinglyLinkedListSentinel sll = new SinglyLinkedListSentinel();
        sll.addLast(1);
        sll.addLast(2);
        sll.addLast(3);
        sll.addLast(4);
        sll.addLast(5);

        sll.insert(0,8);
        sll.insert(3,9);
        sll.insert(6,10);
        sll.insert(8,23);

        sll.foreach(value -> System.out.print(value + " "));
    }

    // 删除第一个元素
    @Test
    public void removeFirstTest(){
        SinglyLinkedListSentinel sll = new SinglyLinkedListSentinel();
        sll.addLast(1);
        sll.addLast(2);
        sll.addLast(3);
        sll.addLast(4);
        sll.addLast(5);

        sll.removeFirst();
        sll.foreach(value -> System.out.print(value + " "));

        System.out.println();

        sll.removeFirst();
        sll.foreach(value -> System.out.print(value + " "));

        System.out.println();

        sll.removeFirst();
        sll.foreach(value -> System.out.print(value + " "));
    }

    // 删除第指定元素
    @Test
    public void removeTest(){
        SinglyLinkedListSentinel sll = new SinglyLinkedListSentinel();
        sll.addLast(1);
        sll.addLast(2);
        sll.addLast(3);
        sll.addLast(4);
        sll.addLast(5);

        sll.remove(0);
        sll.foreach(value -> System.out.print(value + " "));

        System.out.println();

        sll.remove(3);
        sll.foreach(value -> System.out.print(value + " "));

        System.out.println();

        sll.remove(1);
        sll.foreach(value -> System.out.print(value + " "));
    }
}
