package chapter3.stack_queue;

public class ArrayQueue<T> implements Queue<T> {
    private MyArray<T> array;

    public ArrayQueue(int capacity) {
        array = new MyArray<>(capacity);
    }

    public ArrayQueue() {
        array = new MyArray<>();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void enqueue(T element) {
        array.addLast(element);
    }

    @Override
    public T dequeue() {
        return array.deleteFirst();
    }

    @Override
    public T getFront() {
        return array.getElement(0);
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
        StringBuilder res = new StringBuilder();
        res.append("Queue: font -> [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.getElement(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] <- tail");
        return res.toString();
    }
}
