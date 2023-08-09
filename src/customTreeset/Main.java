package customTreeset;

import java.util.Iterator;

class CustomTreeSet<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> root;

    public void add(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }

        int compareResult = value.compareTo(node.value);
        if (compareResult < 0) {
            node.left = insert(node.left, value);
        } else if (compareResult > 0) {
            node.right = insert(node.right, value);
        }

        return node;
    }

    public void displayInOrder() {
        displayInOrder(root);
    }

    private void displayInOrder(Node<T> node) {
        if (node != null) {
            displayInOrder(node.left);
            System.out.print(node.value + " ");
            displayInOrder(node.right);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new TreeSetIterator(root);
    }

    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private class TreeSetIterator implements Iterator<T> {
        private Node<T> currentNode;
        private java.util.Stack<Node<T>> stack;

        TreeSetIterator(Node<T> root) {
            currentNode = root;
            stack = new java.util.Stack<>();
            fillStack(root);
        }

        private void fillStack(Node<T> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            Node<T> node = stack.pop();
            fillStack(node.right);
            return node.value;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CustomTreeSet<Integer> customTreeSet = new CustomTreeSet<>();
        customTreeSet.add(5);
        customTreeSet.add(3);
        customTreeSet.add(8);
        customTreeSet.add(1);
        customTreeSet.add(4);
        customTreeSet.add(7);
        customTreeSet.add(9);

        System.out.print("In-order traversal: ");
        customTreeSet.displayInOrder();  // Output: 1 3 4 5 7 8 9

        System.out.print("\nIterator traversal: ");
        for (int value : customTreeSet) {
            System.out.print(value + " ");  // Output: 1 3 4 5 7 8 9
        }
    }
}

