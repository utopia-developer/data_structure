package chapter2.stack_queue;

public interface Stack<T> {
    /**
     * 实现入栈的push()操作
     * @param element 元素
     */
    void push(T element);

    /**
     * 实现出栈的pop()操作
     * @return 被出栈的元素
     */
    T pop();

    /**
     * 实现查看栈顶元素的peek()操作
     * @return 栈顶元素
     */
    T peek();

    /**
     * 得到栈中的元素个数
     * @return 栈中现有的元素个数
     */
    int getSize();

    /**
     * 判断栈是否为空
     * @return 判断后的布尔值
     */
    boolean isEmpty();
}
