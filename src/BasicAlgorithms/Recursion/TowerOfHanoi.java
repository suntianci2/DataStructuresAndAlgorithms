package BasicAlgorithms.Recursion;

import org.junit.Test;

import java.util.LinkedList;

public class TowerOfHanoi {

    LinkedList<Integer> a = new LinkedList<>();
    LinkedList<Integer> b = new LinkedList<>();
    LinkedList<Integer> c = new LinkedList<>();



    public void move(int n, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {
        if(n == 0){
            return;
        }
        move(n-1,a,c,b);  // 先把a上面n-1个元素借助c移动到b
        System.out.println("=============================================================");
        System.out.println(a + "--->" + c);
        c.addLast(a.removeLast());  // 然后把a最下面一个元素移动到c
        print();
        move(n-1,b,a,c);  // 最后把b上面的n-1个元素借助a移动到c
    }

    public void print(){
        System.out.println("-----");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    @Test
    public void testMove() {
        final int COUNT = 16;
        for (int i = COUNT; i >= 1; i--) {
            a.addLast(i);
        }
        move(COUNT, a, b, c);
    }
}
