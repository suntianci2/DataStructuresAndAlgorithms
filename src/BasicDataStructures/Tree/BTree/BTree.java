package BasicDataStructures.Tree.BTree;

import java.util.Arrays;

/**
 * @ClassName BTree
 * @Author 孙天赐
 * @Date 2025/3/13 14:36
 * @Description TODO: B树
 */
public class BTree {

    static class Node {
        // 关键字
        int[] keys;

        // 孩子
        Node[] children;

        // 有效关键字数量
        int keyNumber;

        // 是否是叶子节点
        boolean isLeaf;

        // 最小度数
        int t;

        public Node(int t) {  // t>=2
            this.t = t;
            keys = new int[2 * t - 1];
            children = new Node[2 * t];
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(keys, 0, keyNumber));
        }

        // 多路查找
        Node get(int key) {
            int i = 0;
            while (i < keyNumber) {
                // 找到当前key
                if (keys[i] == key) {
                    return this;
                }
                // 没找到
                if (keys[i] > key) {
                    break;
                }
            }
            // 如果是叶子节点，也没找到
            if (isLeaf) {
                return null;
            }
            // 如果是非叶子节点，也没找到，则递归进孩子节点查找
            return children[i].get(key);
        }

        // 向keys指定索引处插入key
        void insertKey(int key, int index) {
            // 从后往前移动元素
            for (int i = keyNumber; i > index; i--) {
                keys[i] = keys[i - 1];
            }
            keys[index] = key;

            // 有效关键字数量加1
            keyNumber++;
        }

        // 向children指定索引处插入child
        void insertChild(Node child, int index) {
            // 从后往前移动元素
            for (int i = keyNumber; i > index; i--) {
                children[i] = children[i - 1];
            }
            children[index] = child;
            // 此处有效关键字数量不用加1，因为加入key的时候有效关键字数量会加1
        }

        // 移除指定index处的key
        int removeKey(int index) {
            int t = keys[index];
            // 从前往后移动元素
            for (int i = index; i < keyNumber - 1; i++) {
                keys[i] = keys[i + 1];
            }
            // 有效关键字数量减1
            keyNumber--;
            return t;
        }

        // 移除最左边的key
        int removeLeftmostKey() {
            return removeKey(0);
        }

        // 移除最右边的key
        int removeRightmostKey() {
            return removeKey(keyNumber - 1);
        }

        // 移除指定index处的child
        Node removeChild(int index) {
            Node t = children[index];
            // 从前往后移动元素
            for (int i = index; i < keyNumber; i++) {
                children[i] = children[i + 1];
            }
            return t;
        }

        // 移除最左边的child
        Node removeLeftmostChild() {
            return removeChild(0);
        }

        // 移除最右边的child
        Node removeRightmostChild() {
            return removeChild(keyNumber);
        }

        // index 孩子处左边的兄弟
        Node childLeftSibling(int index) {
            return index > 0 ? children[index - 1] : null;
        }

        // index 孩子处右边的兄弟
        Node childRightSibling(int index) {
            return index == keyNumber ? null : children[index + 1];
        }

        // 复制当前节点的所有key和child到target
        void moveToTarget(Node target) {
            int start = target.keyNumber;
            if (!isLeaf) {
                for (int i = 0; i <= keyNumber; i++) {
                    target.children[start + i] = children[i];
                }
            }
            for (int i = 0; i < keyNumber; i++) {
                target.keys[target.keyNumber++] = keys[i];
            }
        }
    }

    // 根节点
    Node root;

    // 树中节点的最小度数
    int t;

    // 最小的关键字数量，每个节点至少要包含 t - 1 个关键字
    final int MIN_KEY_NUMBER;

    // 最大的关键字数量，每个节点至多包含 2t - 1 个关键字
    final int MAX_KEY_NUMBER;

    public BTree() {
        this(2);
    }

    public BTree(int t) {
        this.t = t;
        root = new Node(t);
        MAX_KEY_NUMBER = 2 * t - 1;
        MIN_KEY_NUMBER = t - 1;
    }

    // 判断一个key是否存在
    public boolean contains(int key) {
        return root.get(key) != null;
    }

    // 新增一个key
    // 首先查找本届点中的插入位置i，如果没有空位（key被找到），应该走更新的逻辑，目前什么没做
    // 接下来分两种情况
    // 1. 如果当前节点是叶子节点，直接插入
    // 2. 如果当前节点是非叶子节点，需要继续在children[i]处递归插入
    // 无论哪种情况，插入完成后，都需要检查当前节点的key数量，如果超过了最大的关键字数量，需要进行分裂
    public void put(int key) {
        doPut(root, key, null, 0);

    }

    // 递归插入key
    private void doPut(Node node, int key, Node parent, int index) {
        // 1. 找到当前节点的插入位置
        int i = 0;
        while (i < node.keyNumber) {
            if (node.keys[i] == key) {
                // 如果找到了key，直接返回
                return;
            }
            if (node.keys[i] > key) {
                // 找到了插入位置，跳出循环
                break;
            }
            i++;
        }
        // 2. 如果当前节点是叶子节点，直接插入
        if (node.isLeaf) {
            node.insertKey(key, i);
        } else {
            // 3. 如果当前节点是非叶子节点，需要继续在children[i]处递归插入
            doPut(node.children[i], key, node, i);
        }
        // 上限检查
        if (node.keyNumber == MAX_KEY_NUMBER) {
            // 4. 如果当前节点的key数量达到了最大的关键字数量，需要进行分裂
            split(node, parent, index);
        }
    }

    // 分裂
    private void split(Node left, Node parent, int index) {
        // 分裂的节点是根节点，需要多做的事情
        if (parent == null) {
            Node newRoot = new Node(t);
            newRoot.isLeaf = false;
            newRoot.insertChild(left, 0);
            this.root = newRoot;
            parent = newRoot;
        }
        // 1.创建一个新节点right，将left的后t-1个关键字和孩子节点移动到新节点中
        Node right = new Node(t);
        // 新节点是否为叶子节点，与left相同
        right.isLeaf = left.isLeaf;
        // 将left的后t-1个关键字移动到right中
        for (int i = 0; i < MIN_KEY_NUMBER; i++) {
            right.keys[i] = left.keys[i + t];
        }
        // 分裂节点时非叶子节点的情况
        if (!left.isLeaf) {
            // 将left的后t个孩子节点移动到right中
            for (int i = 0; i < t; i++) {
                right.children[i] = left.children[i + t];
            }
        }
        // 设置有效key的数目
        right.keyNumber = MIN_KEY_NUMBER;
        left.keyNumber = MIN_KEY_NUMBER;

        // 2. t-1处的key插入到parent的index处，index指left作为孩子时的索引
        parent.insertKey(left.keys[t - 1], index);

        // 3. right作为parent的孩子插入到index+1处
        parent.insertChild(right, index + 1);
    }

    // 删除一个key
    public void remove(int key) {
        doRemove(null, root, 0, key);
    }

    // 递归删除key
    private void doRemove(Node parent, Node node, int index, int key) {
        int i = 0;
        while (i < node.keyNumber) {
            // 找到key，或者找到了可能存在该key的孩子节点
            if (node.keys[i] >= key) {
                break;
            }
            i++;
        }
        if (node.isLeaf) {
            if (!found(node, key, i)) {
                // 情况1：是叶子节点，并且没找到key，结束
                return;
            } else {
                // 情况2：是叶子节点，并且找到了key，直接删除
                node.removeKey(i);
            }
        } else {
            if (!found(node, key, i)) {
                // 情况3：不是叶子节点，并且没找到key，到第i个孩子节点中递归删除
                doRemove(node, node.children[i], i, key);
            } else {
                // 情况4：不是叶子节点，并且找到了key，使用李代桃僵思路，用后继节点替换当前节点，并删除原来的后继节点
                // 1. 找到后继节点
                Node successor = node.children[i + 1];
                while (!successor.isLeaf) {
                    successor = successor.children[0];
                }
                int successorKey = successor.keys[0];
                // 2. 替换待删除的key
                node.keys[i] = successorKey;
                // 3. 递归删除后继节点
                doRemove(node, node.children[i + 1], i + 1, successorKey);

            }
        }
        if (node.keyNumber < MIN_KEY_NUMBER) {
            // 情况5、6：当不平衡了，需要重新调整平衡
            balance(parent, node, index);
        }

    }

    // 调整平衡 parent 是 x 的父节点，i 是 x 在 parent 中的索引
    private void balance(Node parent, Node x, int i) {
        // 情况6：根节点
        if (x == root) {
            // 如果根节点没有key，并且有孩子，将孩子作为根节点
            if (root.keyNumber == 0 && root.children[0] != null) {
                root = root.children[0];
            }
            return;
        }

        Node left = parent.childLeftSibling(i); // 找到左边的兄弟
        Node right = parent.childRightSibling(i);  // 找到右边的兄弟
        if (left != null && left.keyNumber > MIN_KEY_NUMBER) {
            // 情况5-1：左边富裕，右旋
            // a) 父节点中前驱key旋转下来
            x.insertKey(parent.keys[i - 1], 0);
            // b) 如果x不是叶子节点，需要将left的最右边的孩子节点移动到x的最左边
            if (!left.isLeaf) {
                x.insertChild(left.removeRightmostChild(), 0);
            }
            // c) left中最大的key旋转上去
            parent.keys[i - 1] = left.removeRightmostKey();
            return;
        }

        if (right != null && right.keyNumber > MIN_KEY_NUMBER) {
            // 情况5-2：右边富裕，左旋
            // a) 父节点中后继key旋转下来
            x.insertKey(parent.keys[i], x.keyNumber);
            // b) 如果x不是叶子节点，需要将right的最左边的孩子节点移动到x的最右边
            if (!right.isLeaf) {
                x.insertChild(right.removeLeftmostChild(), x.keyNumber + 1);
            }
            // c) right中最小的key旋转上去
            parent.keys[i] = right.removeLeftmostKey();
            return;
        }

        // 情况5-3：两边都不够借，向左合并
        if (left != null) {
            // 向左兄弟合并
            parent.removeChild(i);
            left.insertKey(parent.removeKey(i - 1), left.keyNumber);
            x.moveToTarget(left);
        } else {
            // 向自己合并
            parent.removeChild(i + 1);
            x.insertKey(parent.removeKey(i), x.keyNumber);
            right.moveToTarget(x);
        }
    }

    // 判断是否找到key
    private boolean found(Node node, int key, int i) {
        return i < node.keyNumber && node.keys[i] == key;

    }

}
