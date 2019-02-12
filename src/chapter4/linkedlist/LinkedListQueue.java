package chapter4.linkedlist;

import chapter3.stack_queue.Queue;

/**
 * head出队，tail入队
 *
 * @param <E>
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, LinkedListQueue.Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E element) {
        if (tail == null) {
            tail = new Node(element);
            head = tail;
        } else {
            tail.next = new Node(element);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("dequeue() failed, LinkedListQueue is empty.");
        }
        Node res = head;
        head = head.next;
        res.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return res.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("getFront() failed, LinkedListQueue is empty.");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedListQueue: front -> [");
        Node current = head;
        while (current != null) {
            res.append(current.e + " -> ");
            current = current.next;
        }
        res.append("NULL] <- tail");
        return res.toString();
    }


    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();

        for (int i = 0; i < 10; i++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);

            if (i % 3 == 2) {
                linkedListQueue.dequeue();
                System.out.println(linkedListQueue);
            }
        }
    }
}
