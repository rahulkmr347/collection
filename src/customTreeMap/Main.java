package customTreeMap;

import java.util.Iterator;
import java.util.Map;

class CustomTreeMap<K extends Comparable<K>, V> implements Iterable<K> {
    private Node<K, V> root;

    public void put(K key, V value) {
        root = insert(root, key, value);
    }

    private Node<K, V> insert(Node<K, V> node, K key, V value) {
        if (node == null) {
            return new Node<>(key, value);
        }

        int compareResult = key.compareTo(node.key);
        if (compareResult < 0) {
            node.left = insert(node.left, key, value);
        } else if (compareResult > 0) {
            node.right = insert(node.right, key, value);
        } else {
            node.value = value;  // Update existing key's value
        }

        return node;
    }

    public V get(K key) {
        Node<K, V> node = find(root, key);
        return node != null ? node.value : null;
    }

    private Node<K, V> find(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        int compareResult = key.compareTo(node.key);
        if (compareResult < 0) {
            return find(node.left, key);
        } else if (compareResult > 0) {
            return find(node.right, key);
        } else {
            return node;
        }
    }

    @Override
    public Iterator<K> iterator() {
        return new TreeMapIterator(root);
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private class TreeMapIterator implements Iterator<K> {
        private Node<K, V> currentNode;
        private java.util.Stack<Node<K, V>> stack;

        TreeMapIterator(Node<K, V> root) {
            currentNode = root;
            stack = new java.util.Stack<>();
            fillStack(root);
        }

        private void fillStack(Node<K, V> node) {
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
        public K next() {
            Node<K, V> node = stack.pop();
            fillStack(node.right);
            return node.key;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CustomTreeMap<Integer, String> customTreeMap = new CustomTreeMap<>();
        customTreeMap.put(5, "five");
        customTreeMap.put(3, "three");
        customTreeMap.put(8, "eight");
        customTreeMap.put(1, "one");
        customTreeMap.put(4, "four");
        customTreeMap.put(7, "seven");
        customTreeMap.put(9, "nine");

        System.out.println("Value for key 4: " + customTreeMap.get(4)); // Output: four

        System.out.print("Key iterator traversal: ");
        for (int key : customTreeMap) {
            System.out.print(key + " ");  // Output: 1 3 4 5 7 8 9
        }
    }
}

