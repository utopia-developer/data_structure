package chapter2.stack_queue;

/**
 * 定义ArrayStack类实现Stack<T>接口，实现动态数组栈
 * @param <T> 泛型类型
 */
public class ArrayStack<T> implements Stack<T> {

    MyArray<T> array;

    public ArrayStack(int capacity) {
        array = new MyArray<>(capacity);
    }

    public ArrayStack() {
        array = new MyArray<>();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(T element) {
        array.addLast(element);
    }

    @Override
    public T pop() {
        return array.deleteLast();
    }

    @Override
    public T peek() {
        return array.getElement(array.getSize() - 1);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stack: [");
        for (int i = 0; i < array.getSize(); i++) {
            stringBuilder.append(array.getElement(i));
            if (i != array.getSize() - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] <- top");
        return stringBuilder.toString();
    }
}
