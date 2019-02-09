package chapter2.stack_queue;

public interface Queue<T> {
    void enqueue(T element);

    T dequeue();

    T getFont();

    int getSize();

    boolean isEmpty();
}
