package collections.customQueue;

import java.util.LinkedList;

public class CustomQueue<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return list.removeFirst();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        CustomQueue<Integer> queue = new CustomQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Queue size: " + queue.size()); // Output: Queue size: 3
        System.out.println("Front element: " + queue.peek()); // Output: Front element: 10

        System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 10
        System.out.println("Queue size after dequeue: " + queue.size()); // Output: Queue size after dequeue: 2
    }
}

