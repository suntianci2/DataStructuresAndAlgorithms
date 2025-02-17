package BasicDataStructures.Tree.BinarySearchTree;

/**
 * @ClassName BSTree2
 * @Author 孙天赐
 * @Date 2025/1/28 10:32
 * @Description TODO: 二叉搜索树 键为泛型
 */
public class BSTree2<K extends Comparable<K>, V> {

    BSTNode<K, V> root;

    static class BSTNode<K, V> {
        K key;
        V value;
        BSTNode<K, V> left;
        BSTNode<K, V> right;

        public BSTNode(K key) {
            this.key = key;

        }

        public BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(K key, V value,BSTNode<K, V> left, BSTNode<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 根据键找到值
     * @param key
     * @return
     */
    public V get(K key){
        if(key == null){
            return null;
        }
        BSTNode<K, V> thisNode = root;
        while (thisNode != null) {
            // compareTo方法：返回值-1：标识前面的key小于后面的key
            //                      0：标识前面的key等于后面的key
            //                      1：标识前面的key大于后面的key
            int result = key.compareTo(thisNode.key);
            if(result < 0){
                // 下一轮循环向左寻找
                thisNode = thisNode.left;
            }else if (result > 0){
                // 下一轮循环向右寻找
                thisNode = thisNode.right;
            }else{
                // 找到答案
                return thisNode.value;
            }
        }
        // 未找到答案
        return null;
    }
}
