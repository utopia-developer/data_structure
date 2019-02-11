package chapter2.array.array;

public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Studnet(name: %s, score: %s)", name, score);
    }
}
