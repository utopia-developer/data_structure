package chapter4.linkedlist;

public interface Queue<T> {
    void enqueue(T element);

    T dequeue();

    T getFront();

    int getSize();

    boolean isEmpty();
}
