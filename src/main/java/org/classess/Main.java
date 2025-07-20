package org.classess;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(5);
        stack.push(10);
        System.out.println("Stack pop: " + stack.pop()); // 10

        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        System.out.println("Queue dequeue: " + queue.dequeue()); // A

        MyMinHeap heap = new MyMinHeap();
        heap.add(5);
        heap.add(2);
        heap.add(8);
        System.out.println("MinHeap poll: " + heap.poll()); // 2
    }
}