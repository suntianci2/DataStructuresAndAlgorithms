package BasicDataStructures.Tree.AVLTree;

import BasicDataStructures.Tree.BinarySearchTree.BSTree1;

import java.util.LinkedList;

/**
 * @ClassName AVLTree
 * @Author 孙天赐
 * @Date 2025/2/3 17:15
 * @Description TODO: AVL树
 * 二叉搜索树在插入和删除时，节点可能失衡
 * 如果在插入和删除时通过旋转，始终让二叉搜索树保持平衡，称为自平衡的二叉搜索树
 * AVL是自平衡二叉搜索树的实现之一
 */
public class AVLTree {

    AVLNode root;

    /**
     * 节点类
     */
    static class AVLNode {
        int key;
        Object value;
        AVLNode left;
        AVLNode right;
        int height = 1;  // 高度

        public AVLNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public AVLNode(int key) {
            this.key = key;
        }

        public AVLNode(int key, Object value, AVLNode left, AVLNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 获取指定键的值
     * @param key
     * @return
     */
    public Object get(int key){
        AVLNode thisNode = root;
        while (thisNode != null) {
            if (key < thisNode.key) {
                // 下一轮循环向左寻找
                thisNode = thisNode.left;
            } else if (key > thisNode.key) {
                // 下一轮循环向右寻找
                thisNode = thisNode.right;
            } else {
                // 找到答案
                return thisNode.value;
            }
        }
        // 未找到答案
        return null;
    }

    /**
     * 新增节点
     * @param key
     * @param value
     */
    public void put(int key, Object value) {
        AVLNode thisNode = root;
        AVLNode preNode = null;
        LinkedList<AVLNode> stack = new LinkedList<>(); // 使用栈记录走过的节点，反向调整节点高度和平衡节点
        while (thisNode != null) {
            preNode = thisNode;
            stack.push(thisNode); // 记录走过的路
            if (key < thisNode.key) {
                // 下一轮循环向左寻找
                thisNode = thisNode.left;
            } else if (key > thisNode.key) {
                // 下一轮循环向右寻找
                thisNode = thisNode.right;
            } else {
                // 找到目标键，更新节点。这时候不需要更新节点高度，也不需要平衡
                thisNode.value = value;
                return;
            }
        }
        // 树中无元素
        if (preNode == null) {
            root = new AVLNode(key, value);
            return;
        }
        // 树中没有对应键，创建新节点
        if (key < preNode.key) {
            preNode.left = new AVLNode(key, value);
        } else {
            preNode.right = new AVLNode(key, value);
        }

        // 更新高度和进行平衡
        while (!stack.isEmpty()) {
            AVLNode node = stack.pop();
            // 更新高度
            updateHeight(node);
            // 判断是否失衡，并进行平衡处理
            AVLNode newNode = balance(node);
            // 平衡处理后可能导致当前局部子树根节点发生变化，所以需要更新父亲的孩子节点
            AVLNode tempNode = stack.poll();
            if (tempNode == null) {
                root = newNode;
            } else {
                if (tempNode.left == node) {
                    tempNode.left = newNode;
                }else{
                    tempNode.right = newNode;
                }
            }
        }
    }

    /**
     * 使用递归删除指定key的节点
     * @param key
     * @return
     */
    public void remove(int key){
        root = doRemove(root, key);
    }

    /**
     * 获取节点的高度
     *
     * @param node
     * @return
     */
    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    /**
     * 更新节点高度
     *
     * @param node
     */
    private void updateHeight(AVLNode node) {
        node.height = Integer.max(height(node.left), height(node.right)) + 1;
    }

    /**
     * 获取某个节点的平衡因子，用于判断某个节点是否失衡(左子树高度-右子树高度)。
     * 返回值：0、1、-1，则说明节点平衡
     * 其他值：说明节点失衡，需要旋转
     * 小于-1：说明右边太高
     * 大于1：说明左边太高
     *
     * @param node
     * @return
     */
    private int balanceFactor(AVLNode node) {
        return height(node.left) - height(node.right);
    }

    /**
     * 以指定节点为根节点，对树左旋
     *
     * @param node
     * @return
     */
    private AVLNode leftRotate(AVLNode node) {
        // 获取根节点的右孩子
        AVLNode rightNode = node.right;
        // 将右孩子的左孩子赋值给根节点的右孩子（旋转的时候，部分节点需要换爹）
        node.right = rightNode.left;
        // 右孩子变为新的根节点，其左孩子为原根节点
        rightNode.left = node;
        // 更新原根节点和新根节点的高度（其他节点的高度不会改变），必须先更新原根节点，再更新新根节点
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    /**
     * 以指定节点为根节点，对树右旋
     *
     * @param node
     * @return
     */
    private AVLNode rightRotate(AVLNode node) {
        // 获取根节点的左孩子
        AVLNode leftNode = node.left;
        // 将左孩子的右孩子赋值给根节点的左孩子（旋转的时候，部分节点需要换爹）
        node.left = leftNode.right;
        // 左孩子变为新的根节点，其右孩子为原根节点
        leftNode.right = node;
        // 更新原根节点和新根节点的高度（其他节点的高度不会改变），必须先更新原根节点，再更新新根节点
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    /**
     * 先左旋左子树，再右旋根节点
     *
     * @param node
     * @return
     */
    private AVLNode leftRightRotate(AVLNode node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    /**
     * 先右旋右子树，再左旋根节点
     *
     * @param node
     * @return
     */
    private AVLNode rightLeftRotate(AVLNode node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    /**
     * 判断节点是否失衡，并进行平衡处理
     * 节点失衡的四种情况：
     * 1. LL
     * 失衡节点的balanceFactor > 1  即左边更高
     * 失衡节点的左孩子的balanceFactor >= 0  即左孩子这边是左边更高或等高
     * 仅需一次右旋即可恢复平衡
     * <p>
     * 2. LR
     * 失衡节点的balanceFactor >1  即左边更高
     * 失衡节点的左孩子的balanceFactor < 0  即左孩子这边是右边更高
     * 先让左子树左旋，然后整体右旋，即可恢复平衡
     * <p>
     * 3. RL
     * 失衡节点的balanceFactor < -1  即右边更高
     * 失衡节点的右孩子的balanceFactor > 0  即右孩子这边是左边更高
     * 先让右子树右旋，然后整体左旋， 即可恢复平衡
     * <p>
     * 4. RR
     * 失衡节点的balanceFactor < -1  即右边更高
     * 失衡节点的右孩子的balanceFactor <= 0  即右孩子这边是右边更高或等高
     * 仅需一次左旋即可恢复平衡
     *
     * @param node
     * @return
     */
    private AVLNode balance(AVLNode node) {
        if (node == null) {
            return null;
        }
        // 获取节点的平衡因子balanceFactor
        int bf = balanceFactor(node);
        // 根据平衡因子分情况判断是否失衡，并处理
        if (bf > 1) {
            int leftBF = balanceFactor(node.left);
            if (leftBF >= 0) {
                // LL，仅需一次右旋
                return rightRotate(node);
            } else {
                // LR，左子树左旋，整体右旋
                return leftRightRotate(node);
            }
        } else if (bf < -1) {
            int rightBF = balanceFactor(node.right);
            if (rightBF <= 0) {
                // RR，仅需一次左旋
                return leftRotate(node);
            } else {
                // RL，右子树右旋，整体左旋
                return rightLeftRotate(node);
            }
        }
        return node;
    }

    /**
     * 删除方法的递归方法
     * @param node
     * @param key
     * @return 删除后剩下的树的根节点
     */
    private AVLNode doRemove(AVLNode node, int key){
        if(node == null){
            return null;
        }
        if(key < node.key){
            // 在左子树
            node.left = doRemove(node.left, key);
        }else if (key > node.key){
            // 在右子树
            node.right = doRemove(node.right, key);
        }else{
            // 找到了
            if(node.left == null && node.right == null){
                // 待删除节点没有孩子
                return null;  // 表示删除后树的根节点为null
            }else if (node.left == null){
                // 只有右孩子
                node = node.right;
            }else if (node.right == null){
                // 只有左孩子
                node = node.left;
            }else{
                // 两个孩子都有
                // 找到待删除节点的后继节点
                AVLNode temp = node.right;
                while(temp.left != null){
                    temp = temp.left;
                }

                // 处理后继节点的后事（后继节点可能会有孩子，所以对于后继节点，其操作也相当于一个删除）
                // 也就是，在待删除节点的右子树中，删除其后继节点
                // 删除剩下的内容作为后继节点的右子树，因为后继节点要代替待删除节点
                temp.right = doRemove(node.right, temp.key);
                // 被删除节点的左子树作为其后继节点的左子树
                temp.left = node.left;
                node = temp;
            }
        }

        // 高度更新
        updateHeight(node);
        // 失衡检查并平衡
        return balance(node);
    }
}
