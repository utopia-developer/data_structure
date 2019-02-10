package chapter2.stack_queue;

public interface Queue<T> {
    void enqueue(T element);

    T dequeue();

    T getFront();

    int getSize();

    boolean isEmpty();
}
