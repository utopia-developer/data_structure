package chapter4.linkedlist;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        System.out.println("=========================================================");
        linkedList.add(2, 37);
        System.out.println(linkedList);
        System.out.println("*********************************************************");
        linkedList.delete(4);
        System.out.println(linkedList);
        linkedList.deleteFirst();
        System.out.println(linkedList);
        linkedList.deleteLast();
        System.out.println(linkedList);
    }
}
