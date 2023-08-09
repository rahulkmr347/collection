package collections.custom_hash_map;

class CustomHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private int size;
    private int capacity;
    private Entry<K, V>[] table;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        this.capacity = INITIAL_CAPACITY;
        this.table = new Entry[capacity];
    }

    public void put(K key, V value) {
        if (size + 1 > capacity * LOAD_FACTOR) {
            expandTable();
        }

        int index = getIndexForKey(key);
        Entry<K, V> newEntry = new Entry<>(key, value);
        if (table[index] == null) {
            table[index] = newEntry;
            size++;
        } else {
            Entry<K, V> current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = newEntry;
                size++;
            }
        }
    }

    public V get(K key) {
        int index = getIndexForKey(key);
        Entry<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    private int getIndexForKey(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    @SuppressWarnings("unchecked")
    private void expandTable() {
        capacity *= 2;
        Entry<K, V>[] newTable = new Entry[capacity];
        for (Entry<K, V> entry : table) {
            Entry<K, V> current = entry;
            while (current != null) {
                int index = getIndexForKey(current.key);
                Entry<K, V> newEntry = new Entry<>(current.key, current.value);
                if (newTable[index] == null) {
                    newTable[index] = newEntry;
                } else {
                    Entry<K, V> existing = newTable[index];
                    while (existing.next != null) {
                        existing = existing.next;
                    }
                    existing.next = newEntry;
                }
                current = current.next;
            }
        }
        table = newTable;
    }

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> customHashMap = new CustomHashMap<>();
        customHashMap.put("apple", 1);
        customHashMap.put("banana", 2);
        customHashMap.put("orange", 3);

        System.out.println(customHashMap.get("apple"));   // Output: 1
        System.out.println(customHashMap.get("grape"));   // Output: null

        customHashMap.put("apple", 4);
        System.out.println(customHashMap.get("apple"));   // Output: 4
    }
}

