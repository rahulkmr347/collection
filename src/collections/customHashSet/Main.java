package collections.customHashSet;

class CustomHashSet<T> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private int size;
    private int capacity;
    private Object[] table;

    public CustomHashSet() {
        this.capacity = INITIAL_CAPACITY;
        this.table = new Object[capacity];
    }

    public void add(T element) {
        if (size + 1 > capacity * LOAD_FACTOR) {
            expandTable();
        }

        int hash = element.hashCode() % capacity;
        if (table[hash] == null) {
            table[hash] = element;
            size++;
        }
    }

    public boolean contains(T element) {
        int hash = element.hashCode() % capacity;
        return table[hash] != null && table[hash].equals(element);
    }

    public void remove(T element) {
        int hash = element.hashCode() % capacity;
        if (table[hash] != null && table[hash].equals(element)) {
            table[hash] = null;
            size--;
        }
    }

    private void expandTable() {
        capacity *= 2;
        Object[] newTable = new Object[capacity];
        for (Object element : table) {
            if (element != null) {
                int hash = element.hashCode() % capacity;
                newTable[hash] = element;
            }
        }
        table = newTable;
    }
}

public class Main {
    public static void main(String[] args) {
        CustomHashSet<String> customHashSet = new CustomHashSet<>();
        customHashSet.add("apple");
        customHashSet.add("banana");
        customHashSet.add("orange");

        System.out.println(customHashSet.contains("apple")); // Output: true
        System.out.println(customHashSet.contains("grape")); // Output: false

        customHashSet.remove("banana");
        System.out.println(customHashSet.contains("banana")); // Output: false
    }
}

