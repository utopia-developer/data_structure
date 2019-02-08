package chapter1.array;

public class MyArrayTest_Dynamic {
    public static void main(String[] args) {
        MyArray<Integer> array = new MyArray<>();

        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(2, 100);
        System.out.println(array);

        array.addFirst(-2);
        System.out.println(array);
        System.out.println("=====================================");

        array.delete(11);
        array.delete(10);
        array.delete(9);
        System.out.println(array);
    }
}
