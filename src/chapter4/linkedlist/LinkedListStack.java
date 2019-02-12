package chapter4.linkedlist;

import chapter3.stack_queue.Stack;

public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public void push(E element) {
        list.addFirst(element);
    }

    @Override
    public E pop() {
        return list.deleteFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top -> ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();

        for (int i = 0; i < 5; i++) {
            linkedListStack.push(i);
            System.out.println(linkedListStack);
        }

        linkedListStack.pop();
        System.out.println(linkedListStack );
    }
}
