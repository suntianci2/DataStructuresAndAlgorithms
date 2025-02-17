package BasicDataStructures.Tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName BSTree1
 * @Author 孙天赐
 * @Date 2025/1/27 14:43
 * @Description TODO: Binary Search Tree 二叉搜索树
 */
public class BSTree1 {

    BSTNode root;

    static class BSTNode {
        int key;
        Object value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int key) {
            this.key = key;

        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 根据键找到值
     *
     * @param key
     * @return
     */
    public Object get(int key) {
        // 方式一：递归
//        return doGet(root, key);

        // 方式二：迭代
        BSTNode thisNode = root;
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
     * 获取最小的key对应的值
     *
     * @return
     */
    public Object min() {
        if (root == null) {
            return null;
        }
        BSTNode thisNode = root;
        while (thisNode.left != null) {
            thisNode = thisNode.left;
        }
        return thisNode.value;
    }

    /**
     * 获取最大的key对应的值
     *
     * @return
     */
    public Object max() {
        return max(root);
    }

    /**
     * 存储键和对应的值
     *
     * @param key
     * @param value
     */
    public void put(int key, Object value) {
        BSTNode thisNode = root;
        BSTNode preNode = null;
        while (thisNode != null) {
            preNode = thisNode;
            if (key < thisNode.key) {
                // 下一轮循环向左寻找
                thisNode = thisNode.left;
            } else if (key > thisNode.key) {
                // 下一轮循环向右寻找
                thisNode = thisNode.right;
            } else {
                // 找到目标键
                thisNode.value = value;
                return;
            }
        }
        // 树中无元素
        if (preNode == null) {
            root = new BSTNode(key, value);
            return;
        }
        // 树中没有对应键
        if (key < preNode.key) {
            preNode.left = new BSTNode(key, value);
        } else {
            preNode.right = new BSTNode(key, value);
        }
    }

    /**
     * 查找key的前驱值
     *
     * @param key
     * @return
     */
    public Object predecessor(int key) {
        // 先寻找该值
        BSTNode thisNode = root; // 当前节点
        BSTNode ancestorFromLeft = null; // 自左而来的祖先节点
        while (thisNode != null) {
            if (key < thisNode.key) {
                // 向左侧寻找
                thisNode = thisNode.left;
            } else if (key > thisNode.key) {
                // 记录自左而来的祖先节点
                ancestorFromLeft = thisNode;
                // 向右侧寻找
                thisNode = thisNode.right;
            } else {
                // 找到该值
                break;
            }
        }

        // 未找到该值
        if (thisNode == null) {
            return null;
        }

        // 找到该值
        // 如果该节点存在左子树，则该节点前驱值为左子树的最大key对应的值
        // 如果该节点不存在左子树，则该节点前驱值为离他最近、自左而来的祖先的值
        if (thisNode.left != null) {
            // 左子树的最大key对应值
            return max(thisNode.left);
        } else {
            // 离该节点最近、自左而来的祖先的值
            return ancestorFromLeft != null ? ancestorFromLeft.value : null;
        }

    }

    /**
     * 查找key的后继值
     *
     * @param key
     * @return
     */
    public Object successor(int key) {
        // 先寻找该值
        BSTNode thisNode = root; // 当前节点
        BSTNode ancestorFromRight = null; // 自右而来的祖先节点
        while (thisNode != null) {
            if (key < thisNode.key) {
                // 记录自右而来的祖先节点
                ancestorFromRight = thisNode;
                // 向左侧寻找
                thisNode = thisNode.left;
            } else if (key > thisNode.key) {
                // 向右侧寻找
                thisNode = thisNode.right;
            } else {
                // 找到该值
                break;
            }
        }

        // 未找到该值
        if (thisNode == null) {
            return null;
        }

        // 找到该值
        // 如果该节点存在右子树，则该节点前驱值为右子树的最大key对应的值
        // 如果该节点不存在右子树，则该节点前驱值为离他最近、自右而来的祖先的值
        if (thisNode.right != null) {
            // 右子树的最小key对应值
            return min(thisNode.right);
        } else {
            // 离该节点最近、自右而来的祖先的值
            return ancestorFromRight != null ? ancestorFromRight.value : null;
        }
    }

    /**
     * 根据key删除
     *
     * @param key
     * @return
     */
    public Object delete(int key) {
        // 找到当前key节点及其父亲
        BSTNode thisNode = root;
        BSTNode parentNode = null;
        while (thisNode != null) {
            if (key < thisNode.key) {
                // 记录祖先节点
                parentNode = thisNode;
                // 向左侧寻找
                thisNode = thisNode.left;
            } else if (key > thisNode.key) {
                // 记录祖先节点
                parentNode = thisNode;
                // 向右侧寻找
                thisNode = thisNode.right;
            } else {
                // 找到该值
                break;
            }
        }
        if (thisNode.left == null) {
            // 待删除节点没有左孩子，将右孩子给parent
            shift(parentNode, thisNode, thisNode.right);
        } else if (thisNode.right == null) {
            // 待删除节点没有右孩子，将左孩子给parent
            shift(parentNode, thisNode, thisNode.left);
        } else {
            // 待删除的节点既有左孩子，也有右孩子
            // 1. 找到被删除节点的后继节点
            BSTNode successorNode = thisNode.right;  // 后继
            BSTNode successorParentNode = null;  // 后继的父亲
            // 1.1 从右子树中找最小key对应节点即可
            while (successorNode.left != null) {
                successorParentNode = successorNode;
                successorNode = successorNode.left;
            }
            // 2. 如果删除节点和后继节点不相邻，则处理后继的后事
            if (successorParentNode != thisNode) {
                // 2.1 因为successorNode为thisNode的后继，所以successorNode肯定没有左孩子（如果有，那successorNode不会成为后继）
                shift(successorParentNode, successorNode, successorNode.right);
                // 2.2 调整新节点（只调整新节点的右孩子，左孩子在下面调整）
                successorNode.right = thisNode.right;
            }
            // 3. 后继取代被删除节点
            // 3.1 将后继放到被删除节点位置
            shift(parentNode, thisNode, successorNode);
            // 3.2 调整新节点（只需调整新节点的左孩子，部分情况需要调整右孩子，已在上面调整）
            successorNode.left = thisNode.left;
        }
        return thisNode.value;
    }

    /**
     * get方法的递归实现
     *
     * @param node
     * @param key
     * @return
     */
    private Object doGet(BSTNode node, int key) {
        // 未找到目标
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            // 向左边查找
            return doGet(node.left, key);
        } else if (key > node.key) {
            // 向右边查找
            return doGet(node.right, key);
        } else {
            // 找到目标
            return node.value;
        }
    }

    /**
     * 寻找以指定节点为根节点下的树的最大key对应的值
     *
     * @param node
     * @return
     */
    private Object max(BSTNode node) {
        if (node == null) {
            return null;
        }
        BSTNode thisNode = node;
        while (thisNode.right != null) {
            thisNode = thisNode.right;
        }
        return thisNode.value;
    }

    /**
     * 寻找以指定节点为根节点下的树的最小key对应的值
     *
     * @param node
     * @return
     */
    private Object min(BSTNode node) {
        if (node == null) {
            return null;
        }
        BSTNode thisNode = node;
        while (thisNode.left != null) {
            thisNode = thisNode.left;
        }
        return thisNode.value;
    }

    /**
     * 删除节点后的移动节点
     *
     * @param parentNode  被删除节点的父亲
     * @param deletedNode 被删除的节点
     * @param childNode   被顶上去的节点
     */
    private void shift(BSTNode parentNode, BSTNode deletedNode, BSTNode childNode) {
        // 待删除结点为根节点
        if (parentNode == null) {
            root = childNode;
        } else if (deletedNode == parentNode.left) {
            parentNode.left = childNode;
        } else {
            parentNode.right = childNode;
        }

    }

    /**
     * 找到所有key小于给定key的所有值
     *
     * @param key
     * @return
     */
    public List<Object> less(int key) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode thisNode = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        // 中序遍历
        while (thisNode != null || !stack.isEmpty()) {
            if (thisNode != null) {
                stack.push(thisNode);
                thisNode = thisNode.left;
            } else {
                BSTNode pop = stack.pop();
                // 处理值
                if (pop.key < key) {
                    result.add(pop.value);
                } else {
                    break;
                }
                thisNode = pop.right;

            }
        }
        return result;
    }

    /**
     * 找到所有key大于给定key的所有值
     *
     * @param key
     * @return
     */
    public List<Object> greater(int key) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode thisNode = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        //  反向中序遍历
        while (thisNode != null || !stack.isEmpty()) {
            if (thisNode != null) {
                stack.push(thisNode);
                thisNode = thisNode.right;
            } else {
                BSTNode pop = stack.pop();
                // 处理值
                if(pop.key > key){
                    result.add(pop.value);
                }else{
                    break;
                }
                thisNode = pop.left;

            }
        }
        return result;
    }

    /**
     * 找到所有key介于给定key1和key2的所有值
     *
     * @param key1
     * @param key2
     * @return
     */
    public List<Object> between(int key1, int key2) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode thisNode = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        // 中序遍历
        while (thisNode != null || !stack.isEmpty()) {
            if (thisNode != null) {
                stack.push(thisNode);
                thisNode = thisNode.left;
            } else {
                BSTNode pop = stack.pop();
                // 处理值
                if(pop.key >= key1 && pop.key <= key2){
                    result.add(pop.value);
                }else if(pop.key > key2){
                    break;
                }
                thisNode = pop.right;

            }
        }
        return result;
    }

}
