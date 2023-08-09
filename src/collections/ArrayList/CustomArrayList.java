package collections.ArrayList;

public class CustomArrayList<T> {

    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public CustomArrayList() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(T item) {
        if (size == elements.length) {
            expandCapacity();
        }
        elements[size] = item;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    public int size() {
        return size;
    }

    private void expandCapacity() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    public static void main(String[] args) {
        CustomArrayList<String> customList = new CustomArrayList<>();
        customList.add("Hello");
        customList.add("World");

        System.out.println("Size: " + customList.size());
        System.out.println("Element at index 0: " + customList.get(0));
        System.out.println("Element at index 1: " + customList.get(1));
    }
}
