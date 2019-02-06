package chapter1.array;

public class MyArrayTest {
    public static void main(String[] args) {
        MyArray array = new MyArray(20);
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
        System.out.println("***********************************");
        MyArray arr = new MyArray(3);
        arr.setElement(0, 1);
//        arr.setElement(1, 0);
//        arr.setElement(2, 1);
        System.out.println(arr);
        System.out.println(arr.find(1));
        arr.deleteElement(1);
        System.out.println(arr);
    }
}
