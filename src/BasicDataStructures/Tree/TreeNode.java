package BasicDataStructures.Tree;

// 二叉树节点类
public class TreeNode {
    // 节点值
    public int value;
    // 左孩子
    public TreeNode left;
    // 右孩子
    public TreeNode right;

    public TreeNode(int value){
        this.value = value;
    }

    public TreeNode(TreeNode left, int value, TreeNode right){
        this.left = left;
        this.value = value;
        this.right = right;
    }


    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}
