package BasicDataStructures.Stack;

public interface Stack<E> {
    // 向栈顶压入元素
    boolean push(E value);

    // 向栈顶弹出元素
    E pop();

    // 返回栈顶元素，不弹出
    E peek();

    // 判断当前栈是否为空
    boolean isEmpty();

    // 判断当前栈是否已满
    boolean isFull();
}
