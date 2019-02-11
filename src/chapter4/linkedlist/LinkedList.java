package chapter4.linkedlist;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
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

    /**
     * 虚拟头节点
     */
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

//        head = new Node(e, head);

        add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add() failed, index illegally.");
        }
//        if (index == 0) {
//            addFirst(e);
//        } else {
        Node previous = dummyHead;
        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }
//            Node node = new Node(e);
//            node.next = previous.next;
//            previous.next = node;
        previous.next = new Node(e, previous.next);
//        }
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get() failed, index illegally.");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("set() failed, index illegally");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    public boolean contains(E e) {
        Node current = dummyHead.next;
//        for (int i = 0; i < size; i++) {
//            if (current.e == e) {
//                return true;
//            }
//            current = current.next;
//        }
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    public E delete(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("delete() failed, index illegally");
        }
        Node previous = dummyHead;
        for (int i = 0; i < index; i++) {
            previous = previous.next;
        }
        Node resultNode = previous.next;
        previous.next = resultNode.next;
        resultNode.next = null;
        size--;
        return resultNode.e;
    }

    public E deleteFirst() {
        return delete(0);
    }

    public E deleteLast() {
        return delete(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        Node current = dummyHead.next;
//        while (current != null) {
//            res.append(current + " -> ");
//            current = current.next;
//        }
        for (Node current = dummyHead.next; current != null; current = current.next) {
            res.append(current + " -> ");
        }
        res.append("NULL");
        return res.toString();
    }
}
