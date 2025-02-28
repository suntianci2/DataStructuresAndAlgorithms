package BasicDataStructures.Tree.RedBlackTree;

import static BasicDataStructures.Tree.RedBlackTree.RedBlackTree.Color.BLACK;
import static BasicDataStructures.Tree.RedBlackTree.RedBlackTree.Color.RED;

/**
 * @ClassName RedBlackTree
 * @Author 孙天赐
 * @Date 2025/2/22 15:39
 * @Description TODO: 红黑树实现代码
 *                  红黑树特性：
 *                  1. 所有节点都有两种颜色：红与黑
 *                  2. 所有null视为黑色
 *                  3. 红色节点不能相邻
 *                  4. 根节点是黑色
 *                  5. 从根到任意一个叶子节点，路径中的黑色节点数一样（黑色完美平衡）
 */
public class RedBlackTree {
    enum Color {
        RED, BLACK;
    }

    private Node root;

    private static class Node {
        int key;
        Object value;
        Node left;
        Node right;
        Node parent;  // 父节点
        Color color = RED; // 颜色

        public Node() {

        }

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        // 是否是左孩子
        boolean isLeftChild() {
            return parent != null && parent.left == this;
        }

        // 叔叔
        Node uncle() {
            if (parent == null || parent.parent == null) {
                return null;
            }
            if (parent.isLeftChild()) {
                return parent.parent.right;
            } else {
                return parent.parent.left;
            }
        }

        // 兄弟
        Node brother() {
            if (parent == null) {
                return null;
            }
            if (this.isLeftChild()) {
                return parent.right;
            } else {
                return parent.left;
            }
        }

    }

    // 新增或更新
    // 正常新增或更新，遇到红红不平衡进行调整
    public void put(int key, Object value) {
        // 1. 正常新增
        Node thisNode = root;
        Node parent = null;
        while (thisNode != null) {
            // 记录父节点
            parent = thisNode;
            if (thisNode.key < key) {
                thisNode = thisNode.left;
            } else if (thisNode.key > key) {
                thisNode = thisNode.right;
            } else {
                // 存在指定key，则进行更新
                thisNode.value = value;
                return;
            }
        }
        // 新增
        Node newNode = new Node(key, value);
        if (parent == null) {
            root = newNode;
        } else if (key < parent.key) {
            parent.left = newNode;
            // 完善新节点的属性
            newNode.parent = parent;  // 父节点
        } else {
            parent.right = newNode;
            // 完善新节点的属性
            newNode.parent = parent;  // 父节点
        }
        fixRedRed(newNode);

    }

    // 节点的颜色判定，判定当前节点与父节点是否红红相邻，并根据情况进行调整
    // TODO: 情况1：插入节点为根节点
    // TODO: 情况2：插入节点的父亲若为黑色
    // TODO: 情况3：插入节点的父亲为红色，且叔叔为红色
    // TODO: 情况4：插入节点的父亲为红色，且叔叔为黑色
    private void fixRedRed(Node node) {
        // TODO: 情况1：插入节点为根节点，直接变黑即可
        if (root == node) {
            node.color = BLACK;
            return;
        }

        // TODO: 情况2：插入节点的父亲若为黑色，无需调整
        if (isBlack(node.parent)) {
            return;
        }

        // 插入节点的父亲为红色，触发红红相邻
        Node parent = node.parent;  // 父亲
        Node uncle = node.uncle();  // 叔叔
        Node grandParent = parent.parent;  // 祖父

        // TODO: 情况3：插入节点的父亲为红色，且叔叔为红色
        if (isRed(uncle)) {
            // 3.1.1 父亲变为黑色，为了保证黑色平衡，连带的叔叔也变为黑色
            parent.color = BLACK;
            uncle.color = BLACK;
            // 3.1.2 祖父如果是黑色不变，会造成这颗子树黑色过多，因此祖父节点变为红色
            grandParent.color = RED;
            // 3.1.3 祖父如果变为红色，可能会接着触发红红相邻，因此对祖父进行递归调整
            fixRedRed(grandParent);
        }

        // TODO: 情况4：插入节点的父亲为红色，且叔叔为黑色
        if (parent.isLeftChild() && node.isLeftChild()) {
            // 4.1 父亲为左孩子，插入节点也是左孩子，此时即LL不平衡
            parent.color = BLACK;  // 父亲变为黑色
            grandParent.color = RED;  // 祖父变为红色
            rightRotate(grandParent);  // 祖父右旋
        } else if (parent.isLeftChild()) {
            // 4.2 父亲为左孩子，插入节点是右孩子。此时即LR不平衡
            leftRotate(parent);  // 父亲左旋
            // 下面的操作与4.1一致，即父亲左旋后就变成了和4.1一致的情况
            node.color = BLACK;  // 新的父亲变为黑色。因为上面的左旋操作，原来的孩子变成了新的父亲
            grandParent.color = RED;  // 祖父变为红色
            rightRotate(grandParent);  // 祖父右旋
        } else if (!node.isLeftChild()) {
            // 4.3 父亲为右孩子，插入节点也是右孩子，此时即RR不平衡
            parent.color = BLACK;  // 父亲变为黑色
            grandParent.color = RED;  // 祖父变为红色
            leftRotate(grandParent);  // 祖父左旋
        } else {
            // 4.4 父亲为右孩子，插入节点是左孩子，此时即RL不平衡
            rightRotate(parent);  // 父亲右选
            // 下面的操作与4.3一致，即父亲右旋后就变成了和4.3一致的情况
            node.color = BLACK;  // 新的父亲变为黑色。因为上面的右旋操作，原来的孩子变成了新的父亲
            grandParent.color = RED;  // 祖父变为红色
            leftRotate(grandParent);  // 祖父左旋
        }


    }

    // 节点的颜色判定，判定删除节点和剩余节点是否都为黑色
    // TODO: 情况3：删除节点或剩余节点的兄弟为红，此时两个侄子定为黑
    // TODO: 情况4：删除节点或剩余节点的兄弟、和兄弟的孩子都为黑
    // TODO: 情况5：删除节点的兄弟为黑，至少一个侄子为红
    private void fixDoubleBlack(Node node) {
        if (node == root) {
            return;
        }
        Node parent = node.parent;
        Node brother = node.brother();
        // TODO: 情况3：删除节点或剩余节点的兄弟为红，此时两个侄子定为黑
        // 情况3可以通过旋转转化为情况4或5
        if (isRed(brother)) {
            if (node.isLeftChild()) {
                // 删除节点为左孩子，则对父亲作一次左旋
                leftRotate(parent);
            } else {
                // 删除节点为右孩子，则对父亲作一次右旋
                rightRotate(parent);
            }
            parent.color = RED;
            brother.color = BLACK;
            fixDoubleBlack(node);
            return;
        }


        if (brother != null) {

            if (isBlack(brother.left) && isBlack(brother.right)) {
                // TODO: 情况4：删除节点或剩余节点的兄弟、和兄弟的孩子都为黑
                // 4.1 将兄弟变红，目的是将删除节点和兄弟那边的黑色高度同时减少1
                brother.color = RED;
                // 4.2 如果父亲是红，则需要将父亲变为黑色，避免红红，此时路径黑色节点数目不变
                if (isRed(parent)) {
                    parent.color = BLACK;
                } else {
                    // 4.3 如果父亲是黑色，说明这条路径少了一个黑色，再次让父节点触发双黑
                    fixDoubleBlack(parent);
                }
            } else {
                // TODO: 情况5：删除节点的兄弟为黑，至少一个侄子为红
                // 5.1 如果兄弟是左孩子，左侄子是红，则LL不平衡
                if (brother.isLeftChild() && isRed(brother.left)) {
                    rightRotate(parent);
                    brother.left.color = BLACK;
                    brother.color = parent.color;

                }
                // 5.2 如果兄弟是左孩子，右侄子是红，则LR不平衡
                else if (brother.isLeftChild() && isRed(brother.right)) {
                    brother.right.color = parent.color;
                    leftRotate(brother);
                    rightRotate(parent);
                }
                // 5.3 如果兄弟是右孩子，右侄子是红，则RR不平衡
                else if (!brother.isLeftChild() && isRed(brother.right)) {
                    leftRotate(parent);
                    brother.right.color = BLACK;
                    brother.color = parent.color;
                }
                // 5.4 如果兄弟是右孩子，左侄子是红，则RL不平衡
                else{
                    brother.left.color = parent.color;
                    rightRotate(brother);
                    leftRotate(parent);

                }

                parent.color = BLACK;
            }
        } else {
            fixDoubleBlack(parent);
        }


    }

    // 删除
    // 正常删除，会用到李代桃僵技巧、遇到黑黑不平衡进行调整
    public void remove(int key) {
        Node deletedNode = find(key);
        // 如果未找到待删除节点，则删除程序结束
        if (deletedNode == null) {
            return;
        }
        // 递归删除节点
        doRemove(deletedNode);
    }

    // 递归删除节点
    private void doRemove(Node deletedNode) {
        // 找到删除节点后的剩余节点
        Node replaced = findReplaced(deletedNode);
        // 删除节点的父亲
        Node parent = deletedNode.parent;
        // 删除节点没有孩子
        if (replaced == null) {
            // TODO: 情况1：被删除节点为根节点
            if (deletedNode == root) {
                root = null;
            } else {
                // TODO: 情况3、4、5：如果删除节点为黑色，则需进行复杂调整
                if (isBlack(deletedNode)) {
                    // 复杂处理
                    fixDoubleBlack(deletedNode);
                } else {
                    // TODO: 情况2：删的是黑节点，剩下的是红节点，无需任何处理
                }
                // 被删除节点不是根节点
                // 被删除的节点是父亲的左孩子
                if (deletedNode.isLeftChild()) {
                    parent.left = null;
                } else {
                    // 被删除的节点是父亲的右孩子
                    parent.right = null;
                }
                deletedNode.parent = null;

            }

            return;
        }

        // 删除节点有一个孩子
        if (deletedNode.left == null || deletedNode.right == null) {
            // TODO: 情况1：被删除节点为根节点
            if (root == deletedNode) {
                root.key = replaced.key;
                root.value = replaced.value;
                root.left = null;
                root.right = null;
            } else {
                // 被删除节点不是根节点
                if (deletedNode.isLeftChild()) {
                    // 被删除的节点是父亲的左孩子
                    parent.left = replaced;
                } else {
                    // 被删除的节点是父亲的右孩子
                    parent.right = replaced;
                }
                replaced.parent = parent;
                deletedNode.left = null;
                deletedNode.right = null;
                deletedNode.parent = null;
                // TODO: 情况3、4、5：如果删除的节点为黑色，且剩下的节点也为黑色
                if (isBlack(deletedNode) && isBlack(replaced)) {
                    // 复杂处理
                    fixDoubleBlack(replaced);
                } else {
                    // TODO: 情况2：删的是黑节点，剩下的是红节点
                    replaced.color = BLACK;
                }

            }

            return;
        }

        // TODO: 情况0：删除节点有两个孩子，使用李代桃僵技巧
        // 就是说，我们要删的节点有左右两个孩子，不好删，
        // 所以我们把原本删除后要代替删除节点的节点（也就是剩余节点）的键和值直接给要删除的节点，然后删除那个要代替节点（剩余节点）就行了
        // 交换两个节点的键
        int tempK = deletedNode.key;
        deletedNode.key = replaced.key;
        replaced.key = tempK;
        // 交换两个节点的值
        Object tempV = deletedNode.value;
        deletedNode.value = replaced.value;
        replaced.value = tempV;
        // 递归删除代替节点
        doRemove(replaced);

    }

    // 查找指定节点
    private Node find(int key) {
        Node thisNode = root;
        while (thisNode != null) {
            if (key < thisNode.key) {
                thisNode = thisNode.left;
            } else if (key > thisNode.key) {
                thisNode = thisNode.right;
            } else {
                return thisNode;
            }
        }
        return null;
    }

    // 查找删除节点后剩余节点
    private Node findReplaced(Node deleted) {
        // 如果删除的节点没有左右孩子，那就没有剩余节点
        if (deleted.left == null && deleted.right == null) {
            return null;
        }
        // 如果删除的节点没有左孩子，那剩余节点就为右孩子
        if (deleted.left == null) {
            return deleted.right;
        }
        // 如果删除的节点没有右孩子，那剩余节点就为左孩子
        if (deleted.right == null) {
            return deleted.left;
        }
        // 如果左右孩子都有，那剩余节点就是删除节点的后继节点
        Node thisNode = deleted.right;
        while (thisNode.left != null) {
            thisNode = thisNode.left;
        }
        return thisNode;
    }

    // 判断节点为红
    private boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

    // 判断节点为黑
    private boolean isBlack(Node node) {
        return node == null || node.color == BLACK;
    }

    // 左旋
    private void leftRotate(Node node) {
        Node parent = node.parent;  // 获取待旋转节点的上层节点
        Node rightNode = node.right;  // 待旋转节点的右孩子
        Node changeFatherNode = rightNode.left;  // 待换爹的节点

        rightNode.left = node;  // 待旋转节点的右孩子上旋
        rightNode.parent = parent;  // 修改待旋转节点的右孩子的parent
        node.parent = rightNode;  // 修改待旋转节点的parent

        node.right = changeFatherNode;  // 待换爹节点换爹
        if (changeFatherNode != null) {
            changeFatherNode.parent = node;  // 修改待换爹的节点的parent
        }

        // 处理上层节点与待旋转节点的关系（待旋转节点的右孩子变为上层节点的孩子）
        if (parent == null) {
            // 表明待旋转节点为根节点
            root = rightNode;
        } else if (parent.left == node) {
            parent.left = rightNode;
        } else {
            parent.right = rightNode;
        }

    }

    // 右旋
    private void rightRotate(Node node) {
        Node parent = node.parent;  // 获取待旋转节点的上层节点
        Node leftNode = node.left; // 待旋转节点的左孩子
        Node changeFatherNode = leftNode.right;  // 待换爹的节点

        leftNode.right = node;  // 待旋转节点的左孩子上旋
        leftNode.parent = parent;  // 修改待旋转节点的左孩子的parent
        node.parent = leftNode;  // 修改待旋转节点的parent

        node.left = changeFatherNode;  // 待换爹节点换爹
        if (changeFatherNode != null) {
            changeFatherNode.parent = node;  // 修改待换爹的节点的parent
        }

        // 处理上层节点与待旋转节点的关系（待旋转节点的左孩子变为上层节点的孩子）
        if (parent == null) {
            // 表明待旋转节点为根节点
            root = leftNode;
        } else if (parent.left == node) {
            parent.left = leftNode;
        } else {
            parent.right = leftNode;
        }

    }
}
