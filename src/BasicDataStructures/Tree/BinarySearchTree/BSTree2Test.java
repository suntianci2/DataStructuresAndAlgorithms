package BasicDataStructures.Tree.BinarySearchTree;

import org.junit.Test;

/**
 * @ClassName BSTree2Test
 * @Author 孙天赐
 * @Date 2025/1/28 10:54
 * @Description TODO:
 */
public class BSTree2Test {
    @Test
    public void testBSTree_1(){
        BSTree2.BSTNode<String, String> n1 = new BSTree2.BSTNode<>("a", "aaa");
        BSTree2.BSTNode<String, String> n3 = new BSTree2.BSTNode<>("c", "ccc");
        BSTree2.BSTNode<String, String> n2 = new BSTree2.BSTNode<>("b", "bbb", n1, n3);

        BSTree2.BSTNode<String, String> n5 = new BSTree2.BSTNode<>("e", "eee");
        BSTree2.BSTNode<String, String> n7 = new BSTree2.BSTNode<>("g", "ggg");
        BSTree2.BSTNode<String, String> n6 = new BSTree2.BSTNode<>("f", "fff", n5, n7);
        BSTree2.BSTNode<String, String> root = new BSTree2.BSTNode<>("d", "ddd", n2, n6);

        BSTree2<String, String> tree = new BSTree2<>();
        tree.root = root;
        System.out.println(tree.get("c"));
        System.out.println(tree.get("e"));
        System.out.println(tree.get("g"));
        System.out.println(tree.get("i"));
        System.out.println(tree.get("f"));
        System.out.println(tree.get("a"));
    }
}
