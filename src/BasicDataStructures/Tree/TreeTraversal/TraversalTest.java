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
        System.out.println("\n=================前序===============");
        RecursionTraversal.preOrder(root);
        System.out.println("\n=================中序===============");
        RecursionTraversal.inOrder(root);
        System.out.println("\n=================后序===============");
        RecursionTraversal.postOrder(root);
    }

    @Test
    public void testNonRecursionTraversal(){
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, new TreeNode(7)),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );

        NonRecursiveTraversal.TraversalRoad(root);

        System.out.println("\n==================前序==============");
        NonRecursiveTraversal.preOrder(root);
        System.out.println("\n==================中序==============");
        NonRecursiveTraversal.inOrder(root);
        System.out.println("\n==================后序==============");
        NonRecursiveTraversal.postOrder(root);
    }

    @Test
    public void testNonRecursionTraversal02(){
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, new TreeNode(7)),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );

        NonRecursiveTraversal.TraversalRoad(root);

        System.out.println("\n=================前序===============");
        NonRecursiveTraversal.order(0, root);
        System.out.println("\n=================中序===============");
        NonRecursiveTraversal.order(1, root);
        System.out.println("\n=================后序===============");
        NonRecursiveTraversal.order(2, root);
    }
}
