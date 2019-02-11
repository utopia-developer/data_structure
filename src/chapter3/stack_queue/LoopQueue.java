package chapter3.stack_queue;

public class LoopQueue<T> implements Queue<T> {
    private T[] data;
    private int front, tail;
    /**
     * 队列中有多少个元素
     */
    private int size;

    public LoopQueue(int capacity) {
        data = (T[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(T element) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = element;
        tail = (tail + 1) % data.length;
        size++;
    }


    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("dequeue() is failed, the queue is empty now.");
        }
        T res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == (getCapacity() / 4) && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return res;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("getFront() is failed, the queue is empty.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size = %d, capacity = %d\nfront -> [", size, getCapacity()));
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] <- tail");
        return res.toString();
    }

    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }
}
