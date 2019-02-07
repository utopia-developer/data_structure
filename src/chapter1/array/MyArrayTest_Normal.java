package chapter1.array;

public class MyArrayTest_Normal {
    public static void main(String[] args) {
        MyArray<Integer> array = new MyArray<>(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.add(1, 100);
        System.out.println(array);
        array.addFirst(-1);
        System.out.println(array);
        System.out.println("============================");

        array.delete(3);
        System.out.println(array);
        array.deleteElement(4);
        System.out.println(array);
        array.deleteLast();
        System.out.println(array);
    }
}
