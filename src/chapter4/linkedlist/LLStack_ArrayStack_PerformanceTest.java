package chapter4.linkedlist;

import chapter3.stack_queue.ArrayStack;
import chapter3.stack_queue.Stack;

import java.util.Random;

public class LLStack_ArrayStack_PerformanceTest {

    public static double testStackTime(Stack<Integer> stack, int number) {
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < number; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < number; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        final int OPERATION_NUMBER = 10000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double arrayStackTime = testStackTime(arrayStack, OPERATION_NUMBER);
        System.out.println("ArrayQueue Operation Time = " + arrayStackTime + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double linkedListStackTime = testStackTime(linkedListStack, OPERATION_NUMBER);
        System.out.println("LoopQueue Operation Time = " + linkedListStackTime + " s");
    }
}
