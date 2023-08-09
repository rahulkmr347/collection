package collections.customStack;

import java.util.LinkedList;

public class CustomStack<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void push(T item) {
        list.addLast(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return list.removeLast();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        CustomStack<Integer> stack = new CustomStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack size: " + stack.size()); // Output: Stack size: 3
        System.out.println("Top element: " + stack.peek()); // Output: Top element: 30

        System.out.println("Pop: " + stack.pop()); // Output: Pop: 30
        System.out.println("Stack size after pop: " + stack.size()); // Output: Stack size after pop: 2
    }
}

