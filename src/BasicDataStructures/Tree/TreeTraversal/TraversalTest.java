package BasicDataStructures.Tree.TreeTraversal;

import BasicDataStructures.Tree.TreeNode;
import org.junit.Test;

public class TraversalTest {

    @Test
    public void testRecursionTraversal() {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );

        RecursionTraversal.preOrder(root);
        System.out.println("\n================================");
        RecursionTraversal.inOrder(root);
        System.out.println("\n================================");
        RecursionTraversal.postOrder(root);
    }

    @Test
    public void testNonRecursionTraversal(){
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );

        NonRecursiveTraversal.TraversalRoad(root);

        System.out.println("\n================================");
        NonRecursiveTraversal.preOrder(root);
        System.out.println("\n================================");
        NonRecursiveTraversal.inOrder(root);
        System.out.println("\n================================");
        NonRecursiveTraversal.postOrder(root);
    }
}
