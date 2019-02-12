package chapter3.stack_queue;

import chapter4.linkedlist.LinkedListQueue;

import java.util.Random;

public class QueuePerformanceTest {

    public static double testQueueTime(Queue<Integer> queue, int number) {
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < number; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < number; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        final int OPERATION_NUMBER = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double arrayQueueTime = testQueueTime(arrayQueue, OPERATION_NUMBER);
        System.out.println("ArrayQueue Operation Time = " + arrayQueueTime + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double loopQueueTime = testQueueTime(loopQueue, OPERATION_NUMBER);
        System.out.println("LoopQueue Operation Time = " + loopQueueTime + " s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double linkedListQueueTime = testQueueTime(linkedListQueue, OPERATION_NUMBER);
        System.out.println("LinkedListQueue Operation Time = " + linkedListQueueTime + " s");
    }
}
