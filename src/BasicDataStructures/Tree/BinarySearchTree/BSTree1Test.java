package BasicDataStructures.Tree.BinarySearchTree;

import org.junit.Test;

/**
 * @ClassName BSTree1Test
 * @Author 孙天赐
 * @Date 2025/1/27 22:18
 * @Description TODO:
 */
public class BSTree1Test {
    @Test
    public void testBSTree_1() {
        BSTree1.BSTNode n1 = new BSTree1.BSTNode(1, "111");
        BSTree1.BSTNode n3 = new BSTree1.BSTNode(3, "333");
        BSTree1.BSTNode n2 = new BSTree1.BSTNode(2, "222", n1, n3);

        BSTree1.BSTNode n5 = new BSTree1.BSTNode(5, "555");
        BSTree1.BSTNode n7 = new BSTree1.BSTNode(7, "777");
        BSTree1.BSTNode n6 = new BSTree1.BSTNode(6, "666", n5, n7);
        BSTree1.BSTNode root = new BSTree1.BSTNode(4, "444", n2, n6);

        BSTree1 tree = new BSTree1();
        tree.root = root;
        System.out.println(tree.get(3));
        System.out.println(tree.get(5));
        System.out.println(tree.get(7));
        System.out.println(tree.get(9));
        System.out.println(tree.get(6));
        System.out.println(tree.get(1));

    }

    @Test
    public void testBSTree_2() {
        BSTree1.BSTNode n1 = new BSTree1.BSTNode(1, "111");
        BSTree1.BSTNode n3 = new BSTree1.BSTNode(3, "333");
        BSTree1.BSTNode n2 = new BSTree1.BSTNode(2, "222", n1, n3);

        BSTree1.BSTNode n5 = new BSTree1.BSTNode(5, "555");
        BSTree1.BSTNode n7 = new BSTree1.BSTNode(7, "777");
        BSTree1.BSTNode n6 = new BSTree1.BSTNode(6, "666", n5, n7);
        BSTree1.BSTNode root = new BSTree1.BSTNode(4, "444", n2, n6);

        BSTree1 tree = new BSTree1();
        tree.root = root;

        System.out.println(tree.min());
        System.out.println(tree.max());
    }

    @Test
    public void testBSTree_3() {
        BSTree1.BSTNode n1 = new BSTree1.BSTNode(1, "111");
        BSTree1.BSTNode n3 = new BSTree1.BSTNode(3, "333");
        BSTree1.BSTNode n2 = new BSTree1.BSTNode(2, "222", n1, n3);

        BSTree1.BSTNode n5 = new BSTree1.BSTNode(5, "555");
        BSTree1.BSTNode n7 = new BSTree1.BSTNode(7, "777");
        BSTree1.BSTNode n6 = new BSTree1.BSTNode(6, "666", n5, n7);
        BSTree1.BSTNode root = new BSTree1.BSTNode(4, "444", n2, n6);

        BSTree1 tree = new BSTree1();
        tree.root = root;

        tree.put(0, "000");
        System.out.println(tree.get(0));

        tree.put(8, "888");
        tree.put(12, "121212");
        tree.put(11, "111111");
        tree.put(16, "161616");
        tree.put(9, "999");
        System.out.println(tree.get(12));
        System.out.println(tree.get(16));
        System.out.println(tree.get(9));
        System.out.println(tree.get(10));
    }

    @Test
    public void testBSTree_4() {
        BSTree1.BSTNode n1 = new BSTree1.BSTNode(1, "111");
        BSTree1.BSTNode n3 = new BSTree1.BSTNode(3, "333");
        BSTree1.BSTNode n2 = new BSTree1.BSTNode(2, "222", n1, n3);

        BSTree1.BSTNode n5 = new BSTree1.BSTNode(5, "555");
        BSTree1.BSTNode n7 = new BSTree1.BSTNode(7, "777");
        BSTree1.BSTNode n6 = new BSTree1.BSTNode(6, "666", n5, n7);
        BSTree1.BSTNode root = new BSTree1.BSTNode(4, "444", n2, n6);

        BSTree1 tree = new BSTree1();
        tree.root = root;

        System.out.println(tree.predecessor(3));
        System.out.println(tree.predecessor(5));
        System.out.println(tree.predecessor(7));
        System.out.println(tree.predecessor(1));
        System.out.println(tree.predecessor(2));

        System.out.println("----------------------");

        System.out.println(tree.successor(1));
        System.out.println(tree.successor(3));
        System.out.println(tree.successor(5));
        System.out.println(tree.successor(7));
    }

    @Test
    public void testBSTree_5() {
        BSTree1.BSTNode n1 = new BSTree1.BSTNode(1, "111");
        BSTree1.BSTNode n3 = new BSTree1.BSTNode(3, "333");
        BSTree1.BSTNode n2 = new BSTree1.BSTNode(2, "222", n1, n3);

        BSTree1.BSTNode n5 = new BSTree1.BSTNode(5, "555");
        BSTree1.BSTNode n7 = new BSTree1.BSTNode(7, "777");
        BSTree1.BSTNode n6 = new BSTree1.BSTNode(6, "666", n5, n7);
        BSTree1.BSTNode root = new BSTree1.BSTNode(4, "444", n2, n6);

        BSTree1 tree = new BSTree1();
        tree.root = root;

        System.out.println(tree.delete(3));

        System.out.println(tree.get(1));
        System.out.println(tree.get(2));
        System.out.println(tree.get(3));
        System.out.println(tree.get(4));
        System.out.println(tree.get(5));
        System.out.println(tree.get(6));
        System.out.println(tree.get(7));

        System.out.println("-------------------------");

        System.out.println(tree.delete(4));
        System.out.println(tree.get(1));
        System.out.println(tree.get(2));
        System.out.println(tree.get(3));
        System.out.println(tree.get(4));
        System.out.println(tree.get(5));
        System.out.println(tree.get(6));
        System.out.println(tree.get(7));

        System.out.println("-------------------------");

        System.out.println(tree.delete(1));
        System.out.println(tree.get(1));
        System.out.println(tree.get(2));
        System.out.println(tree.get(3));
        System.out.println(tree.get(4));
        System.out.println(tree.get(5));
        System.out.println(tree.get(6));
        System.out.println(tree.get(7));
    }


    @Test
    public void testBSTree_6() {
        BSTree1.BSTNode n1 = new BSTree1.BSTNode(1, "111");
        BSTree1.BSTNode n3 = new BSTree1.BSTNode(3, "333");
        BSTree1.BSTNode n2 = new BSTree1.BSTNode(2, "222", n1, n3);

        BSTree1.BSTNode n5 = new BSTree1.BSTNode(5, "555");
        BSTree1.BSTNode n7 = new BSTree1.BSTNode(7, "777");
        BSTree1.BSTNode n6 = new BSTree1.BSTNode(6, "666", n5, n7);
        BSTree1.BSTNode root = new BSTree1.BSTNode(4, "444", n2, n6);

        BSTree1 tree = new BSTree1();
        tree.root = root;

        System.out.println(tree.less(5));
        System.out.println(tree.less(6));

        System.out.println("---------------------------");

        System.out.println(tree.greater(5));
        System.out.println(tree.greater(3));

        System.out.println("----------------------------");

        System.out.println(tree.between(1, 6));
        System.out.println(tree.between(2, 7));
    }
}
