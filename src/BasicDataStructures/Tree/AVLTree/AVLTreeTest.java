package BasicDataStructures.Tree.AVLTree;

import BasicDataStructures.Tree.BinarySearchTree.BSTree1;
import org.junit.Test;

/**
 * @ClassName AVLTreeTest
 * @Author 孙天赐
 * @Date 2025/2/5 18:07
 * @Description TODO:
 */
public class AVLTreeTest {
    @Test
    public void testAVLTree(){
        AVLTree.AVLNode root = new AVLTree.AVLNode(5, "555");

        AVLTree tree = new AVLTree();
        tree.root = root;

        tree.put(3,"333");
        tree.put(7,"777");
        tree.put(9,"999");
        tree.put(8,"888");
        tree.put(6,"666");
        tree.put(2,"222");
        tree.put(1,"111");
        tree.put(0,"000");
        tree.put(-1,"-1-1-1");
        tree.put(-2,"-2-2-2");

        System.out.println(tree.get(2));
        System.out.println(tree.get(3));
        System.out.println(tree.get(4));
        System.out.println(tree.get(5));
        System.out.println(tree.get(6));
        System.out.println(tree.get(7));
        System.out.println(tree.get(8));
        System.out.println(tree.get(9));
        System.out.println(tree.get(0));
        System.out.println(tree.get(-1));
        System.out.println(tree.get(-2));

        System.out.println("-------------------------------");
        tree.remove(6);

        System.out.println(tree.get(2));
        System.out.println(tree.get(3));
        System.out.println(tree.get(4));
        System.out.println(tree.get(5));
        System.out.println(tree.get(6));
        System.out.println(tree.get(7));
        System.out.println(tree.get(8));
        System.out.println(tree.get(9));
        System.out.println(tree.get(0));
        System.out.println(tree.get(-1));
        System.out.println(tree.get(-2));

        System.out.println("-------------------------------");
        tree.remove(5);

        System.out.println(tree.get(2));
        System.out.println(tree.get(3));
        System.out.println(tree.get(4));
        System.out.println(tree.get(5));
        System.out.println(tree.get(6));
        System.out.println(tree.get(7));
        System.out.println(tree.get(8));
        System.out.println(tree.get(9));
        System.out.println(tree.get(0));
        System.out.println(tree.get(-1));
        System.out.println(tree.get(-2));

        System.out.println("-------------------------------");
        tree.remove(-1);

        System.out.println(tree.get(2));
        System.out.println(tree.get(3));
        System.out.println(tree.get(4));
        System.out.println(tree.get(5));
        System.out.println(tree.get(6));
        System.out.println(tree.get(7));
        System.out.println(tree.get(8));
        System.out.println(tree.get(9));
        System.out.println(tree.get(0));
        System.out.println(tree.get(-1));
        System.out.println(tree.get(-2));
    }
}
