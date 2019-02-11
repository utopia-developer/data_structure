package chapter2.array.array;

public class MyArrayTest_Generic {
    public static void main(String[] args) {
        MyArray<Student> stuArray = new MyArray<>();
        stuArray.addLast(new Student("A", 100));
        stuArray.addLast(new Student("B", 85));
        stuArray.addLast(new Student("C", 60));
        System.out.println(stuArray);
    }
}
